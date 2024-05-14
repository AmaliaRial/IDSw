package idsw.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import idsw.db.enums.Cause;
import idsw.db.enums.Pain_Management;
import idsw.db.jdbc.*;
import idsw.db.jdbcInterfaces.DiseaseManager;
import idsw.db.jdbcInterfaces.PatientManager;
import idsw.db.jdbcInterfaces.SymptomManager;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Patient;
import idsw.db.pojos.Symptom;
import idsw.db.pojos.Treatment;

public class menuLorena {
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private static ConnectionManager conMan;
	private static SymptomManager symptomMan;
	private static PatientManager patientMan; 
	private static DiseaseManager diseaseMan;
	
	public static int menuP() throws NumberFormatException, IOException {
		System.out.println("1. Add a patient");
		System.out.println("2. Modify a patient");
		System.out.println("3. List matching symptoms by name");
		System.out.println("4. List symptom by disease");
		System.out.println("5. Add symptom");
		System.out.println("6. Modify symptom");
		System.out.println("7. Delete symptom");
		System.out.println("0. Exit");
		System.out.print("Choose your desired option: ");
		int choice = Integer.parseInt(r.readLine());
		return choice;
	}
	
	public static void main(String arg[]) {
		int choice = 0;
		try {
			System.out.println("Welcome to IDSW!");
			conMan = new ConnectionManager();
			patientMan = conMan.getPatientMan();
			symptomMan = conMan.getSymptomMan();
			diseaseMan = conMan.getDiseaseMan();
			
			do {
				choice = menuP();
			switch (choice) {
				case 1: {
					addPatient();
					break;
				}
				case 2: {
					modifyPatient();
					break;
				}
				case 3: {
					ListMatchingSymptomsByName();
					
					break;
				}
				case 4: {
					searchSymptomsByDisease();
					break;
				}
				case 5: {
					addSymptom();
					break;
				}
				case 6: {
					modifySymptom();
					break;
				}
				case 7: {
					deleteSymptom();
					break;
				}
				case 8: {
					
					break;
				}
				case 0: {
					conMan.close();
					return;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
			
			} while (choice != 20);
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
}

private static void addPatient() throws NumberFormatException, IOException{
	System.out.println("Please write the Patient info");
	System.out.println("Its name:");
	String name = r.readLine();
	System.out.println("Its surname:");
	String surname = r.readLine();
	System.out.println("Day of birth (DD-MM-YYYY format):");
	LocalDate localDate = LocalDate.parse(r.readLine(), formatter);
	Date dob = Date.valueOf(localDate);
	
	Patient patient = new Patient(name, surname, dob);
	patientMan.addPatient(patient);
}

private static void addSymptom() throws NumberFormatException, IOException{
	System.out.println("Please write the symptom info");
	System.out.println("Its name:");
	String name = r.readLine();
	System.out.println("Its pain management:");
	String pain_Management =  r.readLine(); 
	
	Symptom symptom = new Symptom(name, pain_Management);
	symptomMan.addSymptom(symptom);
}


private static void modifyPatient() throws NumberFormatException, IOException{
		Patient patient = new Patient();
		System.out.println("");
		System.out.println("Here are the actual Patient's values");
		System.out.println("Press enter to keep them or type a new value.");
		System.out.println("Name (" + patient.getNamePatient() + "): ");
		String newName = r.readLine();
		System.out.println("Surname (" + patient.getSurname() + "): ");
		String newSurname = r.readLine();
		if (!newName.equals("")) {
			// If I don't keep
			patient.setNamePatient(newName);
		}
		if (newSurname.equals("")) { // If I keep
		}
		else { // If I don't keep
			patient.setSurname(newSurname);
		}
		
		patientMan.modifyPatient(patient);
	}

private static void modifySymptom() throws NumberFormatException, IOException{
	System.out.println("\n These are the symptoms in the database:");
	List <Symptom> symptoms = symptomMan.listMatchingSymptomsByName("");
	for (Symptom symptom : symptoms) {
		System.out.println(symptom);
	}
	System.out.println("\nPlease enter the ID of the symptom you wish to modify:");
	Integer id = Integer.parseInt(r.readLine());
	Symptom symptom = symptomMan.getSymptom(id);
	
	System.out.println("Here are the actual Symptoms values");
	System.out.println("Press enter to keep them or type a new value.");
	System.out.println("Name (" + symptom.getNameSymptom() + "): ");
	String newName = r.readLine();
	System.out.println("Pain management (" + symptom.getPain_management().name() + "): ");
	String pain_Management = r.readLine();
	if (!newName.equals("")) {
		// If I don't keep
		symptom.setNameSymptom(newName);
	}
	if (!pain_Management.equals("")) { 
		Pain_Management newPain_management = Pain_Management.valueOf(pain_Management);	
		symptom.setPain_management(newPain_management);
	}
	
	symptomMan.modifySymptom(symptom);
}



private static void deleteSymptom() throws NumberFormatException, IOException{
	System.out.println("These are the symptoms in the database:");
	List<Symptom> symptoms = symptomMan.listMatchingSymptomsByName("");
	System.out.println(symptoms);
	System.out.println("Please enter the id of the Symptom you want to delete:");
	Integer id = Integer.parseInt(r.readLine());
	
	symptomMan.deleteSymptom(id);
}

private static void ListMatchingSymptomsByName() throws NumberFormatException, IOException {
	System.out.println("Please, type the symptom´s name:");
	String name = r.readLine();
	List<Symptom> symptoms = symptomMan.listMatchingSymptomsByName(name);
	for (Symptom symptom : symptoms) {
		System.out.println(symptom);
	}
}


private static void searchSymptomsByDisease() throws IOException{
	System.out.println("These are the diseases in the database, please enter the IDs of the disease you wish to search, press enter to finish: ");
    List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
    for (Disease disease : diseases) {
        System.out.println(disease);
    }
    List<Integer> diseaseIds = new ArrayList<>();
    String lineread;
    while (!(lineread = r.readLine()).equals("")) {
        diseaseIds.add(Integer.parseInt(lineread));
    }

    List<Disease> selectedDiseases = new ArrayList<>();
    for (Integer id : diseaseIds) {
        Disease disease = diseaseMan.getDisease(id);
        if (disease != null) {
            selectedDiseases.add(disease);
        } else {
            System.out.println("Disease with ID " + id + " not found.");
        }
    }

    List<Symptom> symptoms = symptomMan.listSymptomsByDisease(selectedDiseases);
    for (Symptom symptom : symptoms) {
        System.out.println(symptom);
    }
	

}

private static void addDisease() throws NumberFormatException, IOException{
	System.out.println("Please write the Disease info");
	System.out.println("Its name:");
	String name = r.readLine();
	System.out.println("Infectious Rate:");
	Float infectRate = Float.parseFloat(r.readLine());
	System.out.println("Mortality Rate:");
	Float mortRate = Float.parseFloat(r.readLine());
	System.out.println("Incubation Period:");
	Float incubPeriod = Float.parseFloat(r.readLine());
	System.out.println("Development Period:");
	Float devPeriod = Float.parseFloat(r.readLine());
	System.out.println("Convalescense Period:");
	Float convPeriod = Float.parseFloat(r.readLine());
	System.out.println("Cause:");
	String cause = r.readLine();
	System.out.println("Comment Section:");
	String commentSec = r.readLine();
	
	Disease disease = new Disease(name, infectRate, mortRate, incubPeriod, devPeriod, convPeriod, cause, commentSec);
	diseaseMan.addDisease(disease);
}
}
