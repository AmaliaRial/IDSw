package idsw.db.jdbcInterfaces;

import java.util.List;

import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Patient;
import idsw.db.pojos.Symptom;

public interface DiagnosisManager {
	
	public List<Diagnosis> listSixRecentDiagnosis();
	public List<Diagnosis> listAllDiagnosis();
	public List<Diagnosis> listMatchinDiagnosesByPatient(Patient patient);
	public Diagnosis getDiagnosis( int idDiagnosis);
	public void deleteDiagnosis(int idDiagnosis);
	public void addDiagnosis(Diagnosis diagnosis);
	public void modifyDiagnosis(Diagnosis diagnosis);

}
