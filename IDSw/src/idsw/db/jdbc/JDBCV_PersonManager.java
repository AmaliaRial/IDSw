package idsw.db.jdbc;

import java.sql.Connection;

import idsw.db.jdbcInterfaces.VirtualPersonManager;
import idsw.db.pojos.Virtual_Person;

public class JDBCV_PersonManager implements VirtualPersonManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCV_PersonManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();	}

	@Override
	public Virtual_Person getVirtualPerson(int idVirtual_person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addVirtualPerson(Virtual_Person virtual_person) {
		// TODO Auto-generated method stub
		
	}

}
