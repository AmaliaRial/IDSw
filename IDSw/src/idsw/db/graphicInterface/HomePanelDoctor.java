package idsw.db.graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;

import idsw.db.graphicInterface.components.RoundedButton;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.jpa.JPAUserManager;
import idsw.db.panelsSwichingInterface.PanelSwitchingInterface;
import idsw.db.pojos.Treatment;


public class HomePanelDoctor extends HomePanel implements ActionListener{
	public List<Treatment> sixTreatments;
	public ConnectionManager conMan;
	public RoundedButton medicalRecordButton;
	public JPAUserManager jpaConMan;
	public GraphicAplication app;
	
	//public HomePanelDoctor(JPAUserManager jpaConMan, GraphicAplication app) {
	public HomePanelDoctor() {
		super();
		
		this.jpaConMan=jpaConMan;
		this.app=app;
		super.userButton.addActionListener(this);
		super.searchButton.addActionListener(this);
		super.b1.addActionListener(this);
		super.b2.addActionListener(this);
		super.b3.addActionListener(this);
		super.b4.addActionListener(this);
		super.b5.addActionListener(this);
		super.b6.addActionListener(this);
		//this.medicalRecordButton.addActionListener(this);
		
		this.conMan=new ConnectionManager();
		this.sixTreatments= this.conMan.getTreatmentMan().listSixRecentTreatment();
		
		super.b1.setButtonText("Recent Treatment: "+sixTreatments.get(0).getNameTreatment());
		super.b2.setButtonText("Recent Treatment: "+sixTreatments.get(1).getNameTreatment());
		super.b3.setButtonText("Recent Treatment: "+sixTreatments.get(2).getNameTreatment());
		super.b4.setButtonText("Recent Treatment: "+sixTreatments.get(3).getNameTreatment());
		super.b5.setButtonText("Recent Treatment: "+sixTreatments.get(4).getNameTreatment());
		super.b6.setButtonText("Recent Treatment: "+sixTreatments.get(5).getNameTreatment());
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Integer id_treatment;
		if(e.getSource()==super.userButton) {
			this.app.fromHomePanelDoctorToLogOutPanel();
		}else if(e.getSource()==super.searchButton) {
			this.app.fromHomePanelDoctorToSearchPatientPanel();
		}else if(e.getSource()==super.b1) {
			id_treatment=this.sixTreatments.get(0).getIdTreatment();
			this.app.fromHomePanelDoctorToReadPatientDoctor_TreatmentPanel(id_treatment);
		}else if(e.getSource()==super.b2) {
			id_treatment=this.sixTreatments.get(1).getIdTreatment();
			this.app.fromHomePanelDoctorToReadPatientDoctor_TreatmentPanel(id_treatment);
		}else if(e.getSource()==super.b3) {
			id_treatment=this.sixTreatments.get(2).getIdTreatment();
			this.app.fromHomePanelDoctorToReadPatientDoctor_TreatmentPanel(id_treatment);
		}else if(e.getSource()==super.b4) {
			id_treatment=this.sixTreatments.get(3).getIdTreatment();
			this.app.fromHomePanelDoctorToReadPatientDoctor_TreatmentPanel(id_treatment);
		}else if(e.getSource()==super.b5) {
			id_treatment=this.sixTreatments.get(4).getIdTreatment();
			this.app.fromHomePanelDoctorToReadPatientDoctor_TreatmentPanel(id_treatment);
		}else if(e.getSource()==super.b6) {
			id_treatment=this.sixTreatments.get(5).getIdTreatment();
			this.app.fromHomePanelDoctorToReadPatientDoctor_TreatmentPanel(id_treatment);
		}else if(e.getSource()==this.medicalRecordButton) {
			this.app.fromHomePanelDoctorToSearchPatientPanel();
		}
	}

}
