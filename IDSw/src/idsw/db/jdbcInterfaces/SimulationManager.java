package idsw.db.jdbcInterfaces;

import java.util.List;

import idsw.db.pojos.Simulation;
import idsw.db.pojos.Virtual_Population;

public interface SimulationManager {
	
	public void addSimulation(Virtual_Population virtualPopulation);
	public Simulation selectSimulation(Integer simulation_id);
	public List<Simulation> listMatchingSimulationByV_Population(Integer disease_id);
	public Simulation createSimulation(Virtual_Population virtualPopulation);
}
