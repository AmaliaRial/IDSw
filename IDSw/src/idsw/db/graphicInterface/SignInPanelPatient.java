package idsw.db.graphicInterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import idsw.db.graphicInterface.components.CustomJLabel;
import idsw.db.graphicInterface.components.DateInputPanel;
import idsw.db.jpa.JPAUserManager;
import idsw.db.pojos.Role;
import idsw.db.pojos.User;
import java.sql.Date;
import java.text.ParseException;

public class SignInPanelPatient extends SignInPanel implements ActionListener{
	
	public SignInPanelPatient(JPAUserManager jpaConMan, GraphicAplication app){
		super(jpaConMan,app);
		super.northPanel.setBackground(Color.decode("#C9F699"));
		super.signInLavel.setBackgroundColor(Color.decode("#C9F699"));
		super.signInLavel.setTextColor(Color.decode("#64B60D"));
		super.signInLavel.setText("<html><b>SIGN IN AS A PATIENT</b></html>");
		super.userNumberLabel.setText("Health Insurance number: ");
		super.createAcountButton.addActionListener(this);
		super.cancelButton.addActionListener(this);
	}
	
	  
    public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.createAcountButton) {
			/**
			String dni = this.dniField.getText();
			String name = this.nameTextField.getText();
			String surname = this.surnameTextField.getText();
			String userName = this.userNameTextField.getText();
			String sex = (String) this.SexComboBox.getSelectedItem();
			String email = this.emailTextField.getText();
			
			char[]passwordChar= this.passwordTextField.getPassword();
			String password=passwordChar.toString();//TODO  que son iguales
			char[]passwordRepeatedChar= this.passwordRepeatTextField.getPassword();
			String passwordRepeated=passwordRepeatedChar.toString();//TODO que son iguales
			
			Date dob = null;
				try {
					dob = this.bithdayDatePicker.getDate();// TODO gestionarlo falta
	
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			String phoneNumberText = this.phoneNumberField.getText();//TODO comprobar que es un numero
			Integer phoneNumber = 0;
	            try {
	                phoneNumber = Integer.parseInt(phoneNumberText);//TODO comprobar que es un numero
	            } catch (NumberFormatException excep) {
	            	
	            } 
	            
	        String userNumbeText = this.userNumberField.getText();
	        Integer userNumber = 0;
            try {
                userNumber = Integer.parseInt(userNumbeText);//TODO comprobar que es un numero
            } catch (NumberFormatException excep) {
            	
            } 
            Long userNumberLong = (long) phoneNumber;
            
	       
	        String roleText = "patient";
	        Role role=new Role(roleText);
			User user = new User(dni, dob, email, name, password, userNumberLong, phoneNumber, sex, surname, userName,null);
			this.jpaConMan.assignRole(user, role);
			this.jpaConMan.register(user);
			this.app.setUser(user);*/
			this.app.fromSingInPanelPatientToHomePanelPatient();
		}else if(e.getSource()==this.cancelButton) {
			
			this.app.fromSingInPanelPatientToChooseUserSignInPanel();
		}
    }
	
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new  SignInPanelPatient(new JPAUserManager(), new GraphicAplication()));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
}
