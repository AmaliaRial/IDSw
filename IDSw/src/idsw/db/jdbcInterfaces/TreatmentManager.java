package idsw.db.jdbcInterfaces;

import java.util.List;

import idsw.db.pojos.Treatment;

public interface TreatmentManager {
	
	public List<Treatment> listSixRecentTreatment();
	public List<Treatment> listMatchingTreatmentsByName(String search);
	public Treatment getTreatment( int idTreatment);
	public void deleteTreatment(int id_treatment);
	public void addTreatment(Treatment treatment);
	public void modifyTreatment(Treatment treatment);
	public List <Treatment> listTreatmentsByDisease();
	public List<Treatment> listTreatmentByDiagnosis();
}
