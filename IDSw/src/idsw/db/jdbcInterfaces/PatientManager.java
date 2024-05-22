package idsw.db.jdbcInterfaces;

import java.util.List;

import idsw.db.pojos.*;

public interface PatientManager {
	public Patient getPatientByName(String name);
	public Patient getPatient(int patient_id);
	public void addPatient(Patient patient);
	public void modifyPatient(Patient patient);
	public List<Patient> listMatchingPatientByName(String search);
}
