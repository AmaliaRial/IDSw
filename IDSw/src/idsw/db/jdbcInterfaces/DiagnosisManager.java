package idsw.db.jdbcInterfaces;

import java.util.List;

import idsw.db.pojos.Diagnosis;

public interface DiagnosisManager {
	
	public List<Diagnosis> listSixRecentDiagnosis();
	public List<Diagnosis> listAllDiagnosis();
	public Diagnosis getDiagnosis( int idDiagnosis);
	public void deleteDiagnosis(int idDiagnosis);
	public void addDiagnosis(Diagnosis diagnosis);
	public void modifyDiagnosis(Diagnosis diagnosis);

}
