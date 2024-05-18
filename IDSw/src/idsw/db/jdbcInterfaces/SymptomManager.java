package idsw.db.jdbcInterfaces;

import java.util.List;

import idsw.db.pojos.Disease;
import idsw.db.pojos.Symptom;

public interface SymptomManager {
	
	public List<Symptom> listMatchingSymptomsByName(String search);
	public List<Symptom> listSymptomsByDisease(List<Disease> diseases);
	public Symptom getSymptom( int idSymptom);
	public void deleteSymptom(int idSymptom);
	public void addSymptom(Symptom symptom);
	public void modifySymptom(Symptom symptom);
	public List<Symptom> getSymptomsByDisease(Disease disease);

}
