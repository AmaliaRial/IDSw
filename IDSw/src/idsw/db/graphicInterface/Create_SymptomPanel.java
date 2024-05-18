package idsw.db.graphicInterface;

import javax.swing.*;
import java.awt.*;

public class Create_SymptomPanel extends SymptomTemplate {
	public JTextField nameField;
	public JComboBox<String> PainManagementField;

	public Create_SymptomPanel() {
	super();
	super.titleLabel.setText("<html><b>INPUT DATA OF NEW SYMPTOM</b></html>");
    super.button1.setButtonText("Cancel");
    super.button2.setButtonText("Continue");
    
    this.nameField = new JTextField(20);
    this.namePanel.add(this.nameField);
    this.PainManagementField = new JComboBox<String>();
       this.PainManagementField.addItem("MILD");
       this.PainManagementField.addItem("SEVERE");
    this.painManagementPanel.add(this.PainManagementField);
    
 
}

public static void main(String[] args) {
    // Crear y mostrar la ventana de prueba
    JFrame frame = new JFrame("Ejemplo con Swing");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new Create_SymptomPanel());
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

}
