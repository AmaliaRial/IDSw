package ids.db.graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ids.db.graphicInterface.components.RoundedButton;

public class MedicalRecordForDoctorPanel extends MedicalRecordPanel{
	public JPanel addPanel;
	public JPanel modifyPanel;
	public JPanel deletePanel;
	
	public RoundedButton addButton;
	public RoundedButton modifyButton;
	public RoundedButton deleteButton;
	
	MedicalRecordForDoctorPanel(Integer id_patient){
		super(id_patient);
		this.addButton=new RoundedButton("ADD", Color.decode("#09A8E4"));
		this.addButton.setPreferredSize(new Dimension(80, 25));
		this.modifyButton=new RoundedButton("MODIFY", Color.decode("#09A8E4"));
		this.modifyButton.setPreferredSize(new Dimension(80, 25));
		this.deleteButton=new RoundedButton("DELETE", Color.decode("#09A8E4"));
		this.deleteButton.setPreferredSize(new Dimension(80, 25));
		super.buttonPanel.setLayout(new GridLayout(3,1));
		this.addPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.addPanel.setBackground(Color.decode("#A5E0F1"));
			this.addPanel.add(addButton);
		this.modifyPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.modifyPanel.setBackground(Color.decode("#A5E0F1"));
			this.modifyPanel.add(modifyButton);
		this.deletePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.deletePanel.setBackground(Color.decode("#A5E0F1"));
			this.deletePanel.add(deleteButton);
		super.buttonPanel.add(addPanel);
		super.buttonPanel.add(modifyPanel);
		super.buttonPanel.add(deletePanel);
		
		super.userPhotoBotton.setPreferredSize(new Dimension(75,75));
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MedicalRecordForDoctorPanel(1));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
