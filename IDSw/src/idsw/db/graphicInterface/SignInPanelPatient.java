package idsw.db.graphicInterface;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import idsw.db.graphicInterface.components.CustomJLabel;

public class SignInPanelPatient extends SignInPanel{
	
	public SignInPanelPatient(){
		super();
		super.northPanel.setBackground(Color.decode("#C9F699"));
		super.signInLavel.setBackgroundColor(Color.decode("#C9F699"));
		super.signInLavel.setTextColor(Color.decode("#64B60D"));
		super.signInLavel.setText("<html><b>SIGN IN AS A PATIENT</b></html>");
		super.userNumberLabel.setText("Health Insurance number: ");
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new  SignInPanelPatient());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
}
