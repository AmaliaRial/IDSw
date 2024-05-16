package ids.db.graphicInterface.components;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CircularIconButton extends JButton {

	    private ImageIcon icono;

	    public CircularIconButton(ImageIcon icono) {
	        this.icono = icono;
	        setContentAreaFilled(false); // Hace que el área dentro del botón no se pinte
	        setBorderPainted(false); // Elimina el borde pintado del botón
	        setFocusPainted(false); // Elimina el efecto de enfoque
	        setOpaque(false); // Hace que el botón sea transparente
	        setPreferredSize(new Dimension(50, 50)); // Tamaño predeterminado del botón
	        setIcon(icono); // Establece el icono del botón
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        if (getModel().isPressed()) {
	            g.setColor(getBackground().darker());
	        } else if (getModel().isRollover()) {
	            g.setColor(getBackground().brighter());
	        } else {
	            g.setColor(getBackground());
	        }
	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	        // Dibujar el círculo que representa el botón
	        g2.fill(new Ellipse2D.Double(0, 0, getSize().width - 1, getSize().height - 1));

	        // Escalar y dibujar el icono centrado en el botón
	        int iconWidth = icono.getIconWidth();
	        int iconHeight = icono.getIconHeight();
	        int diameter = Math.min(getSize().width, getSize().height); // Diámetro del botón

	        // Escalamos el icono proporcionalmente al tamaño del botón
	        BufferedImage resizedImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = resizedImage.createGraphics();
	        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	        g2d.drawImage(icono.getImage(), 0, 0, diameter, diameter, null);
	        g2d.dispose();

	        // Dibujamos el icono en el centro del botón
	        int x = (getSize().width - diameter) / 2;
	        int y = (getSize().height - diameter) / 2;
	        g2.drawImage(resizedImage, x, y, this);

	        g2.dispose();
	    }
}

   