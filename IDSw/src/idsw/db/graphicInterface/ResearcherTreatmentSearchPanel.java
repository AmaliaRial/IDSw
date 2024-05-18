package idsw.db.graphicInterface;

import java.awt.Color;

import java.awt.Dimension;

import javax.swing.JFrame;

import idsw.db.graphicInterface.components.BuscadorTextoSymptoms;
import idsw.db.graphicInterface.components.BuscadorTextoTreatments;
import idsw.db.graphicInterface.components.RoundedButton;

public class ResearcherTreatmentSearchPanel extends SearchTempletePanel{
	public BuscadorTextoTreatments treatmentsSearchpanel;
	public RoundedButton addButton;
	public RoundedButton deleteButton;
	
	public ResearcherTreatmentSearchPanel () {
		super();
		this.treatmentsSearchpanel=new BuscadorTextoTreatments();
		super.midlePanel.add(treatmentsSearchpanel);
		this.addButton=new RoundedButton("Add Symptom", Color.decode("#09A8E4"));
		this.addButton.setPreferredSize(new Dimension(110,30));
		this.deleteButton=new RoundedButton("Delete Selected", Color.decode("#09A8E4"));
		this.deleteButton.setPreferredSize(new Dimension(120,30));
		super.optionButtonsPanel.add(deleteButton);
		super.optionButtonsPanel.add(addButton);
	}
	
	public static void main(String[] args) {
	    // Crear y mostrar la ventana de prueba
	    JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(new  ResearcherTreatmentSearchPanel());
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}

}
