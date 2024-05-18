package idsw.db.graphicInterface;

import java.awt.*;
import javax.swing.*;

import idsw.db.graphicInterface.components.*;
import idsw.db.pojos.*;

public class ReadResearcher_SymptomPanel extends SymptomTemplate{
public RoundedButton button3;
	
	public ReadResearcher_SymptomPanel(Integer id_symptom) {
		super();
		Symptom symptom=super.conMan.getSymptomMan().getSymptom(id_symptom);
		super.nameLabel.setText("Name: "+symptom.getNameSymptom());
		super.PainManagemetLabel.setText("<html>Pain management: "+symptom.getPain_management()+"</html>");
		super.titleLabel.setText("<html><b>SYMPTOM</b></html>");
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
        frame.getContentPane().add(new ReadResearcher_SymptomPanel(1));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
