package idsw.db.graphicInterface;

import java.awt.Color;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import idsw.db.graphicInterface.components.*;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Treatment;

public class UpdateDiagnosisPanel extends CreateUpdate_DiagnosisPanel{

	public PlaceholderTextField diseaseNameTextField;
	public JLabel dateLabel;
	public PlaceholderTextField comentSectionTextField;
	
	public UpdateDiagnosisPanel(Integer id_Diagnosis) {
		super();
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
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new UpdateDiagnosisPanel(2));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
