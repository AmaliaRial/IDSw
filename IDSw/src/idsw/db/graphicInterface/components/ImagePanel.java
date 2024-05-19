package idsw.db.graphicInterface.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel(BufferedImage image) {
        this.image = image;
        // Ajustar el tamaño preferido del panel al tamaño de la imagen
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen en el panel
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }
    
    public static JComponent createImageComponent(BufferedImage image) {
        return new ImagePanel(image);
    }

    
}
