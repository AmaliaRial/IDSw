package idsw.db.jdbc;

import java.sql.Connection;

import idsw.db.jdbcInterfaces.VirtualPopulationManager;

public class JDBCV_PopulationManager implements VirtualPopulationManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCV_PopulationManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
		
	}

}
