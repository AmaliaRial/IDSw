package idsw.db.graphicInterface;

import java.awt.*;
import javax.swing.*;

import idsw.db.graphicInterface.components.*;
import idsw.db.jdbc.*;
import idsw.db.pojos.Symptom;
import idsw.db.pojos.Treatment;


public class ReadPatientDoctor_SymptomPanel extends SymptomTemplate{
	public ReadPatientDoctor_SymptomPanel (Integer id_symptom) {
		super();
		Symptom symptom=super.conMan.getSymptomMan().getSymptom(id_symptom);
		super.nameLabel.setText("Name: "+symptom.getNameSymptom());
		super.PainManagemetLabel.setText("<html>Pain management: "+symptom.getPain_management()+"</html>");
		super.titleLabel.setText("<html><b>TREATMENT</b></html>");
		super.button1.setButtonText("Back");
		super.button2Panel.remove(super.button2);
		

	}

	public static void main(String[] args) {
		// Crear y mostrar la ventana de prueba
		JFrame frame = new JFrame("Ejemplo con Swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ReadPatientDoctor_SymptomPanel(1));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
