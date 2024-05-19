package idsw.db.graphicInterface;

import javax.swing.*;
import java.awt.*;
import idsw.db.graphicInterface.components.*;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.pojos.Simulation;

public class ViewSimulationResultPanel extends JPanel{
	public JPanel northPanel;
	public JPanel centerPanel;
		public JPanel infoPanel;
			public JPanel initialParametersPanel;
			public JPanel simulationResultsPanel;
		public JPanel graphPanel;
	public JPanel buttonsPanel;
		public JPanel exitButtonPanel;
		public JPanel downloadButtonPanel;
	public JPanel leftPanel;
	public JPanel rightPanel;
	
	public CustomJLabel titleLabel;
	public CustomJLabel Label;
	public CustomJLabel initialParametersLabel;
	public CustomJLabel numberPeopleLabel;
	public CustomJLabel inmunityPeriodLabel;
	public CustomJLabel illPercentageLabel;
	public CustomJLabel imnunePercentageLabel;
	public CustomJLabel healthyPercentageLabel;
	public CustomJLabel simulationResultsLabel;
	public CustomJLabel totalInfectionsLabel;
	public CustomJLabel totalDeathsLabel;
	public CustomJLabel finalTotalInmunityLabel;
	public CustomJLabel finalPopulationLabel;
	
	public RoundedButton exitButton;
	
	
	public ConnectionManager conMan;
	
	public ViewSimulationResultPanel(Integer id_simulation, Integer numberOfPeople, Integer inmunityPeriod, Float illPercentage, Float imnunePercentage, Float healthyPercentage) {
		this.conMan = new ConnectionManager();
		Simulation simulation=this.conMan.getSimulationMan().selectSimulation(id_simulation);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.northPanel.setBackground(Color.decode("#A5E0F1"));
		this.add(this.northPanel, BorderLayout.NORTH);
		this.titleLabel = new CustomJLabel("<html><b>SIMULATION OF DISEASE</b></html>", 20, Color.decode("#09A8E4"), Color.decode("#A5E0F1"));
		this.northPanel.add(this.titleLabel);
		
		this.centerPanel = new JPanel(new GridLayout(1, 2, 10, 10));
		this.centerPanel.setBackground(Color.WHITE);
		this.add(this.centerPanel, BorderLayout.CENTER);
		this.infoPanel = new JPanel(new GridLayout(2, 1, 10, 10));
		this.infoPanel.setBackground(Color.WHITE);
		this.centerPanel.add(this.infoPanel);
		this.initialParametersPanel = new JPanel(new GridLayout(8, 1, 10, 10));
		this.initialParametersPanel.setBackground(Color.WHITE);
		this.infoPanel.add(this.initialParametersPanel);
		this.simulationResultsPanel = new JPanel(new GridLayout(5, 1, 10, 10));
		this.simulationResultsPanel.setBackground(Color.WHITE);
		this.infoPanel.add(this.simulationResultsPanel);
		this.Label = new CustomJLabel(" ", 20, Color.BLACK, Color.WHITE);
		this.initialParametersPanel.add(this.Label);
		this.initialParametersLabel = new CustomJLabel("<html><b>INITIAL PARAMETERS:</b></html>", 15, Color.BLACK, Color.WHITE);
		this.initialParametersPanel.add(this.initialParametersLabel);
		this.numberPeopleLabel = new CustomJLabel("Number of people: " + numberOfPeople, 15, Color.BLACK, Color.WHITE);
		this.initialParametersPanel.add(this.numberPeopleLabel);
		this.inmunityPeriodLabel = new CustomJLabel("Inmunity Period: " + inmunityPeriod , 15, Color.BLACK, Color.WHITE);
		this.initialParametersPanel.add(this.inmunityPeriodLabel);
		this.illPercentageLabel = new CustomJLabel("Ill Percentage: " + illPercentage, 15, Color.BLACK, Color.WHITE);
		this.initialParametersPanel.add(this.illPercentageLabel);
		this.imnunePercentageLabel = new CustomJLabel("Imnune Percentage: " + imnunePercentage, 15, Color.BLACK, Color.WHITE);
		this.initialParametersPanel.add(this.imnunePercentageLabel);
		this.healthyPercentageLabel = new CustomJLabel("Healthy Percentage: " + healthyPercentage, 15, Color.BLACK, Color.WHITE);
		this.initialParametersPanel.add(this.healthyPercentageLabel);
		this.simulationResultsLabel = new CustomJLabel("<html><b>SIMULATION RESULTS:</b></html>", 15, Color.BLACK, Color.WHITE);
		this.simulationResultsPanel.add(this.simulationResultsLabel);
		this.totalInfectionsLabel = new CustomJLabel("Total Infections: " + simulation.getTotalInfections(), 15, Color.BLACK, Color.WHITE);
	    this.simulationResultsPanel.add(this.totalInfectionsLabel);
	    this.totalDeathsLabel = new CustomJLabel("Total Deaths: "+ simulation.getTotalDeaths(), 15, Color.BLACK, Color.WHITE);
	    this.simulationResultsPanel.add(this.totalDeathsLabel);
	    this.finalTotalInmunityLabel = new CustomJLabel("Final Total Inmunity: " + simulation.getTotalImmunity(), 15, Color.BLACK, Color.WHITE);
	    this.simulationResultsPanel.add(this.finalTotalInmunityLabel);
	    this.finalPopulationLabel = new CustomJLabel("Final Population Number: " + simulation.getTotalPopulation(), 15, Color.BLACK, Color.WHITE);
	    this.simulationResultsPanel.add(this.finalPopulationLabel);
	    
	    this.graphPanel = new JPanel();
	    this.graphPanel.setBackground(Color.WHITE);
	    this.centerPanel.add(this.graphPanel);
	   	
		this.rightPanel = new JPanel();
		this.rightPanel.setPreferredSize(new Dimension(20, 20));
		this.rightPanel.setBackground(Color.WHITE);
		this.add(this.rightPanel, BorderLayout.EAST);
		
		this.leftPanel = new JPanel();
		this.leftPanel.setPreferredSize(new Dimension(20, 20));
		this.leftPanel.setBackground(Color.WHITE);
		this.add(this.leftPanel, BorderLayout.WEST);
		
		this.buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
		this.buttonsPanel.setBackground(Color.WHITE);
		this.add(this.buttonsPanel, BorderLayout.SOUTH);
		this.exitButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.exitButtonPanel.setBackground(Color.WHITE);
		this.buttonsPanel.add(this.exitButtonPanel);
		this.exitButton = new RoundedButton("Exit", Color.decode("#09A8E4"));	
		this.exitButton.setPreferredSize(new Dimension(90, 30));
		this.exitButtonPanel.add(this.exitButton);
		this.downloadButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.downloadButtonPanel.setBackground(Color.WHITE);
		this.buttonsPanel.add(this.downloadButtonPanel); 
	}
		
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ViewSimulationResultPanel(1, 100, 10, (float) 0.1, (float) 0.1, (float) 0.8));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	

}