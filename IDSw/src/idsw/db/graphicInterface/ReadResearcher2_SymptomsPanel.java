package idsw.db.graphicInterface;

import java.awt.*;
import javax.swing.*;

import idsw.db.graphicInterface.components.*;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.pojos.*;

public class ReadResearcher2_SymptomsPanel extends SymptomTemplate {
	public ReadResearcher2_SymptomsPanel(Integer id_symptom,ConnectionManager conMan,GraphicAplication app) {
		super(conMan,app);
		Symptom symptom=super.conMan.getSymptomMan().getSymptom(id_symptom);
		super.nameLabel.setText("Name: "+symptom.getNameSymptom());
		super.PainManagemetLabel.setText("<html>Pain management: "+symptom.getPain_management()+"</html>");
		super.titleLabel.setText("<html><b>SYMPTOM</b></html>");
        super.button1.setButtonText("Back");
        super.button2.setButtonText("Create symptom");
        super.button2.setPreferredSize(new Dimension(120, 30));
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(new ReadResearcher2_SymptomsPanel(1));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
