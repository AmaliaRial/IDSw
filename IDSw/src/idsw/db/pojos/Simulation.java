package idsw.db.pojos;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Objects;

public class Simulation implements Serializable{
	
	private Integer idSimulation;
	private Integer totalInfections;
	private Integer totalDeaths;
	private Integer totalImmunity;
	private Integer totalPopulation;
	private Blob simulationGraph;
	private Virtual_Population virtualPopulation;
	
	public Simulation() {
		super();
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

	public Blob getSimulationGraph() {
		return simulationGraph;
	}

	public void setSimulationGraph(Blob simulationGraph) {
		this.simulationGraph = simulationGraph;
	}

	public Virtual_Population getVirtualPopulation() {
		return virtualPopulation;
	}

	public void setVirtualPopulation(Virtual_Population virtualPopulation) {
		this.virtualPopulation = virtualPopulation;
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
}