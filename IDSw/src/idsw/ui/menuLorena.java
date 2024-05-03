package idsw.ui;

import java.sql.Date;

import idsw.db.jdbc.*;
import idsw.db.jdbcInterfaces.PatientManager;
import idsw.db.pojos.Patient;

public class menuLorena {
	
	private static PatientManager patientMan; 
	public static void main(String arg[]) {
		Date date = new Date(104,10,29);
		Patient patient = new Patient();
		patient.setNamePatient("Lorena");
		patient.setSurname("Cano");
		patient.setDob(date);
		ConnectionManager conMan = new ConnectionManager();
		
		patientMan = conMan.getPatientMan();
		patientMan.addPatient(patient);
	
	}

}
