package idsw.db.jdbcInterfaces;

import java.util.List;

import idsw.db.pojos.Symptom;

public interface SymptomManager {
	
	public List<Symptom> listMatchingSymptomsByName(String search);
	public List<Symptom> listSymptomsByDisease(int disease_id);
	public Symptom getSymptom( int idSymptom);
	public void deleteSymptom(Symptom symptom);
	public void addSymptom(Symptom symptom);
	public void modifySymptom(Symptom symptom);


}
