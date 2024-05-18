package ids.db.graphicInterface;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ids.db.graphicInterface.components.BuscadorTextoSymptoms;
import ids.db.graphicInterface.components.BuscadorTextoTreatments;
import ids.db.graphicInterface.components.RoundedButton;

public class CreateUpdate_DiseasePanel extends DiseaseTempletePanel {
	public BuscadorTextoSymptoms symptomSearchPanel;
	public BuscadorTextoTreatments treatmentSearchPanel;
	public JComboBox<String>  diseaseCuaseBox;
	public RoundedButton saveButton;
	public  CreateUpdate_DiseasePanel() {
		super();
		String[] causes={"VIRUS","BACTERIA"};
		this.diseaseCuaseBox=new JComboBox<>(causes);
		this.diseaseCuaseBox.setPreferredSize(new Dimension(90,20));
		super.causeDiseasePanel.add(diseaseCuaseBox);
		this.symptomSearchPanel=new BuscadorTextoSymptoms();
		this.symptomSearchPanel.setPreferredSize(new Dimension(200,225));
		super.symptomListPanel.add(this. symptomSearchPanel);
		this.treatmentSearchPanel=new BuscadorTextoTreatments();
		this.treatmentSearchPanel.setPreferredSize(new Dimension(200,225));
		super.treatmentsListPanel.add(this. treatmentSearchPanel);
		super.backCalceButton.setButtonText("Cancel");
		this.saveButton= new RoundedButton("Save", Color.decode("#09A8E4"));
		this.saveButton.setPreferredSize(new Dimension(90,30));
		super.savePanel.add(saveButton);
	}
	public static void main(String[] args) {
	    // Crear y mostrar la ventana de prueba
	    JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(new CreateUpdate_DiseasePanel());
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    
	}
}
