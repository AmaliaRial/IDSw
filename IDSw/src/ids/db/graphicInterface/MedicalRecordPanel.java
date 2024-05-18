package idsw.db.graphicInterface;

import ids.db.graphicInterface.components.CircularIconButton;
import ids.db.graphicInterface.components.CustomJLabel;
import ids.db.graphicInterface.components.DateInputPanel;
import ids.db.graphicInterface.components.RoundedButton;
import idsw.db.jdbc.ConnectionManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Patient;

public class MedicalRecordPanel extends JPanel {
	public JPanel northPanel;
		public JPanel GridNorthPanel;
			public JPanel userPanel;
				public JPanel userPhotoBottonPanel;
				public JPanel userInformationPanel;	
					public JPanel namePanel;
					public JPanel surnamePanel;
			public JPanel buttonPanel;
	public JPanel midlePanel;
		public JPanel titleDatePanel;
			public JPanel titlePanel;
			public JPanel datePanel;
				public JPanel enterPanel;
		public JPanel diagnosesPanel;
	public JPanel leftSpace;
	public JPanel rightSpace;
	public JPanel southPanel;
	public JPanel downSpace;
	
	public CircularIconButton userPhotoBotton;
	public CustomJLabel nameLabel;
	public CustomJLabel surnameLabel;
	
	public CustomJLabel TitleLabel;
	public DateInputPanel dateComponentPanel;
	public JScrollPane diagnosesList;
	
	private RoundedButton backButton;
	private RoundedButton enterButton;
	
	private ConnectionManager conMan;
	
	public MedicalRecordPanel(Integer id_patient){
		this.conMan=new ConnectionManager();
		
		this.setLayout(new BorderLayout());
		this.northPanel=new JPanel(new GridLayout(2,2));
		this.add(northPanel, BorderLayout.NORTH);
			this.northPanel.setBackground(Color.decode("#A5E0F1"));
			 this.userPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			 	this.userPanel.setBackground(Color.decode("#A5E0F1"));
			 this.northPanel.add(userPanel);
			 this.buttonPanel=new JPanel();
			 this.buttonPanel.setBackground(Color.decode("#A5E0F1"));
			 this.northPanel.add(buttonPanel);
			  this.userPhotoBottonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
			  	this.userPhotoBottonPanel.setBackground(Color.decode("#A5E0F1"));
			  this.userPanel.add(userPhotoBottonPanel);
			  this.userInformationPanel=new JPanel(new GridLayout(2,1));
			  	this.userInformationPanel.setBackground(Color.decode("#A5E0F1"));
			  this.userPanel.add(userInformationPanel);
			  	this.namePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			  		this.namePanel.setBackground(Color.decode("#A5E0F1"));
			  	this.userInformationPanel.add(namePanel);
			  	this.surnamePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			  		this.surnamePanel.setBackground(Color.decode("#A5E0F1"));
			  	this.userInformationPanel.add(surnamePanel);
			 
			  	
		this.midlePanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
			this.midlePanel.setBackground(Color.WHITE);
		this.add(midlePanel,BorderLayout.CENTER);
		//this.titleDatePanel= new JPanel(new GridLayout(1,2,5,5));
		//this.midlePanel.add(titleDatePanel);
			this.titlePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				this.titlePanel.setBackground(Color.WHITE);
			this.northPanel.add(titlePanel);
			this.datePanel=new JPanel(new GridLayout(2,1));
				this.datePanel.setBackground(Color.WHITE);
			this.northPanel.add(datePanel);
		this.diagnosesPanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
			this.diagnosesPanel.setBackground(Color.WHITE);
		this.midlePanel.add(diagnosesPanel);
		
		Patient patient=this.conMan.getPatientMan().getPatient(id_patient);
		
		this.userPhotoBotton= new CircularIconButton(new ImageIcon("./src/ids/db/graphicInterface/components/user.png"));
		this.userPhotoBottonPanel.add(userPhotoBotton);
		this.nameLabel=new CustomJLabel("Name: "+patient.getNamePatient(), 15,Color.decode("#09A8E4"),Color.decode("#A5E0F1"));
		this.namePanel.add(nameLabel);
		this.surnameLabel=new CustomJLabel("Surname: "+patient.getSurname(), 15,Color.decode("#09A8E4"),Color.decode("#A5E0F1"));
		this.surnamePanel.add(surnameLabel);
		
		this.TitleLabel= new CustomJLabel("<html><b>MEDICAL RECORD</b></html>", 30,Color.decode("#09A8E4"),Color.WHITE);
		this.titlePanel.add(TitleLabel);
		this.dateComponentPanel=new DateInputPanel();
		this.datePanel.add(dateComponentPanel);
		this.enterPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.enterPanel.setBackground(Color.WHITE);
		this.enterButton= new RoundedButton("Enter",Color.decode("#09A8E4"));
		this.enterButton.setPreferredSize(new Dimension(80, 30));
		this.enterPanel.add(enterButton);
		this.enterPanel.add(new JLabel());this.enterPanel.add(new JLabel());this.enterPanel.add(new JLabel());
		this.datePanel.add(enterPanel);
		
		
		
		List<Diagnosis> diagnoses= this.conMan.getDiagnosisMan().listMatchinDiagnosesByPatient(id_patient);
		DefaultListModel<String> listModel = ListNameofDiagnoses(diagnoses);
		JList<String> lista = new JList<>(listModel);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.diagnosesList= new JScrollPane(lista);
		this.diagnosesList.setPreferredSize(new Dimension(600, 300));
		this.midlePanel.add(diagnosesList);
		
		this.southPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.southPanel.setBackground(Color.WHITE);
		this.backButton=new RoundedButton("BACK",Color.decode("#09A8E4"));
		this.backButton.setPreferredSize(new Dimension(90, 30));
		this.southPanel.add(backButton);
		this.add(southPanel,BorderLayout.SOUTH);
		
		this.leftSpace = new JPanel();
        this.leftSpace.setPreferredSize(new Dimension(20, 10)); // Ancho de 10 píxeles
        add(leftSpace, BorderLayout.WEST);
        this.leftSpace.setBackground(Color.WHITE);
        
        this.rightSpace = new JPanel();
        this.rightSpace.setPreferredSize(new Dimension(20, 10)); // Ancho de 10 píxeles
        add(rightSpace, BorderLayout.EAST);
        this.rightSpace.setBackground(Color.WHITE);
     
	}
	
	private DefaultListModel<String> ListNameofDiagnoses(List<Diagnosis> diagnoses){
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(Diagnosis diagnosis:diagnoses) {
			listModel.addElement(diagnosis.getNameDiagnosis());
		}
		return listModel;
	}
	
	
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MedicalRecordPanel(3));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
	

}
