package ids.db.graphicInterface;

import ids.db.graphicInterface.components.*;
import java.awt.*;
import java.sql.Connection;
import java.util.*;
import javax.swing.*;

import idsw.db.jdbc.ConnectionManager;
import idsw.db.jpa.JPAUserManager;
import idsw.db.pojos.*;

public class LogOutPanel extends JPanel {
	public JPanel northSpace;
	public JPanel centerPanel;
		public JPanel iconPanel;
		public JPanel editAcountButtonPanel;
		public JPanel infoPanel;
		public JPanel usernamePanel;
		public JPanel emailPanel;
	public JPanel buttonsPanel;
	public JPanel leftSpace;
	public JPanel rightSpace;
	
	public CustomJLabel userNameLabel;
	public CustomJLabel emailLabel;
	
	public CircularIconButton userPhoto;
	
	public RoundedButton editAcountButton;
	public RoundedButton logOutButton;
	public RoundedButton changeAccountButton;
	
	public JPAUserManager userManager;
	
	public LogOutPanel(String username) {
		this.userManager=new JPAUserManager();
		
		this.setLayout(new BorderLayout());        
        this.rightSpace = new JPanel();
        this.rightSpace.setPreferredSize(new Dimension(60,10));
        this.add(rightSpace, BorderLayout.EAST);
        this.rightSpace.setBackground(Color.WHITE);
		
        this.northSpace = new JPanel();
        this.northSpace.setPreferredSize(new Dimension(20, 10)); 
        this.add(northSpace, BorderLayout.NORTH);
        this.northSpace.setBackground(Color.WHITE);
        
        this.centerPanel = new JPanel(new GridLayout(2,2));
        this.centerPanel.setBackground(Color.WHITE);
        add(centerPanel, BorderLayout.CENTER);
        this.iconPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.iconPanel.setBackground(Color.WHITE);
        this.centerPanel.add(iconPanel);
       
        this.infoPanel = new JPanel(new GridLayout(2,1));
        this.infoPanel.setBackground(Color.WHITE);
        this.centerPanel.add(infoPanel);
        this.usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.usernamePanel.setBackground(Color.WHITE);
        this.infoPanel.add(usernamePanel);
        this.emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.emailPanel.setBackground(Color.WHITE);
        this.infoPanel.add(emailPanel);
        this.editAcountButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.editAcountButtonPanel.setBackground(Color.WHITE);
        this.centerPanel.add(editAcountButtonPanel); 
        
        User user=this.userManager.getUser(username);
		
		this.userPhoto= new CircularIconButton(new ImageIcon("./src/ids/db/graphicInterface/components/user.png"));
		this.userPhoto.setPreferredSize(new Dimension(100, 100));
		this.iconPanel.add(userPhoto);
		this.userNameLabel = new CustomJLabel("Username: "+ user.getUsername(),15,Color.BLACK,Color.WHITE);
		this.usernamePanel.add(userNameLabel);
		this.emailLabel = new CustomJLabel("Email: " + user.getEmail() , 15,Color.BLACK,Color.WHITE);
		this.emailPanel.add(emailLabel);
		this.editAcountButton = new RoundedButton("Edit Account",Color.decode("#09A8E4"));
		this.editAcountButton.setPreferredSize(new Dimension(90, 30));
		this.editAcountButtonPanel.add(editAcountButton);
		
		this.buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.buttonsPanel.setBackground(Color.WHITE);
		add(buttonsPanel, BorderLayout.SOUTH);
		this.changeAccountButton = new RoundedButton("Change Account",Color.decode("#09A8E4"));
		this.changeAccountButton.setPreferredSize(new Dimension(120, 30));
		this.buttonsPanel.add(changeAccountButton);
		this.logOutButton = new RoundedButton("Log Out",Color.decode("#09A8E4"));
		this.logOutButton.setPreferredSize(new Dimension(90, 30));
		this.buttonsPanel.add(logOutButton);
	}
	
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new LogOutPanel("jorgeG"));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
}
