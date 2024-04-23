package idsw.db.jdbcInterfaces;

import idsw.db.pojos.Virtual_Population;

public interface VirtualPopulationManager {
	
	public void addVirtualPopulation(Virtual_Population virtualPopulation);
	public Virtual_Population getVirtualPopulation(int idVirtual_Population);


}
