package idsw.db.graphicInterface.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmallRoundedButton extends JButton {

    private Color buttonColor;

    public SmallRoundedButton(String text, Color color) {
        super(text);
        this.buttonColor = color;
        setFont(new Font("Arial", Font.PLAIN, 14)); // Establecer la fuente Arial
        setForeground(Color.WHITE); // Texto en color blanco
        setContentAreaFilled(false); // No rellenar el área de contenido
        setFocusPainted(false); // No resaltar el botón cuando está enfocado
        setBorderPainted(false); // No dibujar borde del botón
        setOpaque(true); // Permitir pintar el fondo del botón

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar cuando se hace clic en el botón
                // Por ejemplo: System.out.println("Botón rectangular redondeado clicado");
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(15, 15); // Tamaño de los arcos para redondear las esquinas
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar el fondo redondeado
        graphics.setColor(buttonColor);
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

        // Dibujar el texto centrado en el botón
        FontMetrics metrics = graphics.getFontMetrics(getFont());
        int x = (width - metrics.stringWidth(getText())) / 2;
        int y = ((height - metrics.getHeight()) / 2) + metrics.getAscent();
        graphics.setColor(getForeground());
        graphics.drawString(getText(), x, y);
    }

    // Método para establecer el color del botón
    public void setButtonColor(Color color) {
        this.buttonColor = color;
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Botón rectangular redondeado en Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el botón rectangular redondeado
        SmallRoundedButton button = new SmallRoundedButton("Haz clic", Color.BLUE);
        button.setPreferredSize(new Dimension(150, 40)); // Establecer el tamaño del botón
        frame.getContentPane().add(button);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

