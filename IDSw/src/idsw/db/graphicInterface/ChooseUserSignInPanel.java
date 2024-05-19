package idsw.db.graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import idsw.db.graphicInterface.components.CustomJLabel;
import idsw.db.graphicInterface.components.RoundedButton;

public class ChooseUserSignInPanel extends JPanel{
	public JPanel titlePanel;
	public JPanel midlePanel;
		public JPanel choosePanel;
		public JPanel usersOptionPanel;
	public JPanel alreadyAcountPanel;
		public JPanel alreadyAcounTextPanel;
		public JPanel LogInButtonPanel;
	public JPanel leftSpace;
	public JPanel rightSpace;
		
	public CustomJLabel titleSingInLable;	
	public CustomJLabel chooseUserLable;
	public RoundedButton patientButton;
	public RoundedButton doctorButton;
	public RoundedButton researcherButton;
	public CustomJLabel alreadyAcountLabel;
	public RoundedButton LogInButton;
	
	public ChooseUserSignInPanel() {
		this.setLayout(new BorderLayout());
		this.titlePanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.add(titlePanel,BorderLayout.NORTH);
		this.titlePanel.setBackground(Color.decode("#A5E0F1"));
		this.midlePanel=new JPanel(new GridLayout(4,1,5,5));
		this.midlePanel.setBackground(Color.WHITE);
		this.add(midlePanel,BorderLayout.CENTER);
			this.midlePanel.add(new JLabel());
			this.choosePanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
			this.choosePanel.setBackground(Color.WHITE);
			this.midlePanel.add(choosePanel);
			this.usersOptionPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
			this.usersOptionPanel.setBackground(Color.WHITE);
			this.midlePanel.add(usersOptionPanel);
			this.midlePanel.add(new JLabel());
		this.alreadyAcountPanel=new JPanel(new GridLayout(2,1));
		this.add(alreadyAcountPanel,BorderLayout.SOUTH);
			this.alreadyAcounTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
			this.alreadyAcounTextPanel.setBackground(Color.WHITE);
			this.alreadyAcountPanel.add(alreadyAcounTextPanel);
			this.LogInButtonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
			this.LogInButtonPanel.setBackground(Color.WHITE);
			this.alreadyAcountPanel.add(LogInButtonPanel);
		
		this.titleSingInLable=new CustomJLabel("<html><b>SIGN IN</b></html>", 20,Color.decode("#09A8E4"),Color.decode("#A5E0F1"));
		this.titlePanel.add(titleSingInLable);
		
		this.chooseUserLable=new CustomJLabel("WHAT ARE YOU?",30,Color.BLACK,Color.WHITE);
		this.choosePanel.add(chooseUserLable);
		this.patientButton=new RoundedButton("PATIENT", Color.decode("#9FF247"));
			this.patientButton.setPreferredSize(new Dimension(110, 50));
		this.doctorButton=new RoundedButton("DOCTOR", Color.decode("#D152EA"));
			this.doctorButton.setPreferredSize(new Dimension(110, 50));
		this.researcherButton=new RoundedButton("RESEARCHER", Color.decode("#F1C832"));
			this.researcherButton.setPreferredSize(new Dimension(110, 50));
		this.usersOptionPanel.add(patientButton);
		this.usersOptionPanel.add(doctorButton);
		this.usersOptionPanel.add(researcherButton);
		
		this.alreadyAcountLabel=new CustomJLabel("Already have an acount?",10,Color.BLACK,Color.WHITE);
		this.alreadyAcounTextPanel.add(alreadyAcountLabel);
		this.LogInButton=new RoundedButton("LOG IN",Color.decode("#09A8E4"));
		this.LogInButton.setPreferredSize(new Dimension(90, 30));
		this.LogInButtonPanel.add(LogInButton);
		
		this.leftSpace = new JPanel();
        this.leftSpace.setPreferredSize(new Dimension(20, 10)); // Ancho de 10 píxeles
        add(leftSpace, BorderLayout.WEST);
        this.leftSpace.setBackground(Color.WHITE);
        
        this.rightSpace = new JPanel();
        this.rightSpace.setPreferredSize(new Dimension(20, 10)); // Ancho de 10 píxeles
        add(rightSpace, BorderLayout.EAST);
        this.rightSpace.setBackground(Color.WHITE);
		
	}
	
	
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChooseUserSignInPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
