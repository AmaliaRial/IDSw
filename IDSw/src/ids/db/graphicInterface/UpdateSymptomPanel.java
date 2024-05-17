package ids.db.graphicInterface;

import javax.swing.JFrame;
import javax.swing.JTextField;

import ids.db.graphicInterface.components.BuscadorTextoSymptoms;

public class UpdateSymptomPanel extends SymptomTemplate{
	public BuscadorTextoSymptoms nameField;
	public BuscadorTextoSymptoms PainManagementField;

	public UpdateSymptomPanel() {
	super();
	super.titleLabel.setText("<html><b>INPUT NEW DATA OF THE SYMPTOM</b></html>");
    super.button1.setButtonText("Cancel");
    super.button2.setButtonText("Continue");
    
    this.nameField = new BuscadorTextoSymptoms();
    this.namePanel.add(this.nameField);
    this.PainManagementField = new BuscadorTextoSymptoms();
    this.PainManagemetPanel.add(this.PainManagementField);
    
 
}

public static void main(String[] args) {
    // Crear y mostrar la ventana de prueba
    JFrame frame = new JFrame("Ejemplo con Swing");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new UpdateSymptomPanel());
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}
}
