package idsw.db.graphicInterface;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import idsw.db.graphicInterface.components.CustomJLabel;
import idsw.db.graphicInterface.components.DateInputPanel;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.jpa.JPAUserManager;
import idsw.db.pojos.Diagnosis;

public class CreateDiagnosisPanel extends CreateUpdate_DiagnosisPanel {
	public JTextField diseaseNameTextField;
	public DateInputPanel dateInputPanel;
	public JTextField ComentSectionTextField;
	
	public CreateDiagnosisPanel(ConnectionManager conMan,GraphicAplication app,JPAUserManager jpaConMan) {
		super(conMan,app,jpaConMan);
		super.titleLabel.setText("<html><b>INPUT DATA OF NEW DIAGNOSIS</b></html>");
		this.diseaseNameTextField=new JTextField(20);
		super.nameDiseasePanel.add(new JLabel());
		super.nameDiseasePanel.add(diseaseNameTextField);
		this.dateInputPanel=new DateInputPanel();
		super.datePanel.add(dateInputPanel);
		this.ComentSectionTextField= new JTextField(20);
		super.comentSectionPanel.add(new JLabel());
		super.comentSectionPanel.add(ComentSectionTextField);
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(new CreateDiagnosisPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
