package idsw.db.jdbcInterfaces;

import idsw.db.pojos.*;

public interface PatientManager {
	public Patient getPatient(int patient_id);
	public void addPatient(Patient patient);
	public void modifyPatient(Patient patient);
}
