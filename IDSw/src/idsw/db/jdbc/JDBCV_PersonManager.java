package idsw.db.jdbc;

import java.sql.Connection;

import idsw.db.jdbcInterfaces.VirtualPersonManager;

public class JDBCV_PersonManager implements VirtualPersonManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCV_PersonManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();	}

}
