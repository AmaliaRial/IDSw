package idsw.db.jdbcInterfaces;

import java.util.List;
import idsw.db.pojos.Virtual_Population;

public interface VirtualPopulationManager {
	
	public void addVirtualPopulation(Virtual_Population virtualPopulation);
	public Virtual_Population getVirtualPopulation(int idVirtual_Population);
	public void fillPopulation(Virtual_Population virtualPopulation);
	public Virtual_Population getVirtualPopulationsFromDisease(Integer disease_id);
	public List<Virtual_Population> listMatchingV_PopulationByDiseasease(Integer disease_id);

	
}
