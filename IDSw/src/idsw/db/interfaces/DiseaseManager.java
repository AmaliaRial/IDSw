package idsw.db.interfaces;

import java.util.List;

import idsw.db.pojos.Disease;
import idsw.db.pojos.Symptom;

public interface DiseaseManager {

	public List<Disease> listSixRecentDiseases();
	public List<Disease> listMatchingDiseaseByName(String search);
	public List<Symptom> listMatchingDiseaseBySymptoms(List<Symptom> symptoms);
	public Disease getDisease( int idDisease);
	public void deleteDisease(Disease disease);
	public void addDisease(Disease disease);
	public void modifyDisease(Disease disease);

}
