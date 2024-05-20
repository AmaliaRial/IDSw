package idsw.db.graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;

import idsw.db.graphicInterface.components.RoundedButton;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.jpa.JPAUserManager;
import idsw.db.pojos.Simulation;
import idsw.db.pojos.Treatment;

public class HomePanelResearcher extends HomePanel implements ActionListener{
	public List<Simulation> sixSimulations;
	public ConnectionManager conMan;
	public RoundedButton treatmentButton;
	public RoundedButton symptomButton;
	public RoundedButton simulationButton;
	public JPAUserManager jpaConMan;
	public GraphicAplication app;
	
	public HomePanelResearcher(JPAUserManager jpaConMan, GraphicAplication app, ConnectionManager conMan) {
		super();
		this.jpaConMan=jpaConMan;
		this.app=app;
		this.conMan=conMan;
		this.conMan=new ConnectionManager();
		this.sixSimulations= this.conMan.getSimulationMan().listSixRecentSimulation();
		super.b1.setButtonText("Recent Simulation: "+sixSimulations.get(0).getVirtualPopulation().getDisease().getNameDisease());
		super.b2.setButtonText("Recent Simulation: "+sixSimulations.get(1).getVirtualPopulation().getDisease().getNameDisease());
		super.b3.setButtonText("Recent Simulation: "+sixSimulations.get(0).getVirtualPopulation().getDisease().getNameDisease());
		super.b4.setButtonText("Recent Simulation: "+sixSimulations.get(0).getVirtualPopulation().getDisease().getNameDisease());
		super.b5.setButtonText("Recent Simulation: "+sixSimulations.get(0).getVirtualPopulation().getDisease().getNameDisease());
		super.b6.setButtonText("Recent Simulation: "+sixSimulations.get(0).getVirtualPopulation().getDisease().getNameDisease());
		
	
		
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
        //frame.getContentPane().add(new  HomePanelResearcher());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Integer id_simulation;
		if(e.getSource()==super.userButton) {
			this.app.fromHomePanelDoctorToLogOutPanel();
		}else if(e.getSource()==super.searchButton) {
			this.app.fromHomePanelDoctorToSearchPatientPanel();
		}else if(e.getSource()==super.b1) {
			id_simulation=this.sixSimulations.get(0).getIdSimulation();
			this.app.fromHomePanelResearcherToViewSimulationResultPanel(id_simulation);
		}else if(e.getSource()==super.b2) {
			id_simulation=this.sixSimulations.get(1).getIdSimulation();
			this.app.fromHomePanelResearcherToViewSimulationResultPanel(id_simulation);
		}else if(e.getSource()==super.b3) {
			id_simulation=this.sixSimulations.get(2).getIdSimulation();
			this.app.fromHomePanelResearcherToViewSimulationResultPanel(id_simulation);
		}else if(e.getSource()==super.b4) {
			id_simulation=this.sixSimulations.get(3).getIdSimulation();
			this.app.fromHomePanelResearcherToViewSimulationResultPanel(id_simulation);
		}else if(e.getSource()==super.b5) {
			id_simulation=this.sixSimulations.get(4).getIdSimulation();
			this.app.fromHomePanelResearcherToViewSimulationResultPanel(id_simulation);
		}else if(e.getSource()==super.b6) {
			id_simulation=this.sixSimulations.get(5).getIdSimulation();
			this.app.fromHomePanelResearcherToViewSimulationResultPanel(id_simulation);
		}else if(e.getSource()==this.simulationButton) {
			this.app.fromHomePanelResearcherToCreateSearchSimulationOptionPanel();
		}else if(e.getSource()==this.symptomButton) {
			this.app.fromHomePanelResearcherToResearcherSymptomSearchPanel();
		}else if(e.getSource()==this.treatmentButton) {
			this.app.fromHomePanelResearcherToResearcherTreatmentSearchPanel();
		}
	}


}
