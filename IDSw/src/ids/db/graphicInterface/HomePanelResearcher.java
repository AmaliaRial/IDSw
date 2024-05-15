package ids.db.graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

import ids.db.graphicInterface.components.RoundedButton;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.pojos.Simulation;
import idsw.db.pojos.Treatment;

public class HomePanelResearcher extends HomePanel {
	public List<Simulation> sixSimulations;
	public ConnectionManager conMan;
	public RoundedButton treatmentButton;
	public RoundedButton symptomButton;
	public RoundedButton simulationButton;
	
	public HomePanelResearcher() {
		super();
		this.conMan=new ConnectionManager();
		/*this.sixSimulations= this.conMan.getSimulationMan().listSixRecentSimulation();
		super.b1.setButtonText("Recent Simulation: "+sixSimulations.get(0).getVirtualPopulation().getDisease().getNameDisease());
		super.b2.setButtonText("Recent Simulation: "+sixSimulations.get(1).getVirtualPopulation().getDisease().getNameDisease());
		super.b3.setButtonText("Recent Simulation: "+sixSimulations.get(0).getVirtualPopulation().getDisease().getNameDisease());
		super.b4.setButtonText("Recent Simulation: "+sixSimulations.get(0).getVirtualPopulation().getDisease().getNameDisease());
		super.b5.setButtonText("Recent Simulation: "+sixSimulations.get(0).getVirtualPopulation().getDisease().getNameDisease());
		super.b6.setButtonText("Recent Simulation: "+sixSimulations.get(0).getVirtualPopulation().getDisease().getNameDisease());
		*/
	
		
		this.treatmentButton=new RoundedButton("TREATMENTS", Color.decode("#09A8E4"));
		this.treatmentButton.setPreferredSize(new Dimension(100, 30));
		super.buttonPanel.add(treatmentButton);
		
		this.symptomButton=new RoundedButton("SYMPTOMS", Color.decode("#09A8E4"));
		this.symptomButton.setPreferredSize(new Dimension(90, 30));
		super.buttonPanel.add(symptomButton);
		
		this.simulationButton=new RoundedButton("SIMULATIONS", Color.decode("#09A8E4"));
		this.simulationButton.setPreferredSize(new Dimension(100, 30));
		super.buttonPanel.add(simulationButton);
		

	}
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana de prueba
        JFrame frame = new JFrame("Ejemplo de BorderLayout con Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new  HomePanelResearcher());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
