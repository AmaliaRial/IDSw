package idsw.db.jdbc;

import java.util.List;

import idsw.db.jdbcInterfaces.TreatmentManager;
import idsw.db.pojos.Treatment;

public class JDBCTreatmentManager implements TreatmentManager {

	@Override
	public List<Treatment> listSixRecentTreatment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Treatment> listMatchingTreatmentsByName(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Treatment getTreatment(int idTreatment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTreatment(Treatment treatment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTreatment(Treatment treatment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyTreatment(Treatment treatment) {
		// TODO Auto-generated method stub

	}

}
