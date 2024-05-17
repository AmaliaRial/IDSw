package ids.db.graphicInterface;

import java.awt.*;
import javax.swing.*;

import ids.db.graphicInterface.components.BuscadorTextoTreatments;

public class Update_Treatmentpanel extends TreatmentTemplate{
	
		public BuscadorTextoTreatments nameField;
		public BuscadorTextoTreatments comentSectionField;
	
		public Update_Treatmentpanel() {
		super();
		super.titleLabel.setText("<html><b>INPUT NEW DATA OF THE TREATMENT</b></html>");
        super.button1.setButtonText("Cancel");
        super.button2.setButtonText("Continue");
        
        this.nameField = new BuscadorTextoTreatments();
        this.namePanel.add(this.nameField);
        this.comentSectionField = new BuscadorTextoTreatments();
        this.comentSectionPanel.add(this.comentSectionField);
        
     
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Update_Treatmentpanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
