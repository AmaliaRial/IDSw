package idsw.db.jdbc;

import java.sql.Connection;
import java.util.List;

import idsw.db.jdbcInterfaces.DiagnosisManager;
import idsw.db.pojos.Diagnosis;

public class JDBCDiagnosisManager implements DiagnosisManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCDiagnosisManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public List<Diagnosis> listSixRecentDiagnosis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diagnosis> listAllDiagnosis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diagnosis getDiagnosis(int idDiagnosis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDiagnosis(Diagnosis diagnosis) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDiagnosis(Diagnosis diagnosis) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyDiagnosis(Diagnosis diagnosis) {
		// TODO Auto-generated method stub

	}

}
