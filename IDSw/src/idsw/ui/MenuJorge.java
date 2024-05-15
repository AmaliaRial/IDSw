package idsw.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import idsw.db.jdbc.ConnectionManager;
import idsw.db.jdbcInterfaces.DiagnosisManager;
import idsw.db.jdbcInterfaces.DiseaseManager;
import idsw.db.jdbcInterfaces.SymptomManager;
import idsw.db.jdbcInterfaces.TreatmentManager;
import idsw.db.jdbcInterfaces.MedicalRecordManager;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Medical_Record;


public class MenuJorge {
	
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

	private static DiseaseManager diseaseMan;
	private static DiagnosisManager diagnosisMan;
	private static MedicalRecordManager MedicalRecordMan;
	//TODO add interfaces

	public static int menuPrincipal() throws IOException {
	
		int choice = Integer.parseInt(r.readLine());
		return choice;
	}
 	
	public static void main(String[] args) {
		
		int choice = 0;
		try {
			System.out.println("Welcome to IDSW!");
			ConnectionManager conMan = new ConnectionManager();
			//Manager setup
			diseaseMan = conMan.getDiseaseMan();
			diagnosisMan = conMan.getDiagnosisMan();
			//TODO add conMans
						
			do {
				choice = menuPrincipal();
			switch (choice) {
				case 1: {
					addDiagnosis();
					break;
				}
				case 2: {
					deleteDiagnosis();
					break;
				}
				case 3: {
					//addDiagnosis(Diagnosis diagnosis);
					break;
				}
				case 4: {
				//	modifyDiagnosis(Diagnosis diagnosis);
					break;
				}
				case 0: {
					conMan.close();
					return;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
			
			} while (choice != 17);
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	private static void addDiagnosis() throws NumberFormatException, IOException{
		System.out.println("Please write the Diagnosis info");
		System.out.println("Its name:");
		String name = r.readLine();
		System.out.println("date");
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate todaysDate = LocalDate.now();
	    Date date = (Date) Date.from(todaysDate.atStartOfDay(defaultZoneId).toInstant());;
		System.out.println("comment_section");
		String comment_section = r.readLine();
		System.out.println("idDisease:");
		Disease disease = diseaseMan.getDisease(Integer.parseInt(r.readLine()));
		System.out.println("idMedical_Record");
		Medical_Record medicalrecord = MedicalRecordMan.getMedical_Record(Integer.parseInt(r.readLine()));
		
		Diagnosis diagnosis = new Diagnosis(name, date, comment_section, medicalrecord, disease);
		diagnosisMan.addDiagnosis(diagnosis);
	}
	
	private static void deleteDiagnosis() throws NumberFormatException, IOException{
		System.out.println("These are the diagnosis in the database:");
		List<Diagnosis> diagnosis = diagnosisMan.listAllDiagnosis();
		for(Diagnosis diagnosises : diagnosis) {
			System.out.println(diagnosises);
		}
		System.out.println("Please enter the id of the diagnosis you want to delete:");
		Integer id = Integer.parseInt(r.readLine());
		diagnosisMan.deleteDiagnosis(id);
	}
	
	
	

}