package idsw.db.jdbc;

import java.sql.Connection;

import idsw.db.jdbcInterfaces.MedicalRecordManager;
import idsw.db.pojos.Medical_Record;

public class JDBCM_RecordManager implements MedicalRecordManager {
	
	private Connection c;
	private ConnectionManager conMan;
	
	public JDBCM_RecordManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public Medical_Record getMedical_Record(int idMedical_record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMedicalReport(Medical_Record medicalRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyMedical_Record(int idMedical_record) {
		// TODO Auto-generated method stub

	}

}
