package idsw.db.graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import idsw.db.graphicInterface.components.*;
import idsw.db.jpa.JPAUserManager;
import idsw.db.pojos.User;

import javax.swing.*;

public class HomePanel extends JPanel {
	public JPanel northPanel;
	public JPanel mediumPanel;
		public JPanel buttonBorder;
			public JPanel buttonPanel;
		public JPanel homeUserPanel;
			public JPanel userPanel;
			public JPanel homePanel;
	public JPanel downSpace;
	public JPanel rightSpace;
	public JPanel leftSpace;

	public CircularIconButton userButton;
	public CircularIconButton homeButton;
	public RoundedButton searchButton;
	public RoundedButton b1;
	public RoundedButton b2;
	public RoundedButton b3;
	public RoundedButton b4;
	public RoundedButton b5;
	public RoundedButton b6;
	public CustomJLabel titleLabel;
	
	public HomePanel(){
		
		this.setLayout(new BorderLayout());
		this.northPanel = new JPanel(new GridLayout(2,1));
		this.northPanel.setPreferredSize(new Dimension(400,110));
        this.add(northPanel, BorderLayout.NORTH);
		
		this.buttonBorder= new JPanel(new BorderLayout());
		this.buttonBorder.setBackground(Color.decode("#A5E0F1"));
		this.buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
			this.buttonPanel.setBackground(Color.decode("#A5E0F1"));
				this.buttonBorder.add(buttonPanel,BorderLayout.SOUTH);
		this.homeUserPanel= new JPanel(new  GridLayout(1,3));
			this.homeUserPanel.setBackground(Color.decode("#A5E0F1"));
			this.userPanel= new JPanel(new  FlowLayout(FlowLayout.RIGHT));
				this.userPanel.setBackground(Color.decode("#A5E0F1"));
			this.homePanel= new JPanel(new  FlowLayout(FlowLayout.LEFT));
				this.homePanel.setBackground(Color.decode("#A5E0F1"));
		
		this.userButton = new CircularIconButton(new ImageIcon("./src/idsw/db/graphicInterface/components/user.png"));
        
        this.userPanel.add(userButton);
        
        this.homeButton = new CircularIconButton(new ImageIcon("./src/idsw/db/graphicInterface/components/Home.png"));
        this.homePanel.add(homeButton);
        
        this.homeUserPanel.add(homePanel);
        this.titleLabel=new CustomJLabel("<html><b>INFECTIOUS DISEASE</b></html>",15,Color.decode("#09A8E4"),Color.decode("#A5E0F1"));
        this.homeUserPanel.add(titleLabel);
        this.homeUserPanel.add(userPanel);
        this.northPanel.add(homeUserPanel);
        
        
        this.searchButton = new RoundedButton("SEARCH", Color.decode("#09A8E4"));
        this.searchButton.setPreferredSize(new Dimension(90, 30));
      
        this.buttonPanel.add(searchButton);
        this.northPanel.add(buttonBorder);
        
        this.mediumPanel=new JPanel(new GridBagLayout());;
		this.mediumPanel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 5, 0, 5);
        
        this.b1 = new RoundedButton("",Color.decode("#F1C832"));
        this.b2 = new RoundedButton("",Color.decode("#F1C832"));
        this.b3 = new RoundedButton("",Color.decode("#F1C832"));
        this.b4 = new RoundedButton("",Color.decode("#F1C832"));
        this.b5 = new RoundedButton("",Color.decode("#F1C832"));
        this.b6 = new RoundedButton("",Color.decode("#F1C832"));
        
        this.mediumPanel.add(b1,gbc);
        gbc.gridy = 1;
        this.mediumPanel.add(b2,gbc);
        gbc.gridy = 2;
        this.mediumPanel.add(b3,gbc);
        gbc.gridy = 3;
        this.mediumPanel.add(b4,gbc);
        gbc.gridy = 4;
        this.mediumPanel.add(b5,gbc);
        gbc.gridy = 5;
        this.mediumPanel.add(b6,gbc);
        
        add(mediumPanel, BorderLayout.CENTER);
        add(northPanel,BorderLayout.NORTH);
        
        this.leftSpace = new JPanel();
        this.leftSpace.setPreferredSize(new Dimension(20, 10)); // Ancho de 10 píxeles
        add(leftSpace, BorderLayout.WEST);
        this.leftSpace.setBackground(Color.WHITE);
        
        this.rightSpace = new JPanel();
        this.rightSpace.setPreferredSize(new Dimension(20, 10)); // Ancho de 10 píxeles
        add(rightSpace, BorderLayout.EAST);
        this.rightSpace.setBackground(Color.WHITE);
        
        this.downSpace = new JPanel();
        this.downSpace.setPreferredSize(new Dimension(20, 20)); // Ancho de 10 píxeles
        add(downSpace, BorderLayout.SOUTH);
        this.downSpace.setBackground(Color.WHITE);
      
		
	}
	
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new  HomePanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	

}
