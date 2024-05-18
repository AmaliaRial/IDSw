package idsw.db.graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

import idsw.db.graphicInterface.components.RoundedButton;
import idsw.db.jdbc.ConnectionManager;

import idsw.db.pojos.Treatment;


public class HomePanelDoctor extends HomePanel{
	public List<Treatment> sixTreatments;
	public ConnectionManager conMan;
	public RoundedButton medicalRecordButton;
	
	public HomePanelDoctor() {
		super();
		this.conMan=new ConnectionManager();
		this.sixTreatments= this.conMan.getTreatmentMan().listSixRecentTreatment();
		/*
		super.b1.setButtonText("Recent Treatment: "+sixTreatments.get(0).getNameTreatment());
		super.b2.setButtonText("Recent Treatment: "+sixTreatments.get(1).getNameTreatment());
		super.b3.setButtonText("Recent Treatment: "+sixTreatments.get(2).getNameTreatment());
		super.b4.setButtonText("Recent Treatment: "+sixTreatments.get(3).getNameTreatment());
		super.b5.setButtonText("Recent Treatment: "+sixTreatments.get(4).getNameTreatment());
		super.b6.setButtonText("Recent Treatment: "+sixTreatments.get(5).getNameTreatment());
		*/
		super.b1.setButtonColor(Color.decode("#D152EA"));
		super.b2.setButtonColor(Color.decode("#D152EA"));
		super.b3.setButtonColor(Color.decode("#D152EA"));
		super.b4.setButtonColor(Color.decode("#D152EA"));
		super.b5.setButtonColor(Color.decode("#D152EA"));
		super.b6.setButtonColor(Color.decode("#D152EA"));
		
		this.medicalRecordButton=new RoundedButton("RECORD", Color.decode("#09A8E4"));
		this.medicalRecordButton.setPreferredSize(new Dimension(90, 30));
		super.buttonPanel.add(medicalRecordButton);
		
		
		
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new  HomePanelDoctor());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
