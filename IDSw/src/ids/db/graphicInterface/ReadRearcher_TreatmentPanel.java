package ids.db.graphicInterface;

import java.awt.*;
import javax.swing.*;

import ids.db.graphicInterface.components.RoundedButton;
import idsw.db.pojos.Treatment;

public class ReadRearcher_TreatmentPanel extends TreatmentTemplate{
	public RoundedButton button3;
	
	public ReadRearcher_TreatmentPanel(Integer id_treatment) {
		super();
		Treatment treatment=super.conMan.getTreatmentMan().getTreatment(id_treatment);
		super.nameLabel.setText("<html>Name: "+treatment.getNameTreatment()+"</html>");
		super.comentSectionLabel.setText("<html>Comment Section: "+treatment.getComment_Section()+"</html>");
		super.titleLabel.setText("<html><b>TREATMENT</b></html>");
        super.button1.setButtonText("Back");
        super.button2.setButtonText("Delete");
        this.button3 = new RoundedButton("Modify", Color.decode("#09A8E4"));
        this.button3.setPreferredSize(new Dimension(90, 30));
        super.button2Panel.add(this.button3);
        
        
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ReadRearcher_TreatmentPanel(1));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}