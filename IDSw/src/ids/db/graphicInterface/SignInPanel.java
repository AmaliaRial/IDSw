package ids.db.graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ids.db.graphicInterface.components.CustomJLabel;
import ids.db.graphicInterface.components.DateInputPanel;
import ids.db.graphicInterface.components.RoundedButton;
import idsw.db.enums.Sex;

public class SignInPanel extends JPanel {
	
	public JPanel northPanel;
	public JPanel midlePanel;
		public JPanel namePanel;
		public JPanel surnamePanel;
		public JPanel userNamePanel;
		public JPanel passwordPanel;
		public JPanel passwordRepeatPanel;
		public JPanel birthdayPanel;
		public JPanel sexPanel;
		public JPanel emailPanel;
		public JPanel phoneNumberPanel;
		public JPanel dniPanel;
		public JPanel userNumberPanel;
	public JPanel southPanel;
		public JPanel cancelPanel;
		public JPanel createAcountPanel;
	public JPanel leftSpace;
	public JPanel rightSpace;
	
	public CustomJLabel signInLavel;
	
	public CustomJLabel nameLabel;
	public CustomJLabel surnameLabel;
	public CustomJLabel userNameLabel;
	public CustomJLabel passwordLabel;
	public CustomJLabel passwordRepeatLabel;
	public CustomJLabel sexLabel;
	public CustomJLabel emailLabel;
	public CustomJLabel phoneNumberLabel;
	public CustomJLabel dniLabel;
	public CustomJLabel userNumberLabel;
	public JTextField nameTextField;
	public JTextField surnameTextField;
	public JTextField userNameTextField;
	public JPasswordField passwordTextField;
	public JPasswordField passwordRepeatTextField;
	public DateInputPanel bithdayDatePicker;
	public JComboBox<String> SexComboBox;
	public JTextField emailTextField;
	public JTextField phoneNumberField;
	public JTextField dniField;
	public JTextField userNumberField;
	
	public RoundedButton cancelButton;
	public RoundedButton createAcountButton;
	
	public SignInPanel(){
		this.setLayout(new BorderLayout());
		this.northPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.northPanel.setBackground(Color.decode("#A5E0F1"));
		this.add(northPanel,BorderLayout.NORTH);
		
		this.midlePanel=new JPanel(new GridLayout(11,1));
		this.midlePanel.setBackground(Color.WHITE);
		this.add(midlePanel, BorderLayout.CENTER);
			this.namePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.namePanel.setBackground(Color.WHITE);
			this.midlePanel.add(namePanel);
			this.surnamePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.surnamePanel.setBackground(Color.WHITE);
			this.midlePanel.add(surnamePanel);
			this.userNamePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.userNamePanel.setBackground(Color.WHITE);
			this.midlePanel.add(userNamePanel);
			this.passwordPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.passwordPanel.setBackground(Color.WHITE);
			this.midlePanel.add(passwordPanel);
			this.passwordRepeatPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.passwordRepeatPanel.setBackground(Color.WHITE);
			this.midlePanel.add(passwordRepeatPanel);
			this.birthdayPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.birthdayPanel.setBackground(Color.WHITE);
			this.midlePanel.add(birthdayPanel);
			this.sexPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.sexPanel.setBackground(Color.WHITE);
			this.midlePanel.add(sexPanel);
			this.emailPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.emailPanel.setBackground(Color.WHITE);
			this.midlePanel.add(emailPanel);
			this.phoneNumberPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.phoneNumberPanel.setBackground(Color.WHITE);
			this.midlePanel.add(phoneNumberPanel);
			this.dniPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.dniPanel.setBackground(Color.WHITE);
			this.midlePanel.add(dniPanel);
			this.userNumberPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.userNumberPanel.setBackground(Color.WHITE);
			this.midlePanel.add(userNumberPanel);
		
		this.southPanel=new JPanel(new GridLayout(1,2));
		this.southPanel.setBackground(Color.WHITE);
		this.add(southPanel,BorderLayout.SOUTH);
			this.cancelPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.cancelPanel.setBackground(Color.WHITE);
			this.southPanel.add(cancelPanel);
			this.createAcountPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
			this.createAcountPanel.setBackground(Color.WHITE);
			this.southPanel.add(createAcountPanel);
			
		this.signInLavel=new CustomJLabel("<html><b>SIGN IN AS ...</b></html>",20, Color.decode("#09A8E4"),Color.decode("#A5E0F1"));
		this.northPanel.add(signInLavel);
			
		this.nameLabel= new CustomJLabel("Name: ",15, Color.BLACK,Color.WHITE);
		this.surnameLabel= new CustomJLabel("Surname: ",15, Color.BLACK,Color.WHITE);
		this.userNameLabel= new CustomJLabel("UserName: ",15, Color.BLACK,Color.WHITE);
		this.passwordLabel= new CustomJLabel("Password: ",15, Color.BLACK,Color.WHITE);
		this.passwordRepeatLabel= new CustomJLabel("Password Repeat: ",15, Color.BLACK,Color.WHITE);
		this.bithdayDatePicker= new DateInputPanel();
		this.sexLabel=new CustomJLabel("Sex: ",15, Color.BLACK,Color.WHITE);
		String[] sexs= {"MALE", "FEMALE"};
		this.SexComboBox=new JComboBox<String>(sexs);
		this.emailLabel=new CustomJLabel("Email: ",15, Color.BLACK,Color.WHITE);
		this.phoneNumberLabel= new CustomJLabel("Phone Number: ",15, Color.BLACK,Color.WHITE);
		this.dniLabel=new CustomJLabel("DNI: ",15, Color.BLACK,Color.WHITE);
		this.userNumberLabel=new CustomJLabel("userNumberField: ",15, Color.BLACK,Color.WHITE);
		
		this.nameTextField=new JTextField(20);
		this.surnameTextField=new JTextField(20);
		this.userNameTextField=new JTextField(20);
		this.passwordTextField= new JPasswordField(20);
		this.passwordRepeatTextField= new JPasswordField(20);
		this.emailTextField=new JTextField(20);
		this.phoneNumberField=new JTextField(20);
		this.dniField=new JTextField(20);
		this.userNumberField=new JTextField(20);
		
		this.namePanel.add(nameLabel);
		this.namePanel.add(new JLabel());
		this.namePanel.add(nameTextField);
		this.surnamePanel.add(surnameLabel);
		this.surnamePanel.add(new JLabel());
		this.surnamePanel.add(surnameTextField);
		this.userNamePanel.add(userNameLabel);
		this.userNamePanel.add(userNameTextField);
		this.passwordPanel.add(passwordLabel);
		this.passwordPanel.add(new JLabel());
		this.passwordPanel.add(passwordTextField);
		this.passwordRepeatPanel.add(passwordRepeatLabel);
		this.passwordRepeatPanel.add(passwordRepeatTextField);
		this.birthdayPanel.add(bithdayDatePicker);
		this.sexPanel.add(sexLabel);
		this.sexPanel.add(SexComboBox);
		this.emailPanel.add(emailLabel);
		this.emailPanel.add(new JLabel());
		this.emailPanel.add(emailTextField);
		this.phoneNumberPanel.add(phoneNumberLabel);
		this.phoneNumberPanel.add(new JLabel());
		this.phoneNumberPanel.add(phoneNumberField);
		this.dniPanel.add(dniLabel);
		this.dniPanel.add(new JLabel());
		this.dniPanel.add(dniField);
		this.userNumberPanel.add(userNumberLabel);
		this.userNumberPanel.add(new JLabel());
		this.userNumberPanel.add(userNumberField);
		
		this.cancelButton=new RoundedButton("CANCEL", Color.decode("#09A8E4"));
		this.cancelButton.setPreferredSize(new Dimension(90, 30));
		this.cancelPanel.add(cancelButton);
		this.createAcountButton=new RoundedButton("CREATE ACOUNT", Color.decode("#09A8E4"));
		this.createAcountButton.setPreferredSize(new Dimension(130, 30));
		this.createAcountPanel.add(createAcountButton);
		
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
        frame.getContentPane().add(new SignInPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	

}
