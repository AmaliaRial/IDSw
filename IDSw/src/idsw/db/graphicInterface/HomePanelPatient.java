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
import idsw.db.pojos.Diagnosis;

public class HomePanelPatient extends HomePanel implements ActionListener{
	public List<Diagnosis> sixDiagnosis;
	public ConnectionManager conMan;
	public RoundedButton medicalRecordButton;
	public JPAUserManager jpaConMan;
	public GraphicAplication app;
	
	//public HomePanelPatient(JPAUserManager jpaConMan, GraphicAplication app, ConnectionManager conMan) {
	public HomePanelPatient(ConnectionManager conMan) {
		super();
		//this.jpaConMan=jpaConMan;
		//this.app=app;
		this.conMan=conMan;
		this.sixDiagnosis= this.conMan.getDiagnosisMan().listSixRecentDiagnosis((this.conMan.getPatientMan().getPatientByName("Amalia")).getIdPatient());
		super.b1.setButtonText("Recent Diagnosis: "+sixDiagnosis.get(0).getNameDiagnosis()+"     Date: "+sixDiagnosis.get(0).getLocalDate());
		super.b2.setButtonText("Recent Diagnosis: "+sixDiagnosis.get(1).getNameDiagnosis()+"     Date: "+sixDiagnosis.get(1).getLocalDate());
		super.b3.setButtonText("Recent Diagnosis: "+sixDiagnosis.get(2).getNameDiagnosis()+"     Date: "+sixDiagnosis.get(2).getLocalDate());
		super.b4.setButtonText("Recent Diagnosis: "+sixDiagnosis.get(3).getNameDiagnosis()+"     Date: "+sixDiagnosis.get(3).getLocalDate());
		super.b5.setButtonText("Recent Diagnosis: "+sixDiagnosis.get(4).getNameDiagnosis()+"     Date: "+sixDiagnosis.get(4).getLocalDate());
		super.b6.setButtonText("Recent Diagnosis: "+sixDiagnosis.get(5).getNameDiagnosis()+"     Date: "+sixDiagnosis.get(5).getLocalDate());
		
		super.b1.setButtonColor(Color.decode("#9FF247"));
		super.b2.setButtonColor(Color.decode("#9FF247"));
		super.b3.setButtonColor(Color.decode("#9FF247"));
		super.b4.setButtonColor(Color.decode("#9FF247"));
		super.b5.setButtonColor(Color.decode("#9FF247"));
		super.b6.setButtonColor(Color.decode("#9FF247"));
		
		this.medicalRecordButton=new RoundedButton("RECORD", Color.decode("#09A8E4"));
		this.medicalRecordButton.setPreferredSize(new Dimension(90, 30));
		super.buttonPanel.add(medicalRecordButton);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Integer id_diagnosis;
		if(e.getSource()==super.userButton) {
			this.app.fromHomePanelPatientToLogOutPanel();
		}else if(e.getSource()==super.searchButton) {
			this.app.fromHomePanelPatientToSearchDiseaseOptionPanel();
		}else if(e.getSource()==super.b1) {
			id_diagnosis=this.sixDiagnosis.get(0).getIdDiagnosis();
			this.app.fromHomePanelPatientToViewDiagnosisPanel(id_diagnosis);
		}else if(e.getSource()==super.b2) {
			id_diagnosis=this.sixDiagnosis.get(1).getIdDiagnosis();
			this.app.fromHomePanelPatientToViewDiagnosisPanel(id_diagnosis);
		}else if(e.getSource()==super.b3) {
			id_diagnosis=this.sixDiagnosis.get(2).getIdDiagnosis();
			this.app.fromHomePanelPatientToViewDiagnosisPanel(id_diagnosis);
		}else if(e.getSource()==super.b4) {
			id_diagnosis=this.sixDiagnosis.get(3).getIdDiagnosis();
			this.app.fromHomePanelPatientToViewDiagnosisPanel(id_diagnosis);
		}else if(e.getSource()==super.b5) {
			id_diagnosis=this.sixDiagnosis.get(4).getIdDiagnosis();
			this.app.fromHomePanelPatientToViewDiagnosisPanel(id_diagnosis);
		}else if(e.getSource()==super.b6) {
			id_diagnosis=this.sixDiagnosis.get(5).getIdDiagnosis();
			this.app.fromHomePanelPatientToViewDiagnosisPanel(id_diagnosis);
		}else if(e.getSource()==this.medicalRecordButton) {
			this.app.fromHomePanelPatientToLogOutPanel();
		}
	}
		
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new  HomePanelPatient(new ConnectionManager()));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	

}
