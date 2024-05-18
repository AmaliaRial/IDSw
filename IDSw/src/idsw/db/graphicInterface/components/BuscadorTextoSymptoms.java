package idsw.db.graphicInterface.components;

import idsw.db.jdbc.*;
import idsw.db.pojos.Symptom;
import idsw.db.pojos.Treatment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BuscadorTextoSymptoms extends JPanel {

    private JTextField textField;
    private RoundedButton buscarButton;
    private JList<String> resultadosList;
    private DefaultListModel<String> listModel;
    private JScrollPane scrollPane;
    private JPanel panelSelecciones;
    private Set<String> seleccionesActuales;
    private ConnectionManager conMan;

    public BuscadorTextoSymptoms() {
        this.conMan = new ConnectionManager();
        // Configuración del JPanel
        setLayout(new BorderLayout());

        // Panel para la barra de búsqueda y el botón
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new BorderLayout());

        // JTextField para la búsqueda
        textField = new JTextField();
        panelBusqueda.add(textField, BorderLayout.CENTER);

        // Botón de búsqueda
        buscarButton = new RoundedButton("Buscar", Color.decode("#09A8E4"));
        buscarButton.setPreferredSize(new Dimension(90, 30));
        panelBusqueda.add(buscarButton, BorderLayout.EAST);

        // Añadir el panel de búsqueda al JPanel
        add(panelBusqueda, BorderLayout.NORTH);

        // Modelo para la lista de resultados
        listModel = new DefaultListModel<>();

        // JList para mostrar los resultados
        resultadosList = new JList<>(listModel);

        // JScrollPane para permitir el scroll en la lista
        scrollPane = new JScrollPane(resultadosList);
        add(scrollPane, BorderLayout.CENTER);

        // Panel para las selecciones
        panelSelecciones = new JPanel();
        panelSelecciones.setLayout(new BoxLayout(panelSelecciones, BoxLayout.Y_AXIS));
        add(panelSelecciones, BorderLayout.SOUTH);

        // Inicializar el conjunto de selecciones actuales
        seleccionesActuales = new HashSet<>();

        // Acción del botón de búsqueda
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarTexto();
            }
        });

        // Añadir MouseListener para detectar doble clic en la lista
        resultadosList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = resultadosList.locationToIndex(e.getPoint());
                    if (index != -1) {
                        String selectedValue = resultadosList.getModel().getElementAt(index);
                        if (!seleccionesActuales.contains(selectedValue)) {
                            agregarSeleccion(selectedValue);
                        }
                    }
                }
            }
        });
    }

    private void buscarTexto() {
        // Obtener el texto del JTextField
        String textoBuscar = textField.getText().toLowerCase();

        // Aquí puedes añadir tu lógica para obtener las coincidencias
        // En este ejemplo, vamos a usar una lista de ejemplo
        ArrayList<Symptom> datos = (ArrayList<Symptom>) this.conMan.getSymptomMan().listMatchingSymptomsByName(textoBuscar);

        // Limpiar el modelo de la lista
        listModel.clear();

        // Buscar coincidencias
        for (Symptom item : datos) {
            listModel.addElement(item.getNameSymptom());
        }
    }

    private void agregarSeleccion(String seleccion) {
        seleccionesActuales.add(seleccion);

        JPanel panelSeleccion = new JPanel();
        panelSeleccion.setLayout(new BorderLayout());
        panelSeleccion.setBackground(Color.decode("#A5E0F1"));

        JLabel label = new JLabel(seleccion);
        panelSeleccion.add(label, BorderLayout.CENTER);

        RoundedButton cancelarButton = new RoundedButton("Cancelar", Color.decode("#09A8E4"));
        cancelarButton.setPreferredSize(new Dimension(90, 30));
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSelecciones.remove(panelSeleccion);
                seleccionesActuales.remove(seleccion);
                panelSelecciones.revalidate();
                panelSelecciones.repaint();
            }
        });

        panelSeleccion.add(cancelarButton, BorderLayout.EAST);
        panelSelecciones.add(panelSeleccion);
        panelSelecciones.revalidate();
        panelSelecciones.repaint();
    }

    public static void main(String[] args) {
        // Crear el JFrame para contener el JPanel
        JFrame frame = new JFrame("Buscador de Texto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());
        
        // Agregar la instancia de BuscadorTexto al JFrame
        frame.add(new BuscadorTextoSymptoms(), BorderLayout.CENTER);
        
        // Hacer visible el JFrame
        frame.setVisible(true);
    }
}
