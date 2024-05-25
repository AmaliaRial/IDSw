package idsw.db.graphicInterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import idsw.db.graphicInterface.components.*;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.jpa.JPAUserManager;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Treatment;

public class UpdateDiagnosisPanel extends CreateUpdate_DiagnosisPanel implements ActionListener{

	public PlaceholderTextField diseaseNameTextField;
	public JLabel dateLabel;
	public PlaceholderTextField comentSectionTextField;
	
	public UpdateDiagnosisPanel(Integer id_Diagnosis, ConnectionManager conMan, GraphicAplication app, JPAUserManager jpaConMan) {
		super(conMan, app, jpaConMan);
		super.titleLabel.setText("<html><b>INTRODUCE NEW DATA OF  DIAGNOSIS</b></html>");
		Diagnosis diagnosis=super.conMan.getDiagnosisMan().getDiagnosis(id_Diagnosis);
		this.dateLabel=new CustomJLabel((diagnosis.getLocalDate()).toString(), 15, Color.BLACK, Color.WHITE);
		super.datePanel.add(this.dateLabel);
		
		this.diseaseNameTextField= new PlaceholderTextField(diagnosis.getDisease().getNameDisease());
		this.comentSectionTextField= new PlaceholderTextField(diagnosis.getComment_section());
		
		super.nameDiseasePanel.add(this.diseaseNameTextField);
		super.comentSectionPanel.add(comentSectionTextField);
		
		List<Treatment> listTreatments= super.conMan.getTreatmentMan().getTreatmentsByDiagnosis(diagnosis);
		for(Treatment treatment:listTreatments) {
			super.treatmenSearchPanel.agregarSeleccion(treatment.getNameTreatment());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.backCalceButton) {
			//this.app.fromModifyDiagnosisPanelToMedicalRecordForDoctorPanel(id_patient);
		}
		else if (e.getSource() == this.continueButton) {
			//this.app.fromModifyDiagnosisPanelToViewDiagnosisPanelForDoctor(id_diagnosis);
		}
		
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(new UpdateDiagnosisPanel(2));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
}
