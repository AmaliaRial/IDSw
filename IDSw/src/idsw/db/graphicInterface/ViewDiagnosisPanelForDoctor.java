package idsw.db.graphicInterface;

import javax.swing.*;
import idsw.db.graphicInterface.components.*;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.jpa.JPAUserManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import idsw.db.pojos.*;

public class ViewDiagnosisPanelForDoctor extends ViewDiagnosisPanel implements ActionListener{
public RoundedButton continueButton;
	
	public ViewDiagnosisPanelForDoctor(Integer id_diagnosis, ConnectionManager conMan,GraphicAplication app,JPAUserManager jpaConMan) {
		super(id_diagnosis, conMan, app, jpaConMan);
		this.continueButton = new RoundedButton("Modify", Color.decode("#09A8E4"));	
		this.continueButton.setPreferredSize(new Dimension(110, 30));
		this.backCalcelPanel.add(this.continueButton);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.backCalceButton) {
			//this.app.fromViewDiagnosisPanelForDoctorToMedicalRecordForDoctorPanel(id_patient);
		}
		else if (e.getSource() == this.continueButton) {
			//this.app.fromViewDiagnosisPanelForDoctorToModifyDiagnosisPanel(id_diagnosis);
		} 
	}
			
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.getContentPane().add(new ViewDiagnosisPanelForDoctor(1));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


