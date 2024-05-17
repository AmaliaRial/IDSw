package ids.db.graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ids.db.graphicInterface.components.*;

public class CreateUpdate_DiagnosisPanel extends DiagnosisTemplatePanel {

	public BuscadorTextoTreatments treatmenSearchPanel;
	public RoundedButton continueButton;
	public JPanel continuePanel;
	
	public CreateUpdate_DiagnosisPanel() {
		super();
	
		this.treatmenSearchPanel= new BuscadorTextoTreatments();
		super. treatmentsPanel.add(treatmenSearchPanel);
		super.backCalceButton.setButtonText("Cancel");
		this.continuePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.continuePanel.setBackground(Color.WHITE);
		this.continueButton= new RoundedButton("Continue",Color.decode("#09A8E4"));
		this.continueButton.setPreferredSize(new Dimension(90,30));
		super.southPanel.add(continuePanel);
		this.continuePanel.add(continueButton);
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CreateUpdate_DiagnosisPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	

}
