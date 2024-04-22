package idsw.db.jdbc;

import java.util.List;

import idsw.db.jdbcInterfaces.DiseaseManager;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Symptom;

public class JDBCDiseaseManager implements DiseaseManager {

	public JDBCDiseaseManager(ConnectionManager connectionManager) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Disease> listSixRecentDiseases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Disease> listMatchingDiseaseByName(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Symptom> listMatchingDiseaseBySymptoms(List<Symptom> symptoms) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disease getDisease(int idDisease) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDisease(Disease disease) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDisease(Disease disease) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyDisease(Disease disease) {
		// TODO Auto-generated method stub

	}

}
