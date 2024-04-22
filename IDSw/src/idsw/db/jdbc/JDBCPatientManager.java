package idsw.db.jdbc;

import java.sql.Connection;

import idsw.db.jdbcInterfaces.PatientManager;

public class JDBCPatientManager implements PatientManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCPatientManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}
}
