package idsw.db.pojos;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import java.util.Objects;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import idsw.db.jdbc.ConnectionManager;
import idsw.db.utilities.GraphUtilities;

public class Simulation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3680356655962648293L;
	private Integer idSimulation;
	private Integer totalInfections;
	private Integer totalDeaths;
	private Integer totalImmunity;
	private Integer totalPopulation;
	private byte[]  simulationGraph;
	private Virtual_Population Vpopulation;

	
	public Simulation() {
		super();
	}

	public Simulation(int total_Infections, int total_deaths, int total_FinalInmunitations, int peopleCounter,byte[] simulationGrap1, Virtual_Population Vpopulation1) {
		this.totalInfections=total_Infections;
		this.totalDeaths=total_deaths;
		this.totalImmunity= total_FinalInmunitations;
		this.totalPopulation=peopleCounter;
		this.simulationGraph= simulationGrap1;
		this.Vpopulation=Vpopulation1;
	}
	
	public Simulation(int id_simulation, int total_Infections, int total_deaths, int total_FinalInmunitations, int peopleCounter,byte[] simulationGrap1, Virtual_Population Vpopulation1) {
		this.idSimulation=id_simulation;
		this.totalInfections=total_Infections;
		this.totalDeaths=total_deaths;
		this.totalImmunity= total_FinalInmunitations;
		this.totalPopulation=peopleCounter;
		this.simulationGraph= simulationGrap1;
		this.Vpopulation=Vpopulation1;
	}


	public Integer getIdSimulation() {
		return idSimulation;
	}

	public void setIdSimulation(Integer idSimulation) {
		this.idSimulation = idSimulation;
	}

	public Integer getTotalInfections() {
		return totalInfections;
	}

	public void setTotalInfections(Integer totalInfections) {
		this.totalInfections = totalInfections;
	}

	public Integer getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(Integer totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public Integer getTotalImmunity() {
		return totalImmunity;
	}

	public void setTotalImmunity(Integer totalImmunity) {
		this.totalImmunity = totalImmunity;
	}

	public Integer getTotalPopulation() {
		return totalPopulation;
	}

	public void setTotalPopulation(Integer totalPopulation) {
		this.totalPopulation = totalPopulation;
	}

	public byte[] getSimulationGraph() {
		return simulationGraph;
	}

	public void setSimulationGraph(byte[] simulationGraph) {
		this.simulationGraph = simulationGraph;
	}

	public Virtual_Population getVirtualPopulation() {
		return Vpopulation;
	}

	public void setVirtualPopulation(Virtual_Population virtualPopulation) {
		this.Vpopulation = virtualPopulation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSimulation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Simulation other = (Simulation) obj;
		return Objects.equals(idSimulation, other.idSimulation);
	}

	@Override
	public String toString() {
		return "Simulation [idSimulation=" + idSimulation + ", totalInfections=" + totalInfections + ", totalDeaths="
				+ totalDeaths + ", totalImmunity=" + totalImmunity + ", totalPopulation=" + totalPopulation
				+ ", simulationGraph=" + simulationGraph + "]";
	}

	

	public Virtual_Population getVpopulation() {
		return this.Vpopulation;
	}

	public void setVpopulation(Virtual_Population vpopulation) {
		this.Vpopulation = vpopulation;
	}
	
	
	public static void main(String[] args) {
        // Example usage
        //List<Integer> deathCounterData = List.of(5, 20, 16, 10, 2);
        //List<Integer> peopleCounterData = List.of(300, 280, 264, 254, 252);
        GraphUtilities utilGraph= new GraphUtilities();

        //JFreeChart simulationChart = utilGraph.graphSimulation(illCounterData, deathCounterData, peopleCounterData);
        
        Disease disease= new Disease();
		disease.setIncubation_period((float) 35);
		disease.setDevelopment_period((float) 12);
		disease.setConvalescence_period((float) 21);
		disease.setNameDisease("Mononucleosis");
		
		JFreeChart developmentChart=utilGraph.graphDiseaseDevelopment(disease);
      
        JFrame frame = new JFrame("Combined Line Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChartPanel chartPanel = new ChartPanel(developmentChart);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

}