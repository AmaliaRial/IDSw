package idsw.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import idsw.db.enums.*;
import idsw.db.jdbc.*;
import idsw.db.jdbcInterfaces.*;
import idsw.db.pojos.*;
import idsw.db.jpa.*;
import idsw.db.jpaInterfaces.UserManager;

public class menuLorena {
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private static ConnectionManager conMan;
	private static SymptomManager symptomMan;
	private static PatientManager patientMan; 
	private static DiseaseManager diseaseMan;
	private static MedicalRecordManager medicalRecordMan;
	private static UserManager userMan;
	
	
	public static void main(String arg[])  throws NumberFormatException, IOException{
		System.out.println("Welcome to IDSW!");
		
		conMan = new ConnectionManager();
		patientMan = conMan.getPatientMan();
		symptomMan = conMan.getSymptomMan();
		diseaseMan = conMan.getDiseaseMan();
		medicalRecordMan = conMan.getMedicalRecordMan();
		userMan = new JPAUserManager();
		
		System.out.println("Choose your desired option");
		System.out.println("1. Login");
		System.out.println("2. Register");
		int choice = Integer.parseInt(r.readLine());
		switch (choice) {
			case 1: {
				menuLogin();
				break;
				}
			
			case 2: {
				menuRegister();
                break;
                }
			
			case 0: {
				conMan.close();
				return;
			}
			}
		}


private static void menuLogin() throws NumberFormatException, IOException {
	System.out.println("Please, type your username:");
	String username = r.readLine();
	System.out.println("Please, type your password:");
	String password = r.readLine();
	User user = userMan.login(username, password);
	if (user != null) {
		System.out.println("Welcome " + user.getName());
	} else {
		System.out.println("Invalid username or password");
	}
}
		
private static void menuRegister() throws NumberFormatException, IOException {
	System.out.println("Please, type your name:");
	String name = r.readLine();
	System.out.println("Please, type your surname:");
	String surname = r.readLine();
	System.out.println("Please, type a username:");
	String username = r.readLine();
	System.out.println("Please, type a password:");
	String password = r.readLine();
	System.out.println("Please, type your date of birth (dd-mm-yyyy):");
	LocalDate localDate = LocalDate.parse(r.readLine(), formatter);
	Date dob = Date.valueOf(localDate);
	System.out.println("Please, type your sex (MALE/FEMALE):");
	String sex =  r.readLine();
	System.out.println("Please, type your email: ");
	String email = r.readLine();
	System.out.println("Please, type your phone number: ");
	Integer phone = Integer.parseInt(r.readLine());
	System.out.println("Please, type your DNI (without letter): ");
	String dni = r.readLine();
	System.out.println("Please, type the roleID:");
	Long roleID =  Long.parseLong(r.readLine());
	System.out.println("Choose your role (type its name):");
	List<Role> roles = userMan.getAllRoles();
	System.out.println(roles);
	String roleName = r.readLine();
	Role role = userMan.getRole(roleName);
	
	User u = new User(dni,dob,email,name, password, roleID, phone, sex, surname, username, role);
	userMan.register(u);
	if (roleName.equals("patient")) {
		Patient patient = new Patient(name, surname, username, dob);
		patientMan.addPatient(patient);
	}
}

private static void getUser() throws NumberFormatException, IOException {
	System.out.println("Please, type your username:");
	String username = r.readLine();
	User user = userMan.getUser(username);
	if (user != null) {
		System.out.println(user);
	} else {
		System.out.println("User not found");
	}
}


private static void addPatient() throws NumberFormatException, IOException{
	System.out.println("Please write the Patient info");
	System.out.println("Its name:");
	String name = r.readLine();
	System.out.println("Its surname:");
	String surname = r.readLine();
	System.out.println("Its username:");
	String username = r.readLine();
	System.out.println("Day of birth (DD-MM-YYYY format):");
	LocalDate localDate = LocalDate.parse(r.readLine(), formatter);
	Date dob = Date.valueOf(localDate);
	
	Patient patient = new Patient(name, surname,username, dob);
	patientMan.addPatient(patient);
	Integer lastId = conMan.getLastInsertedID();
	patient.setIdPatient(lastId);
	createMedicalRecord(patient);
}


private static void createMedicalRecord(Patient patient) {
	medicalRecordMan.addMedicalRecord(patient);
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
	System.out.println("\nThese are the patients in the database:");
	List <Patient> patients = patientMan.listMatchingPatientByName("");
	for (Patient patient : patients) {
		System.out.println(patient);
	}
	System.out.println("\nPlease enter the ID of the patient you wish to modify:");
	Integer id = Integer.parseInt(r.readLine());
	Patient patient = patientMan.getPatient(id);
	
	System.out.println("Here are the actual patients values");
	System.out.println("Press enter to keep them or type a new value.");
	System.out.println("Name (" + patient.getNamePatient() + "): ");
	String newName = r.readLine();
	System.out.println("Surname (" + patient.getSurname() + "): ");
	String newSurname = r.readLine();
	System.out.println("Date of birth (" + patient.getDob() + "): ");
	String newDate = r.readLine();
	if (!newName.equals("")) {
		// If I don't keep
		patient.setNamePatient(newName);
	}
	if (!newSurname.equals("")) {
		patient.setSurname(newSurname);
	}
	if (!newDate.equals("")) {
		LocalDate localDate = LocalDate.parse(newDate, formatter);
		Date dob = Date.valueOf(localDate);
		patient.setDob(dob);
	}
	
	patientMan.modifyPatient(patient);
	}

private static void modifySymptom() throws NumberFormatException, IOException{
	System.out.println("\nThese are the symptoms in the database:");
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

private static void listPatientsByName() throws NumberFormatException, IOException {
	System.out.println("Please, type the patient´s name:");
	String name = r.readLine();
	List<Patient> patients = patientMan.listMatchingPatientByName(name);
	for (Patient patient : patients) {
		System.out.println(patient);
	}
}
}
