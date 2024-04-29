package idsw.db.pojos;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import java.util.Objects;

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

	//public byte[] getSimulationGraph() {
	//	return simulationGraph;
	//}

	//public void setSimulationGraph(byte[] simulationGraph) {
	//	this.simulationGraph = simulationGraph;
	//}

	//public Virtual_Population getVirtualPopulation() {
	//	return virtualPopulation;
	//}

	//public void setVirtualPopulation(Virtual_Population virtualPopulation) {
	//	this.virtualPopulation = virtualPopulation;
	//}

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

}