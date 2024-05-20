package idsw.db.graphicInterface;

import javax.swing.*;
import idsw.db.graphicInterface.components.*;
import java.awt.*;
import idsw.db.pojos.*;


public class ViewDiseasePanelForDoctor extends ViewDiseasePanel {
	public RoundedButton continueButton;
	
	public ViewDiseasePanelForDoctor(Integer id_disease) {
		super(id_disease);
		this.continueButton = new RoundedButton("Continue", Color.decode("#09A8E4"));	
		this.continueButton.setPreferredSize(new Dimension(110, 30));
		this.backCalcelPanel.add(this.continueButton);
    }

	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ViewDiseasePanelForDoctor(1));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
