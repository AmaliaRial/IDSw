package idsw.db.jdbc;

import java.sql.Connection;

import idsw.db.jdbcInterfaces.SimulationManager;

public class JDBCSimulationManager implements SimulationManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCSimulationManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	
	}

}
