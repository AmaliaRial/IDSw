package idsw.db.jdbcInterfaces;

import java.util.List;

import idsw.db.pojos.Disease;
import idsw.db.pojos.Symptom;

public interface DiseaseManager {

	public List<Disease> listSixRecentDiseases(); //in SQL: SELECT * FROM disease ORDER BY idDisease DESC LIMIT 6;
	public List<Disease> listMatchingDiseaseByName(String name);
	public List<Disease> listMatchingDiseaseBySymptoms(List<Symptom> symptoms);
	public Disease getDisease( int idDisease);
	public void deleteDisease(int IDdisease);
	public void addDisease(Disease disease);
	public void modifyDisease(Disease disease);
	public void addSymptomByDisease(Disease disease, Symptom symptom);
	public Disease getMostMatchingDiseaseBySymptoms(List<Symptom> symptoms);

}
