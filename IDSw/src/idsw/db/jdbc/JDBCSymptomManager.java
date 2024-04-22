package idsw.db.jdbc;

import java.util.List;

import idsw.db.jdbcInterfaces.SymptomManager;
import idsw.db.pojos.Symptom;

public class JDBCSymptomManager implements SymptomManager {

	@Override
	public List<Symptom> listMatchingSymptomsByName(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symptom getSymptom(int idSymptom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSymptom(Symptom symptom) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSymptom(Symptom symptom) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifySymptom(Symptom symptom) {
		// TODO Auto-generated method stub

	}

}
