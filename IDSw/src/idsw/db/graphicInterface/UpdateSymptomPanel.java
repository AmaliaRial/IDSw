package idsw.db.graphicInterface;

import java.awt.Color;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import idsw.db.graphicInterface.components.BuscadorTextoSymptoms;
import idsw.db.graphicInterface.components.CustomJLabel;
import idsw.db.graphicInterface.components.PlaceholderTextField;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Symptom;
import idsw.db.pojos.Treatment;

public class UpdateSymptomPanel extends SymptomTemplate{
	public PlaceholderTextField nameField;
	public JComboBox<String> PainManagementField;


	public UpdateSymptomPanel(Integer id_symptom) {
	super();
	super.titleLabel.setText("<html><b>INPUT NEW DATA OF THE SYMPTOM</b></html>");
	Symptom symptom=super.conMan.getSymptomMan().getSymptom(id_symptom);
    super.button1.setButtonText("Cancel");
    super.button2.setButtonText("Continue");
    
    this.nameField = new PlaceholderTextField(symptom.getNameSymptom());
    this.namePanel.add(this.nameField);
    String[] pain_management = {"MILD", "SEVERE"};
    this.PainManagementField = new JComboBox<String>(pain_management);
    this.PainManagementField.setSelectedItem((super.conMan.getSymptomMan().getSymptom(id_symptom).getPain_management().toString()));
    super.painManagementPanel.add(this.PainManagementField);
    

}

public static void main(String[] args) {
    // Crear y mostrar la ventana de prueba
    JFrame frame = new JFrame("Ejemplo con Swing");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new UpdateSymptomPanel(1));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}
}
