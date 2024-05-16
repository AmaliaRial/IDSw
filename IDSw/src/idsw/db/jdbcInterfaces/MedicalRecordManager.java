package idsw.db.jdbcInterfaces;

import java.util.List;

import idsw.db.pojos.Medical_Record;
import idsw.db.pojos.Patient;

public interface MedicalRecordManager {
	
	public Medical_Record getMedical_Record ( int idMedical_record);
	public void addMedicalRecord(Patient patient);
	public void modifyMedical_Record ( int idMedical_record);
	public List<Medical_Record> listMedicalRecords();


}
