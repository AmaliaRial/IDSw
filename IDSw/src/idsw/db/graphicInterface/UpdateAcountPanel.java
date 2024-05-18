package idsw.db.graphicInterface;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import idsw.db.enums.Sex;
import idsw.db.graphicInterface.components.*;

public class UpdateAcountPanel extends JPanel {
	public JPanel northPanel;
	public JPanel midlePanel;
		public JPanel namePanel;
		public JPanel surnamePanel;
		public JPanel userNamePanel;
		public JPanel birthdayPanel;
		public JPanel sexPanel;
		public JPanel emailPanel;
		public JPanel phoneNumberPanel;
		public JPanel dniPanel;
	public JPanel southPanel;
		public JPanel cancelPanel;
		public JPanel saveAcountPanel;
	public JPanel leftSpace;
	public JPanel rightSpace;
	
	public CustomJLabel titleLabel;
	
	public CustomJLabel nameLabel;
	public CustomJLabel surnameLabel;
	public CustomJLabel userNameLabel;
	public CustomJLabel bithdayLabel;
	public CustomJLabel sexLabel;
	public CustomJLabel emailLabel;
	public CustomJLabel phoneNumberLabel;
	public CustomJLabel dniLabel;
	public JTextField nameTextField;
	public JTextField surnameTextField;
	public JTextField userNameTextField;
	public DateInputPanel bithdayDatePicker;
	public JComboBox<String> SexComboBox;
	public JTextField emailTextField;
	public JTextField phoneNumberField;
	public JTextField dniField;
	
	public RoundedButton cancelButton;
	public RoundedButton saveButton;
	
	public UpdateAcountPanel(){
		this.setLayout(new BorderLayout());
		this.northPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.northPanel.setBackground(Color.decode("#A5E0F1"));
		this.add(northPanel,BorderLayout.NORTH);
		
		this.midlePanel=new JPanel(new GridLayout(8,1));
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
		
		this.southPanel=new JPanel(new GridLayout(1,2));
		this.southPanel.setBackground(Color.WHITE);
		this.add(southPanel,BorderLayout.SOUTH);
			this.cancelPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.cancelPanel.setBackground(Color.WHITE);
			this.southPanel.add(cancelPanel);
			this.saveAcountPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
			this.saveAcountPanel.setBackground(Color.WHITE);
			this.southPanel.add(saveAcountPanel);
			
		this.titleLabel=new CustomJLabel("<html><b>UPDATE ACCOUNT</b></html>",20, Color.decode("#09A8E4"),Color.decode("#A5E0F1"));
		this.northPanel.add(titleLabel);
			
		this.nameLabel= new CustomJLabel("Name: ",15, Color.BLACK,Color.WHITE);
		this.surnameLabel= new CustomJLabel("Surname: ",15, Color.BLACK,Color.WHITE);
		this.userNameLabel= new CustomJLabel("UserName: ",15, Color.BLACK,Color.WHITE);
		this.bithdayLabel= new CustomJLabel("Birthday: ",15, Color.BLACK,Color.WHITE);
		this.bithdayDatePicker= new DateInputPanel();
		this.sexLabel=new CustomJLabel("Sex: ",15, Color.BLACK,Color.WHITE);
		String[] sexs= {"MALE", "FEMALE"};
		this.SexComboBox=new JComboBox<String>(sexs);
		this.emailLabel=new CustomJLabel("Email: ",15, Color.BLACK,Color.WHITE);
		this.phoneNumberLabel= new CustomJLabel("Phone Number: ",15, Color.BLACK,Color.WHITE);
		this.dniLabel=new CustomJLabel("DNI: ",15, Color.BLACK,Color.WHITE);
		
		this.nameTextField=new JTextField(20);
		this.surnameTextField=new JTextField(20);
		this.userNameTextField=new JTextField(20);
		this.emailTextField=new JTextField(20);
		this.phoneNumberField=new JTextField(20);
		this.dniField=new JTextField(20);
		
		this.namePanel.add(nameLabel);
		this.namePanel.add(new JLabel());
		this.namePanel.add(nameTextField);
		this.surnamePanel.add(surnameLabel);
		this.surnamePanel.add(new JLabel());
		this.surnamePanel.add(surnameTextField);
		this.userNamePanel.add(userNameLabel);
		this.userNamePanel.add(userNameTextField);
		this.birthdayPanel.add(bithdayLabel);
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
		
		this.cancelButton=new RoundedButton("CANCEL", Color.decode("#09A8E4"));
		this.cancelButton.setPreferredSize(new Dimension(90, 30));
		this.cancelPanel.add(cancelButton);
		this.saveButton=new RoundedButton("SAVE", Color.decode("#09A8E4"));
		this.saveButton.setPreferredSize(new Dimension(130, 30));
		this.saveAcountPanel.add(saveButton);
		
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
        frame.getContentPane().add(new UpdateAcountPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	

}
