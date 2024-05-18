package ids.db.graphicInterface;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import idsw.db.pojos.*;
import ids.db.graphicInterface.components.PlaceholderTextField;

public class UpdateDiseasePanel extends CreateUpdate_DiseasePanel{
	public PlaceholderTextField diseaseNameTextField;
	public PlaceholderTextField mortalityRateTextField;
	public PlaceholderTextField infectiousRateTextField;
	public PlaceholderTextField incuvationPeriodTextField;
	public PlaceholderTextField developmentPeriodTextField;
	public PlaceholderTextField convalencesePeriodTextField;
	public PlaceholderTextField commentSectionTextField;
	
	public UpdateDiseasePanel(Integer id_Disease){
		super();
		Disease disease=super.conMan.getDiseaseMan().getDisease(id_Disease);
		this.diseaseNameTextField= new PlaceholderTextField(disease.getNameDisease());
		this.diseaseNameTextField.setPreferredSize(new Dimension(200,20));
		super.namePanel.add(new JLabel());
		super.namePanel.add(this.diseaseNameTextField);
		this.mortalityRateTextField= new PlaceholderTextField(disease.getMortality_rate().toString());
		this.mortalityRateTextField.setPreferredSize(new Dimension(200,20));
		super.mortalityPanel.add(new JLabel());
		super.mortalityPanel.add(this.mortalityRateTextField);
		this.infectiousRateTextField= new PlaceholderTextField(disease.getInfectious_rate().toString());
		this.infectiousRateTextField.setPreferredSize(new Dimension(200,20));
		super.infectiousPanel.add(new JLabel());
		super.infectiousPanel.add(this.infectiousRateTextField);
		this.incuvationPeriodTextField= new PlaceholderTextField(disease.getIncubation_period().toString());
		this.incuvationPeriodTextField.setPreferredSize(new Dimension(200,20));
		super.incuvationPeriotPanel.add(new JLabel());
		super.incuvationPeriotPanel.add(this.incuvationPeriodTextField);
		this.developmentPeriodTextField= new PlaceholderTextField(disease.getDevelopment_period().toString());
		this.developmentPeriodTextField.setPreferredSize(new Dimension(200,20));
		super.developmentPeriotPanel.add(new JLabel());super.developmentPeriotPanel.add(new JLabel());
		super.developmentPeriotPanel.add(this.developmentPeriodTextField);
		this.convalencesePeriodTextField= new PlaceholderTextField(disease.getConvalescence_period().toString());
		this.convalencesePeriodTextField.setPreferredSize(new Dimension(200,20));
		super.convalescensePeriotPanel.add(new JLabel());super.convalescensePeriotPanel.add(new JLabel());
		super.convalescensePeriotPanel.add(this.convalencesePeriodTextField);
		this.commentSectionTextField= new PlaceholderTextField(disease.getComment_section());
		this.commentSectionTextField.setPreferredSize(new Dimension(200,20));
		super.commentSectionPanel.add(new JLabel());
		super.commentSectionPanel.add(this.commentSectionTextField);
		/**
		List<Symptom> listSymptoms= super.conMan.getSymptomMan().getSymptomsByDisease(disease);
		for(Symptom symptom:listSymptoms) {
			super.symptomSearchPanel.agregarSeleccion(symptom.getNameSymptom());
		}
		
		List<Treatment> listTreatments= super.conMan.getTreatmentMan().getTreatmentsByDisease(disease);
		for(Treatment treatment:listTreatments) {
			super.treatmentSearchPanel.agregarSeleccion(treatment.getNameTreatment());
		}
		*/
	}
	public static void main(String[] args) {
	    // Crear y mostrar la ventana de prueba
	    JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(new UpdateDiseasePanel(1));
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}

}
