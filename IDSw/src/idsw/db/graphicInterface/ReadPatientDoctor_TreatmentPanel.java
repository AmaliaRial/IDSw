package idsw.db.graphicInterface;

import javax.swing.*;

import idsw.db.graphicInterface.components.*;
import idsw.db.pojos.Treatment;

import java.awt.*;

public class ReadPatientDoctor_TreatmentPanel extends TreatmentTemplate {
	public ReadPatientDoctor_TreatmentPanel (Integer id_treatment) {
		super();
		Treatment treatment=super.conMan.getTreatmentMan().getTreatment(id_treatment);
		super.nameLabel.setText("<html>Name: "+treatment.getNameTreatment()+"</html>");
		super.comentSectionLabel.setText("<html>Comment Section: "+treatment.getComment_Section()+"</html>");
		super.titleLabel.setText("<html><b>TREATMENT</b></html>");
		super.button1.setButtonText("Back");
		super.button2Panel.remove(super.button2);
		

	}

	public static void main(String[] args) {
		// Crear y mostrar la ventana de prueba
		JFrame frame = new JFrame("Ejemplo con Swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ReadPatientDoctor_TreatmentPanel(1));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
