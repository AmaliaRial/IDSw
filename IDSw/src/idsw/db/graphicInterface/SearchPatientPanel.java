package idsw.db.graphicInterface;

import javax.swing.*;


import idsw.db.graphicInterface.components.*;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.pojos.Patient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPatientPanel extends JPanel implements ActionListener{
	public JPanel northPanel;
	public JPanel centerPanel;
	public JPanel southPanel;
	public JPanel rightPanel;
	public JPanel leftPanel;
	
	public CustomJLabel searchLabel;
	public JTextField searchField;
	public CircularIconButton searchButton;
	public RoundedButton backButton;
	
	public ConnectionManager conMan;
	public GraphicAplication app;
	
	public SearchPatientPanel(ConnectionManager conMan, GraphicAplication app) {
		this.conMan=conMan;
		this.app=app;
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.northPanel.setBackground(Color.decode("#A5E0F1"));
		this.add(this.northPanel, BorderLayout.NORTH);
		this.searchLabel = new CustomJLabel("<html><b>SEARCH FOR A PATIENT</b></html>", 20, Color.decode("#09A8E4"), Color.decode("#A5E0F1"));
		this.northPanel.add(this.searchLabel);
		
		this.centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.centerPanel.setBackground(Color.WHITE);
		this.add(this.centerPanel, BorderLayout.CENTER);
		this.searchField = new JTextField(20);
		this.searchField.setFont(new Font("Arial", Font.PLAIN, 20));
		this.centerPanel.add(this.searchField);
		this.searchButton = new CircularIconButton(new ImageIcon("./src/ids/db/graphicInterface/components/Search_Icon.png"));
		this.searchButton.setPreferredSize(new Dimension(30, 30));
		this.centerPanel.add(this.searchButton);
		
		
		this.southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.southPanel.setBackground(Color.WHITE);
		this.add(this.southPanel, BorderLayout.SOUTH);
		this.backButton=new RoundedButton("Back", Color.decode("#09A8E4"));
		this.backButton.setPreferredSize(new Dimension(90, 30));
		this.southPanel.add(backButton);
		this.rightPanel = new JPanel();
		this.rightPanel.setPreferredSize(new Dimension(20, 20));
		this.rightPanel.setBackground(Color.WHITE);
		this.southPanel.add(this.rightPanel);
		this.leftPanel = new JPanel();
		this.leftPanel.setPreferredSize(new Dimension(20, 20));
		this.leftPanel.setBackground(Color.WHITE);
		this.southPanel.add(this.leftPanel);
	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(new SearchPatientPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Integer id_patient;
		if(e.getSource()==this.searchButton) {
			Long hiNumber=Long.parseLong(this.searchField.getText());
			Patient patient =this.conMan.getPatientMan().getPatientByName(this.app.getUser().getName());
			id_patient=patient.getIdPatient();
			this.app.fromSearchPatientPanelToMedicalRecordForDoctorPanel(id_patient);	
		}else if(e.getSource()==this.backButton) {
			this.app.fromSearchPatientPanelToHomePanelDoctor();	
		}
		
	}

}
