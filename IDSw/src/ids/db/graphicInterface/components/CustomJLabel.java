package ids.db.graphicInterface.components;
import javax.swing.*;
import java.awt.*;

public class CustomJLabel extends JLabel {

    public CustomJLabel(String text, int textSize, Color textColor, Color backgroundColor) {
        super(text);
        setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
        setVerticalAlignment(SwingConstants.CENTER); // Centrar el texto verticalmente
        setFont(new Font("Arial", Font.PLAIN, textSize)); // Establecer la fuente a Arial con el tamaño especificado
        setForeground(textColor); // Establecer el color del texto
        setBackground(backgroundColor); // Establecer el color de fondo
        setOpaque(true); // Asegurar que el JLabel es opaco para que el color de fondo se muestre
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        // Ajustar el tamaño para asegurar que todo el texto sea visible
        size.width += 10; // Ancho adicional para que el texto no esté pegado al borde
        size.height += 5; // Altura adicional para mejorar la apariencia
        return size;
    }
    
    public void setBackgroundColor(Color backgroundColor) {
    	setBackground(backgroundColor);
    	repaint();
    }
    public void setTextColor(Color textColor) {
    	setForeground(textColor);
    	repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom JLabel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            CustomJLabel label = new CustomJLabel("Custom JLabel", 20, Color.BLUE, Color.YELLOW);

            frame.getContentPane().add(label);
            frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
            frame.setVisible(true);
        });
    }
}
