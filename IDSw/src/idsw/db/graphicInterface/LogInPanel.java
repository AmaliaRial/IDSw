package idsw.db.graphicInterface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import idsw.db.graphicInterface.components.CircularIconButton;
import idsw.db.graphicInterface.components.CustomJLabel;
import idsw.db.graphicInterface.components.RoundedButton;

public class LogInPanel extends JPanel{
	public JPanel titlePanel;
	public JPanel inputPanel;
		public JPanel continuePanel;
		public JPanel userNamePanel;
		public JPanel passwordPanel;
	public JPanel notHaveAcountPanel;
		public JPanel notHaveAcountTextPanel;
		public JPanel createAcountButtonPanel;
	public JPanel leftSpace;
	public JPanel rightSpace;
		
	public CustomJLabel titleLoginLable;	
	public CustomJLabel userNameLable;
	public CustomJLabel passwordLable;
	public JTextField userNameTextField;
	public JPasswordField passwordTextField;
	public RoundedButton continueButton;
	public CustomJLabel notHaveAcountLabel;
	public RoundedButton createAcountButton;
	
	public LogInPanel(){
		this.setLayout(new BorderLayout());
		this.titlePanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
			this.titlePanel.setBackground(Color.decode("#A5E0F1"));
		this.add(this.titlePanel, BorderLayout.NORTH);
		this.inputPanel=new JPanel(new GridLayout(4,1,5,5));
		this.inputPanel.setBackground(Color.WHITE);
		this.add(this.inputPanel, BorderLayout.CENTER);
			this.inputPanel.add(new CustomJLabel("", 0, Color.WHITE,Color.WHITE));
			this.userNamePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				this.userNamePanel.setBackground(Color.WHITE);
				this.inputPanel.add(userNamePanel);
			this.passwordPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				this.passwordPanel.setBackground(Color.WHITE);
				this.inputPanel.add(passwordPanel); 
			this.continuePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
				this.continuePanel.setBackground(Color.WHITE);
				this.inputPanel.add(continuePanel);
			
		this.notHaveAcountPanel=new JPanel(new GridLayout(2,1));
		this.notHaveAcountPanel.setBackground(Color.WHITE);
		this.add(this.notHaveAcountPanel, BorderLayout.SOUTH);
			this.notHaveAcountTextPanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
			this.notHaveAcountTextPanel.setBackground(Color.WHITE);
			this.notHaveAcountPanel.add(notHaveAcountTextPanel);
			this.createAcountButtonPanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
			this.createAcountButtonPanel.setBackground(Color.WHITE);
			this.notHaveAcountPanel.add(createAcountButtonPanel);
			
		this.titleLoginLable= new CustomJLabel("<html><b>LOG IN</b></html>", 30, Color.decode("#09A8E4"),Color.decode("#A5E0F1"));
		this.titlePanel.add(titleLoginLable);
		
		
		this.userNameLable=new CustomJLabel("User Name:", 15, Color.BLACK,Color.WHITE);
		this.userNamePanel.add(userNameLable);
		this.userNameTextField= new JTextField(20);
		this.userNamePanel.add(userNameTextField);
		
		this.passwordLable=new CustomJLabel("Password:", 15, Color.BLACK,Color.WHITE);
		this.passwordPanel.add(passwordLable);
		this.passwordPanel.add(new JLabel());
		this.passwordTextField= new JPasswordField(20);
		this.passwordPanel.add(passwordTextField);
		
		this.continueButton= new RoundedButton("CONTINUE", Color.decode("#09A8E4"));
		this.continueButton.setPreferredSize(new Dimension(90, 30));
		this.continuePanel.add(continueButton);
		
		this.notHaveAcountLabel=new CustomJLabel("¿Don´t have an account?", 10, Color.BLACK,Color.WHITE);
		this.notHaveAcountTextPanel.add(notHaveAcountLabel);
		this.createAcountButton= new RoundedButton("Create Acount", Color.decode("#09A8E4"));
		this.createAcountButton.setPreferredSize(new Dimension(100, 30));
		this.createAcountButtonPanel.add(createAcountButton);
		
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
        frame.getContentPane().add(new LogInPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
}
