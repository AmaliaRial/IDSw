package idsw.db.jdbcInterfaces;

import java.util.List;

import idsw.db.pojos.Diagnosis;

public interface DiagnosisManager {
	
	public List<Diagnosis> listSixRecentDiagnosis(Integer id_patient);
	public List<Diagnosis> listAllDiagnosis();
	public List<Diagnosis> listMatchinDiagnosesByPatient(Integer idPatient);
	public Diagnosis getDiagnosis( int idDiagnosis);
	public void deleteDiagnosis(int idDiagnosis);
	public void addDiagnosis(Diagnosis diagnosis);
	public void modifyDiagnosis(Diagnosis diagnosis);
}
