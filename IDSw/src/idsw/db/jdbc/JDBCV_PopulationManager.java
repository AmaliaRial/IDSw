package idsw.db.jdbc;

import java.sql.Connection;

import idsw.db.jdbcInterfaces.VirtualPopulationManager;
import idsw.db.pojos.Virtual_Population;

public class JDBCV_PopulationManager implements VirtualPopulationManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCV_PopulationManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
		
	}

	@Override
	public void addVirtualPopulation(Virtual_Population virtualPopulation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Virtual_Population getVirtualPopulation(int idVirtual_Population) {
		// TODO Auto-generated method stub
		return null;
	}

}
