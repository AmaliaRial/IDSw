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
import idsw.db.jpa.JPAUserManager;

public class DiseaseTempletePanel extends JPanel {
	public JPanel northPanel;
		public JPanel titlePanel;
	public JPanel midlePanel;
			public JPanel uperPanel;
				public JPanel dataPanel;
					public JPanel causeDiseasePanel;
					public JPanel namePanel;
					public JPanel mortalityPanel;
					public JPanel infectiousPanel;
					public JPanel incuvationPeriotPanel;
					public JPanel developmentPeriotPanel;
					public JPanel convalescensePeriotPanel;
					public JPanel commentSectionPanel;
				public JPanel developmentGraphPanel;
			public JPanel selectionPanel;
				public JPanel symptomsPanel;
					public JPanel symptomLabelPanel;
					public JPanel symptomListPanel;
				public JPanel treatmentsPanel;
					public JPanel treatmentsLabelPanel;
					public JPanel treatmentsListPanel;
	public JPanel southPanel;
		public JPanel backCalcelPanel;
		public JPanel savePanel;
	public JPanel leftSpace;
	public JPanel rightSpace;
	
	public JLabel titleLabel;
	public JLabel nameLabel;
	public JLabel causeDiseaseLabel;
	public JLabel mortalityLabel;
	public JLabel infectiousLabel;
	public JLabel incuvationPeriotLabel;
	public JLabel developmentPeriotLabel;
	public JLabel convalescensePeriotLabel;
	public JLabel commentSectionLabel;
	public JLabel symptomLabel;
	public JLabel treatmentLabel;
	

	
	public RoundedButton backCancelButton;
	
	public ConnectionManager conMan;
	public JPAUserManager jpaConMan;
	public GraphicAplication app;
	
	
	public DiseaseTempletePanel(ConnectionManager conMan, JPAUserManager jpaConMan,GraphicAplication app) {
		this.jpaConMan=jpaConMan;
		this.app=app;
		this.conMan=conMan;
		this.setLayout(new BorderLayout());
		this.northPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.northPanel.setBackground(Color.decode("#A5E0F1"));
		this.add(northPanel,BorderLayout.NORTH);
		
		this.midlePanel=new JPanel(new GridLayout(2,1));
		this.midlePanel.setBackground(Color.WHITE);
		this.add(midlePanel,BorderLayout.CENTER);
			this.uperPanel=new JPanel(new GridLayout(1,2));
			this.uperPanel.setBackground(Color.WHITE);
			this.midlePanel.add(uperPanel);
				this.dataPanel=new JPanel(new GridLayout(8,1));
				this.dataPanel.setBackground(Color.WHITE);
				this.uperPanel.add(dataPanel);
					//this.dataPanel.add(new JLabel());
					this.namePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
					this.namePanel.setBackground(Color.WHITE);
					this.dataPanel.add(namePanel);
					this.causeDiseasePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
					this.causeDiseasePanel.setBackground(Color.WHITE);
					this.dataPanel.add(causeDiseasePanel);
					this.mortalityPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
					this.mortalityPanel.setBackground(Color.WHITE);
					this.dataPanel.add(mortalityPanel);
					this.infectiousPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
					this.infectiousPanel.setBackground(Color.WHITE);
					this.dataPanel.add(infectiousPanel);
					this.incuvationPeriotPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
					this.incuvationPeriotPanel.setBackground(Color.WHITE);
					this.dataPanel.add(incuvationPeriotPanel);
					this.developmentPeriotPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
					this.developmentPeriotPanel.setBackground(Color.WHITE);
					this.dataPanel.add(developmentPeriotPanel);
					this.convalescensePeriotPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
					this.convalescensePeriotPanel.setBackground(Color.WHITE);
					this.dataPanel.add(convalescensePeriotPanel);
					this.commentSectionPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
					this.commentSectionPanel.setBackground(Color.WHITE);
					this.dataPanel.add(commentSectionPanel);
				this.developmentGraphPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
				this.developmentGraphPanel.setBackground(Color.WHITE);
				this.uperPanel.add(developmentGraphPanel);
				
			this.selectionPanel=new JPanel(new GridLayout(1,2));
			this.selectionPanel.setBackground(Color.WHITE);
			this.midlePanel.add(selectionPanel);
				this.symptomsPanel=new JPanel(new BorderLayout());
				this.symptomsPanel.setBackground(Color.WHITE);
				this.selectionPanel.add(symptomsPanel);
					this.symptomLabelPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
					this.symptomLabelPanel.setBackground(Color.WHITE);
					this.symptomsPanel.add(symptomLabelPanel,BorderLayout.NORTH);
					this.symptomListPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
					this.symptomListPanel.setBackground(Color.WHITE);
					this.symptomsPanel.add(symptomListPanel,BorderLayout.CENTER);
					
			
				this.treatmentsPanel=new JPanel(new BorderLayout());
				this.treatmentsPanel.setBackground(Color.WHITE);
				this.selectionPanel.add(treatmentsPanel);
					this.treatmentsLabelPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
					this.treatmentsLabelPanel.setBackground(Color.WHITE);
					this.treatmentsPanel.add(treatmentsLabelPanel,BorderLayout.NORTH);
					this.treatmentsListPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
					this.treatmentsListPanel.setBackground(Color.WHITE);
					this.treatmentsPanel.add(treatmentsListPanel,BorderLayout.CENTER);

			
			this.southPanel= new JPanel(new GridLayout(1,2));
			this.southPanel.setBackground(Color.WHITE);
			this.add(southPanel,BorderLayout.SOUTH);
			this.backCalcelPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.backCalcelPanel.setBackground(Color.WHITE);
			this.southPanel.add(backCalcelPanel);
			this.savePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
			this.savePanel.setBackground(Color.WHITE);
			this.southPanel.add(savePanel);
			this.backCancelButton=new RoundedButton("Back/Canccel",Color.decode("#09A8E4"));
			this.backCalcelPanel.add(backCancelButton);
			this.backCancelButton.setPreferredSize(new Dimension(90,30));
			
			
			this.titleLabel=new CustomJLabel("<html><b>TITLE</b></html>", 30,Color.decode("#09A8E4"),Color.decode("#A5E0F1"));
			this.northPanel.add(titleLabel);
			this.nameLabel=new CustomJLabel("Name:", 12,Color.BLACK,Color.WHITE);
			this.namePanel.add(nameLabel);
			this.causeDiseaseLabel=new CustomJLabel("Cause:", 12,Color.BLACK,Color.WHITE);
			this.causeDiseasePanel.add(causeDiseaseLabel);
			this.mortalityLabel=new CustomJLabel("Mortality Rate: ", 12,Color.BLACK,Color.WHITE);
			this.mortalityPanel.add(mortalityLabel);
			this.infectiousLabel=new CustomJLabel("Infectous Rate: ", 12,Color.BLACK,Color.WHITE);
			this.infectiousPanel.add(infectiousLabel);
			this.incuvationPeriotLabel=new CustomJLabel("Incuvation Period: ", 12,Color.BLACK,Color.WHITE);
			this.incuvationPeriotPanel.add(incuvationPeriotLabel);
			this.developmentPeriotLabel=new CustomJLabel("Development Period", 12,Color.BLACK,Color.WHITE);
			this.developmentPeriotPanel.add(developmentPeriotLabel);
			this.convalescensePeriotLabel=new CustomJLabel("Covalescese Period:", 12,Color.BLACK,Color.WHITE);
			this.convalescensePeriotPanel.add(convalescensePeriotLabel);
			this.commentSectionLabel=new CustomJLabel("Comment Section: ", 12,Color.BLACK,Color.WHITE);
			this.commentSectionPanel.add(commentSectionLabel);
			this.symptomLabel=new CustomJLabel("Symptoms: ", 12,Color.BLACK,Color.WHITE);
			this.symptomLabelPanel.add(symptomLabel);
			this.treatmentLabel=new CustomJLabel("Treatmets: ", 12,Color.BLACK,Color.WHITE);
			this.treatmentsLabelPanel.add(treatmentLabel);
			
	
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
	    //frame.getContentPane().add(new DiseaseTempletePanel());
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}
}
