package idsw.db.interfaces;

import idsw.db.pojos.Medical_Record;

public interface MedicalRecordManager {
	
	public Medical_Record getMedical_Record ( int idMedical_record);
	public void addMedicalReport(Medical_Record medicalRecord);
	public void modifyMedical_Record ( int idMedical_record);


}
