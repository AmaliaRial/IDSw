package ids.db.graphicInterface.components;
import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {

    private Color buttonColor;
    private String buttonText;

    public RoundedButton(String text, Color color) {
        super(text);
        this.buttonColor = color;
        this.buttonText = text;
        setFont(new Font("Arial", Font.PLAIN, 14)); // Establecer la fuente Arial
        setForeground(Color.WHITE); // Texto en color blanco
        setContentAreaFilled(false); // No rellenar el área de contenido
        setFocusPainted(false); // No resaltar el botón cuando está enfocado
        setBorderPainted(false); // No dibujar borde del botón
        setOpaque(false); // Permitir pintar el fondo del botón
        setPreferredSize(new Dimension(500, 40)); // Tamaño preferido del botón
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(buttonColor.darker());
        } else if (getModel().isRollover()) {
            g.setColor(buttonColor.brighter());
        } else {
            g.setColor(buttonColor);
        }
        // Dibujar un fondo redondeado
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        // Dibujar el texto centrado en el botón
        g.setColor(getForeground());
        FontMetrics metrics = g.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(buttonText)) / 2;
        int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g.drawString(buttonText, x, y);
    }

    // Método para establecer el color del botón
    public void setButtonColor(Color color) {
        this.buttonColor = color;
    }

    // Método para establecer el texto del botón
    public void setButtonText(String text) {
        this.buttonText = text;
        repaint();
    }
    
    public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de botón redondeado con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RoundedButton button = new RoundedButton("Haz clic", Color.BLUE);
        frame.getContentPane().add(button);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


