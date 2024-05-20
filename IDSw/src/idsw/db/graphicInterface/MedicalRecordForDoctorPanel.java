package idsw.db.graphicInterface;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import idsw.db.graphicInterface.components.RoundedButton;
import idsw.db.jdbc.ConnectionManager;
<<<<<<< HEAD
import idsw.db.jpa.JPAUserManager;
=======
>>>>>>> branch 'master' of https://github.com/AmaliaRial/IDSw

public class MedicalRecordForDoctorPanel extends MedicalRecordPanel implements ActionListener{
	public JPanel addPanel;
	public JPanel modifyPanel;
	public JPanel deletePanel;
	
	public RoundedButton addButton;
	public RoundedButton modifyButton;
	public RoundedButton deleteButton;
	public RoundedButton exportHTMLButton;
	public RoundedButton importFromHTMLButton;
	
<<<<<<< HEAD
	public MedicalRecordForDoctorPanel(Integer id_patient, ConnectionManager conMan,GraphicAplication app,JPAUserManager jpaConMan){
		super(id_patient, conMan, app, jpaConMan);
		this.exportHTMLButton=new RoundedButton("Export to HTML", Color.decode("#09A8E4"));
		this.exportHTMLButton.setPreferredSize(new Dimension(140, 25));
=======
	MedicalRecordForDoctorPanel(Integer id_patient, ConnectionManager conMan){
		super(id_patient, conMan);
>>>>>>> branch 'master' of https://github.com/AmaliaRial/IDSw
		this.addButton=new RoundedButton("ADD", Color.decode("#09A8E4"));
		this.addButton.setPreferredSize(new Dimension(80, 25));
		this.importFromHTMLButton=new RoundedButton("Import from HTML", Color.decode("#09A8E4"));
		this.importFromHTMLButton.setPreferredSize(new Dimension(140, 25));
		this.modifyButton=new RoundedButton("MODIFY", Color.decode("#09A8E4"));
		this.modifyButton.setPreferredSize(new Dimension(80, 25));
		this.deleteButton=new RoundedButton("DELETE", Color.decode("#09A8E4"));
		this.deleteButton.setPreferredSize(new Dimension(80, 25));
		super.buttonPanel.setLayout(new GridLayout(3,1));
		this.addPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.addPanel.setBackground(Color.decode("#A5E0F1"));
			this.addPanel.add(exportHTMLButton);
			this.addPanel.add(addButton);
		this.modifyPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.modifyPanel.setBackground(Color.decode("#A5E0F1"));
		    this.modifyPanel.add(importFromHTMLButton);
			this.modifyPanel.add(modifyButton);
		this.deletePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.deletePanel.setBackground(Color.decode("#A5E0F1"));
			this.deletePanel.add(deleteButton);
		super.buttonPanel.add(addPanel);
		super.buttonPanel.add(modifyPanel);
		super.buttonPanel.add(deletePanel);
		
		super.userPhotoBotton.setPreferredSize(new Dimension(75,75));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.diagnosesList) {
			Integer id_diagnosis= super.diagnosesList.;
		}
		else if(e.getSource()==this.addButton) {
			this.app.fromMedicalRecordForDoctorPanelToCreateDiagnosisPanel();
		}
		else if(e.getSource()==this.modifyButton) {
			this.app.fromMedicalRecordPanelForDoctorToUpdateDiagnosisPanel(id_diagnosis);
		}
		else if(e.getSource()==this.deleteButton) {
            this.app.fromMedicalRecordPanelForDoctorToDeleteVerificationPanel(id_diagnosis);
        }
        else if(e.getSource()==this.exportHTMLButton) {
            
        }
        else if(e.getSource()==this.importFromHTMLButton) {
            
		}

	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.getContentPane().add(new MedicalRecordForDoctorPanel(1));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



}
