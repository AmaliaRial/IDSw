package idsw.db.graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import idsw.db.graphicInterface.components.CustomJLabel;
import idsw.db.graphicInterface.components.RoundedButton;
import idsw.db.jdbc.ConnectionManager;

public class DiagnosisTemplatePanel extends JPanel {
	public JPanel northPanel;
		public JPanel titlePanel;
	public JPanel midlePanel;
			public JPanel dataPanel;
				public JPanel nameDiseasePanel;
				public JPanel datePanel;
				public JPanel comentSectionPanel;
				public JPanel treatmentsTitlePanel;
			public JPanel treatmentsPanel;
	public JPanel southPanel;
		public JPanel backCalcelPanel;
	public JPanel leftSpace;
	public JPanel rightSpace;
	
	public CustomJLabel titleLabel;
	public CustomJLabel nameDiseaseLabel;
	public CustomJLabel dateLabel;
	public CustomJLabel comentSectionLabel;
	public CustomJLabel treatmentsLabel;
	
	public RoundedButton backCalceButton;
	
	public ConnectionManager conMan;
	
	public DiagnosisTemplatePanel() {
		this.conMan= new ConnectionManager();
		
		this.setLayout(new BorderLayout());
		this.northPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.northPanel.setBackground(Color.decode("#A5E0F1"));
		this.add(northPanel,BorderLayout.NORTH);
		
		this.midlePanel=new JPanel(new GridLayout(2,1));
		this.midlePanel.setBackground(Color.WHITE);
		this.add(midlePanel,BorderLayout.CENTER);
			this.dataPanel=new JPanel(new GridLayout(5,1));
			this.dataPanel.setBackground(Color.WHITE);
			this.midlePanel.add(dataPanel);
				this.dataPanel.add(new JLabel());
				this.nameDiseasePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				this.nameDiseasePanel.setBackground(Color.WHITE);
				this.dataPanel.add(nameDiseasePanel);
				this.datePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				this.datePanel.setBackground(Color.WHITE);
				this.dataPanel.add(datePanel);
				this.comentSectionPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				this.comentSectionPanel.setBackground(Color.WHITE);
				this.dataPanel.add(comentSectionPanel);
				this.treatmentsTitlePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				this.treatmentsTitlePanel.setBackground(Color.WHITE);
				this.dataPanel.add(treatmentsTitlePanel);
			this.treatmentsPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
			this.treatmentsPanel.setBackground(Color.WHITE);
			this.midlePanel.add(treatmentsPanel);
			
			this.southPanel= new JPanel(new GridLayout(1,2));
			this.southPanel.setBackground(Color.WHITE);
			this.add(southPanel,BorderLayout.SOUTH);
			this.backCalcelPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.backCalcelPanel.setBackground(Color.WHITE);
			this.southPanel.add(backCalcelPanel);
			this.backCalceButton=new RoundedButton("Back/Canccel",Color.decode("#09A8E4"));
			this.backCalcelPanel.add(backCalceButton);
			this.backCalceButton.setPreferredSize(new Dimension(90,30));
			
			this.titleLabel=new CustomJLabel("<html><b>TITLE</b></html>", 30,Color.decode("#09A8E4"),Color.decode("#A5E0F1"));
			this.northPanel.add(titleLabel);
			this.nameDiseaseLabel=new CustomJLabel("Disease:", 15,Color.BLACK,Color.WHITE);
			this.nameDiseasePanel.add(nameDiseaseLabel);
			this.dateLabel=new CustomJLabel("Date: ", 15,Color.BLACK,Color.WHITE);
			this.datePanel.add(dateLabel);
			this.comentSectionLabel=new CustomJLabel("Coment Section: ", 15,Color.BLACK,Color.WHITE);
			this.comentSectionPanel.add(comentSectionLabel);
			this.treatmentsLabel=new CustomJLabel("Treatments: ", 15,Color.BLACK,Color.WHITE);
			this.treatmentsTitlePanel.add(treatmentsLabel);

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
        frame.getContentPane().add(new DiagnosisTemplatePanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
	
	

}
