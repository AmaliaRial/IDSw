package idsw.db.graphicInterface;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Create_TreatmentPanel extends TreatmentTemplate {
	public JTextField nameField;
	public JTextField comentSectionField;

	public Create_TreatmentPanel() {
	super();
	super.titleLabel.setText("<html><b>INPUT DATA OF NEW TREATMENT</b></html>");
    super.button1.setButtonText("Cancel");
    super.button2.setButtonText("Continue");
    
    this.nameField = new JTextField(20);
    this.namePanel.add(this.nameField);
    this.comentSectionField = new JTextField(20);
    this.comentSectionPanel.add(this.comentSectionField);
    
 
}

public static void main(String[] args) {
    // Crear y mostrar la ventana de prueba
    JFrame frame = new JFrame("Ejemplo con Swing");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new Create_TreatmentPanel());
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}
}
