package idsw.db.interfaces;

import java.util.List;

import idsw.db.pojos.Treatment;

public interface TreatmentManager {
	
	public List<Treatment> listSixRecentTreatment();
	public List<Treatment> listMatchingTreatmentsByName(String search);
	public Treatment getTreatment( int idTreatment);
	public void deleteTreatment(Treatment treatment);
	public void addTreatment(Treatment treatment);
	public void modifyTreatment(Treatment treatment);

}
