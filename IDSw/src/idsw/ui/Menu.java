package idsw.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.exceptions.IntegrityChecker;

import idsw.db.enums.Cause;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.jdbcInterfaces.DiagnosisManager;
import idsw.db.jdbcInterfaces.DiseaseManager;
import idsw.db.jdbcInterfaces.MedicalRecordManager;
import idsw.db.jdbcInterfaces.PatientManager;
import idsw.db.jdbcInterfaces.SymptomManager;
import idsw.db.jdbcInterfaces.TreatmentManager;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Medical_Record;
import idsw.db.pojos.Patient;
import idsw.db.pojos.Symptom;
import idsw.db.pojos.Treatment;

public class Menu {

	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private static ConnectionManager conMan;
	private static DiseaseManager diseaseMan;
	private static TreatmentManager treatmentMan;
	private static SymptomManager symptomMan;
	private static DiagnosisManager diagnosisMan;
	private static PatientManager patientMan;
	private static MedicalRecordManager medicalRecordMan;

	/**
	 * Main menu
	 * 
	 * @return choice
	 * @throws IOException
	 */
	public static int menuPrincipal() throws IOException {
		System.out.println("\n Choose your desired option");
		System.out.println("1. Add a new disease");
		System.out.println("2. Search a disease by its name");
		System.out.println("3. Add a new treatment");
		System.out.println("4. List 6 recent treatments");
		System.out.println("5. Modify a treatment");
		System.out.println("6. Delete a treatement");
		System.out.println("7. Search treatment by name");
		System.out.println("8. Search treatment by disease");
		System.out.println("9. Search treatment by diagnosis");
		System.out.println("10. Modify a disease");
		System.out.println("11. Delete a disease");
		System.out.println("12. Add symptom.");
		System.out.println("13. Search disease by symptom.");
		System.out.println("14. Add Treatment by Diagnosis.");
		System.out.println("15. Add Diagnosis.");
		System.out.println("16. List 6 recent diseases.");
		System.out.println("17. Add a new patient.");
		System.out.println("18. Add treatments to a disease.");
		System.out.println("0. Exit");
		int choice = Integer.parseInt(r.readLine());
		return choice;
	}
 	
	public static void main(String[] args) {
		
		int choice = 0;
		try {
			System.out.println("Welcome to IDSW!");
			conMan = new ConnectionManager();
			//Manager setup
			diseaseMan = conMan.getDiseaseMan();
			treatmentMan = conMan.getTreatmentMan();
			symptomMan = conMan.getSymptomMan();
			diagnosisMan = conMan.getDiagnosisMan();
			patientMan = conMan.getPatientMan();
			medicalRecordMan = conMan.getMedicalRecordMan();
									
			do {
				choice = menuPrincipal();
			switch (choice) {
				case 1: {
					addDisease();
					break;
				}
				case 2: {
					searchDiseaseByName();
					break;
				}
				case 3: {
					addTreatment();
					break;
				}
				case 4: {
					list6treatments();
					break;
				}
				case 5: {
					modifyTreatment();
					break;
				}
				case 6: {
					deleteTreatment();
					break;
				}
				case 7: {
					searchTreatmentByName();
					break;
				}
				case 8:{
					searchTreatmentByDisease();
					break;
				}
				case 9:{
					searchTreatmentByDiagnosis();		
					break;
				}
				case 10:{
					updateDisease();
					break;
				}
				case 11:{
					deleteDisease();
					break;
				}
				case 12:{
					addSymptom();
					break;
				}
				case 13:{
					searchDiseaseBySymptom();					
					break;
				}
				case 14:{
					newTreatmentByDiagnosis();
					break;
				}
				case 15:{
					addDiagnosis();
					break;
				}
				case 16: {
					list6diseases();
					break;
				}
				case 17: {
					addPatient();
					break;
				}
				case 18: {
					addTreatmentsToaDisease();
					break;
				}
				case 19: {
					//
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
	
	/**
	 * Method to add a new disease
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
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
		Integer lastId = conMan.getLastInsertedID();
		disease.setIdDisease(lastId);
		
		System.out.println("\n Would you like to add treatments to this disease? Please answer with a Yes or a NO :");
		String answer = r.readLine();
		if (answer.equalsIgnoreCase("Yes")) {
			newTreatmentByDisease(disease);
		} else {
		}
		System.out.println("\n Would you like to add symptoms to this disease? Please answer with a Yes or a NO :");
		String answer2 = r.readLine();
		if (answer2.equalsIgnoreCase("Yes")) {
			newSymptomByDisease(disease);
		} else {
		}
		
	}
	
	/**
	 * Method to search a disease by its name
	 * 
	 * @throws IOException
	 */
	private static void searchDiseaseByName() throws IOException{
		System.out.println("Please, enter the name of the Disease:");
		String name = r.readLine();
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName(name);
		for (Disease disease : diseases) {
			System.out.println(disease);
		}
	}
	
	/**
	 * Method to search a disease by its symptoms
	 * 
	 * @throws IOException
	 */
	private static void searchDiseaseBySymptom() throws IOException{
	    System.out.println("These are the symptoms in the database, please enter the IDs of the symptoms you wish to search, press enter to finish: ");
	    List<Symptom> symptoms = symptomMan.listMatchingSymptomsByName("");
	    for (Symptom symptom : symptoms) {
	        System.out.println(symptom);
	    }
	    List<Integer> symptomIds = new ArrayList<>();
	    String lineread;
	    while (!(lineread = r.readLine()).equals("")) {
	        symptomIds.add(Integer.parseInt(lineread));
	    }

	    List<Symptom> selectedSymptoms = new ArrayList<>();
	    for (Integer id : symptomIds) {
	        Symptom symptom = symptomMan.getSymptom(id);
	        if (symptom != null) {
	            selectedSymptoms.add(symptom);
	        } else {
	            System.out.println("Symptom with ID " + id + " not found.");
	        }
	    }

	    List<Disease> diseases = diseaseMan.listMatchingDiseaseBySymptoms(selectedSymptoms);
	    for (Disease disease : diseases) {
	        System.out.println(disease);
	    }
	}
	
	/**
	 * Method to add a new diagnosis
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void addDiagnosis() throws NumberFormatException, IOException{
		System.out.println("Please write the Diagnosis info");
		System.out.println("Its name:");
		String name = r.readLine();
		System.out.println("Date (dd-mm-yyyy):");
		LocalDate localDate = LocalDate.parse(r.readLine(), formatter);
		Date todaysDate = Date.valueOf(localDate);
		System.out.println("\nThese are the the diseases in the database:");
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
		for (Disease disease : diseases) {
			System.out.println(disease);
		}
		System.out.println("\n Please enter the ID of the disease:");
		Integer idDisease = Integer.parseInt(r.readLine());
		Disease disease = diseaseMan.getDisease(idDisease);
		System.out.println("\nThese are the the medical records in the database:");
		List<Medical_Record> medical_Records = medicalRecordMan.listMedicalRecords();
		for (Medical_Record medicalR : medical_Records) {
			System.out.println(medicalR + " " + medicalR.getPatient().getNamePatient() + " " + medicalR.getPatient().getSurname() + " " + medicalR.getPatient().getDob());
		}
		System.out.println("Please select the ID of the Medical_Record:");
		Integer idMedicalRecord = Integer.parseInt(r.readLine());
		Medical_Record medicalRecord = medicalRecordMan.getMedical_Record(idMedicalRecord);
		System.out.println("Comment_section");
		String comment_section = r.readLine();
		Diagnosis diagnosis = new Diagnosis(name, todaysDate, comment_section, medicalRecord, disease);
		diagnosisMan.addDiagnosis(diagnosis);
	}
	
	/**
	 * Method to add a new symptom
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void addSymptom() throws NumberFormatException, IOException{
		System.out.println("Please write the symptom info");
		System.out.println("Its name:");
		String name = r.readLine();
		System.out.println("Its pain management:");
		String pain_Management =  r.readLine(); 
		
		Symptom symptom = new Symptom(name, pain_Management);
		symptomMan.addSymptom(symptom);
	}
	
	/**
	 * Method to add a new treatment
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void addTreatment() throws NumberFormatException, IOException{
		System.out.println("Please, enter the treatments info");
		System.out.println("Name:");
		String name = r.readLine();
		System.out.println("Comment Section:");
		String comments = r.readLine();
		Treatment treatment = new Treatment(name, comments);
		treatmentMan.addTreatment(treatment);
	}
	
	/**
	 * Method to list the 6 most recent treatments
	 * 
	 * @throws IOException
	 */
	private static void list6treatments() throws IOException{
		List<Treatment> treatments = treatmentMan.listSixRecentTreatment();
		for(Treatment treatment : treatments) {
			System.out.println(treatment);
		}
	}

	/**
	 * Method to list the 6 most recent diseases
	 * 
	 * @throws IOException
	 */
	private static void list6diseases() throws IOException{
		List<Disease> diseases = diseaseMan.listSixRecentDiseases();
		for(Disease disease : diseases) {
			System.out.println(disease);
		}
	}
	
	/**
	 * Method to modify a treatment
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void modifyTreatment() throws NumberFormatException, IOException{
		System.out.println("\nThese are the the treatments in the database:");
		List<Treatment> treatments = treatmentMan.listMatchingTreatmentsByName("");
		for (Treatment treatment : treatments) {
			System.out.println(treatment);
		}
		System.out.println("\nPlease enter the ID of the treatment you wish to modify:");
		Integer id = Integer.parseInt(r.readLine());
		Treatment treatment = treatmentMan.getTreatment(id);
		
		System.out.println("Here are the actual Treatment's values");
		System.out.println("Press enter to keep them or type a new value.");
		System.out.println("Name (" + treatment.getNameTreatment() + "): ");
		String newName = r.readLine();
		System.out.println("Comments (" + treatment.getComment_Section() + "): ");
		String newComments = r.readLine();
		if (!newName.equals("")) {
			// If I don't keep
			treatment.setNameTreatment(newName);
		}
		if (newComments.equals("")) { // If I keep
		}
		else { // If I don't keep
			treatment.setComment_Section(newComments);
		}
		
		treatmentMan.modifyTreatment(treatment);
	}
	
	/**
	 * Method to delete a treatment
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void deleteTreatment() throws NumberFormatException, IOException{
		System.out.println("These are the treatements in the database:");
		List<Treatment> treatments = treatmentMan.listMatchingTreatmentsByName("");
		for(Treatment treatment : treatments) {
			System.out.println(treatment);
		}
		System.out.println("\n Please enter the id of the Treatment you want to delete:");
		Integer id = Integer.parseInt(r.readLine());
		treatmentMan.deleteTreatment(id);
	}
	
	/**
	 * Method to search a treatment by its name
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void searchTreatmentByName() throws NumberFormatException, IOException{
		System.out.println("Please enter the name of the treatment:");
		String name = r.readLine();
		List<Treatment> treatments = treatmentMan.listMatchingTreatmentsByName(name);
		for(Treatment treatment : treatments) {
			System.out.println(treatment);
		}
	}

	/**
	 * Method to update/modify a disease
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void updateDisease() throws NumberFormatException, IOException{	
		System.out.println("\nThese are the the diseases in the database:");
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
		for (Disease disease : diseases) {
			System.out.println(disease);
		}
		System.out.println("\n Please enter the ID of the disease you wish to modify:");
		Integer id = Integer.parseInt(r.readLine());
		Disease disease = diseaseMan.getDisease(id);
		
		System.out.println("Press enter to keep them or type a new value.");
		System.out.println("Name (" + disease.getNameDisease() + "): ");
		String newName = r.readLine();
		System.out.println("Infectious Rate ("+ disease.getInfectious_rate() +"): ");
		String newInfectiousRate = r.readLine();
		System.out.println("Mortality Rate ("+ disease.getMortality_rate() +"): ");
		String newMortalityRate = r.readLine();
		System.out.println("Incubation Period ("+ disease.getIncubation_period() +"): ");
		String newIncubationPeriod = r.readLine();
		System.out.println("Development Period ("+ disease.getDevelopment_period() +"): ");
		String newDevelopmentPeriod = r.readLine();
		System.out.println("Convalescence Period ("+ disease.getConvalescence_period() +"): ");
		String newConvalescencePeriod = r.readLine();
		System.out.println("Cause ("+ disease.getCause().name() +"): ");
		String cause = r.readLine();
		
		System.out.println("Comments (" + disease.getComment_section() + "): ");
		String newComments = r.readLine();
		if (!newName.equals("")) {
			// If I don't keep
			disease.setNameDisease(newName);
		}
		if (!newInfectiousRate.equals("")) {
			// If I don't keep
			disease.setInfectious_rate(Float.parseFloat(newInfectiousRate));
		}
		if (!newMortalityRate.equals("")) {
			// If I don't keep
			disease.setMortality_rate(Float.parseFloat(newMortalityRate));
		}
		if (!newIncubationPeriod.equals("")) {
			// If I don't keep
			disease.setIncubation_period(Float.parseFloat(newIncubationPeriod));
		}
		if (!newDevelopmentPeriod.equals("")) {
			// If I don't keep
			disease.setDevelopment_period(Float.parseFloat(newDevelopmentPeriod));
		}
		if (!newConvalescencePeriod.equals("")) {
			// If I don't keep
			disease.setConvalescence_period(Float.parseFloat(newConvalescencePeriod));
		}
		if (!cause.equals("")) {
			// If I don't keep
			Cause newCause = Cause.valueOf(cause);
			disease.setCause(newCause);
		}
		if (newComments.equals("")) { // If I keep
		}
		else { // If I don't keep
			disease.setComment_section(newComments);
		}
		
		diseaseMan.modifyDisease(disease);
	}

	/**
	 * Method to delete a disease
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void deleteDisease() throws NumberFormatException, IOException{
		System.out.println("These are the Diseases in the database:");
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
		for(Disease disease : diseases) {
			System.out.println(disease);
		}
		System.out.println("Please enter the id of the Disease you want to delete:");
		Integer id = Integer.parseInt(r.readLine());
		diseaseMan.deleteDisease(id);
	}
	
	/**
	 * Method to add a new symptom by disease
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void newSymptomByDisease(Disease disease) throws NumberFormatException, IOException{
		System.out.println("\nThese are the symptoms in the database, please insert the Id of the ones belonging to the disease: ");
		List<Symptom> symptoms = symptomMan.listMatchingSymptomsByName("");
		for(Symptom symptom : symptoms) {
			System.out.println(symptom);
		}
		Integer id;
		String input;
	    do {
	        System.out.println("\nPlease enter the ID of the symptom you want to add (enter END to finish): ");
	        input = r.readLine();
	        if (input.equalsIgnoreCase("END")) {
	            break;
	        }
	        id = Integer.parseInt(input);
	        Symptom symptom = symptomMan.getSymptom(id);
	        if (symptom != null) {
	            diseaseMan.addSymptomByDisease(disease, symptom);
	        } else {
	            System.out.println("Invalid Symptom ID. Please try again.");
	        }
	    } while (true);
	}
	
	/**
	 * Method to add a new treatment by disease
	 * 
	 * @param disease
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void newTreatmentByDisease(Disease disease) throws NumberFormatException, IOException{
		/*System.out.println("These are the diseases in the database, please insert the id of the one you wish to add treatments to: ");
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
		for(Disease disease : diseases) {
			System.out.println(disease);
		}*/
		//Integer diseaseID = Integer.parseInt(r.readLine());
		//Disease disease = diseaseMan.getDisease(diseaseID);
		System.out.println("\nThese are the treatments in the database, please insert the Id of the ones belonging to the disease: ");
		List<Treatment> treatments = treatmentMan.listMatchingTreatmentsByName("");
		for(Treatment treatment : treatments) {
			System.out.println(treatment);
		}
		Integer id;
		String input;
	    do {
	        System.out.println("\nPlease enter the ID of the treatment you want to add (enter END to finish): ");
	        input = r.readLine();
	        if (input.equalsIgnoreCase("END")) {
	            break;
	        }
	        id = Integer.parseInt(input);
	        Treatment treatment = treatmentMan.getTreatment(id);
	        if (treatment != null) {
	            treatmentMan.addTreatmentByDisease(disease, treatment);
	        } else {
	            System.out.println("Invalid treatment ID. Please try again.");
	        }
	    } while (true);
	}
	
	
	
	/**
	 * Method to add a new treatment by diagnosis
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void newTreatmentByDiagnosis() throws NumberFormatException, IOException{
		System.out.println("These are the diagnoses in the database, please insert the id of the one you wish to add treatments to: ");
		List<Diagnosis> diagnoses = diagnosisMan.listAllDiagnosis();
		for (Diagnosis diagnosis : diagnoses) {
			System.out.println(diagnosis);
		}		Integer diagnosisID = Integer.parseInt(r.readLine());
		Diagnosis diagnosis = diagnosisMan.getDiagnosis(diagnosisID);
		System.out.println("\nThese are the treatments in the database, please insert the Id of the ones belonging to the disease: ");
		List<Treatment> treatments = treatmentMan.listMatchingTreatmentsByName("");
		for(Treatment treatment : treatments) {
			System.out.println(treatment);
		}
		Integer id;
		String input;
	    do {
	        System.out.println("\nPlease enter the ID of the treatment you want to add (enter END to finish): ");
	        input = r.readLine();
	        if (input.equalsIgnoreCase("END")) {
	            break;
	        }
	        id = Integer.parseInt(input);
	        Treatment treatment = treatmentMan.getTreatment(id);
	        if (treatment != null) {
	            treatmentMan.addTreatmentByDiagnosis(diagnosis, treatment);
	        } else {
	            System.out.println("Invalid treatment ID. Please try again.");
	        }
	    } while (true);	}
	
	
	/**
	 * Method to search a treatment by disease
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void searchTreatmentByDisease() throws NumberFormatException, IOException{
		/*System.out.println("These are the diseases in the database, please enter the IDs of the diseases you wish to search, press enter to finish: ");
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
		for(Disease disease : diseases) {
			System.out.println(disease);
		}
		List<Integer> ids = new ArrayList<Integer>();
		Disease disease = new Disease();
		String lineread= r.readLine();
		while(!lineread.equals("")) {
			ids.add(Integer.parseInt(lineread));
			lineread=r.readLine();
		}
		for (Integer integer : ids) {
			disease = diseaseMan.getDisease(integer);
			diseases.add(disease);
		}
		List <Treatment> treatments = treatmentMan.listTreatmentsByDisease(diseases);
		for (Treatment treatment : treatments) {
			System.out.println(treatment);
		}*/
	    System.out.println("These are the diseases in the database, please enter the IDs of the diseases you wish to search, press enter to finish: ");
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

	    List<Treatment> treatments = treatmentMan.listTreatmentsByDisease(selectedDiseases);
	    for (Treatment treatment : treatments) {
	        System.out.println(treatment);
	    }
	}
	
	/**
	 * Method to search a treatment by diagnosis
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void searchTreatmentByDiagnosis() throws NumberFormatException, IOException{
		System.out.println("Please, enter the name of the Diagnosis:");
		List<Integer> ids = new ArrayList<Integer>();
		List<Diagnosis> diagnoses = null;
		Diagnosis diagnosis = new Diagnosis();
		String lineread=r.readLine();
		while(!lineread.equals("")) {
			ids.add(Integer.parseInt(lineread));
			lineread=r.readLine();
		}
		for (Integer integer : ids) {
			diagnosis = diagnosisMan.getDiagnosis(integer);
			diagnoses.add(diagnosis);
		}
		List <Treatment> treatments = treatmentMan.listTreatmentByDiagnoses(diagnoses);
		for (Treatment treatment : treatments) {
			System.out.println(treatment);
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
	
	private static void addTreatmentsToaDisease() throws NumberFormatException, IOException{
		System.out.println("These are the diseases in the database, please insert the id of the one you wish to add treatments to: ");
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
		for(Disease disease : diseases) {
			System.out.println(disease);
		}
		Integer diseaseID = Integer.parseInt(r.readLine());
		Disease disease = diseaseMan.getDisease(diseaseID);
		System.out.println("\nThese are the treatments in the database, please insert the Id of the ones belonging to the disease: ");
		List<Treatment> treatments = treatmentMan.listMatchingTreatmentsByName("");
		for(Treatment treatment : treatments) {
			System.out.println(treatment);
		}
		Integer id;
		String input;
	    do {
	        System.out.println("\nPlease enter the ID of the treatment you want to add (enter END to finish): ");
	        input = r.readLine();
	        if (input.equalsIgnoreCase("END")) {
	            break;
	        }
	        id = Integer.parseInt(input);
	        Treatment treatment = treatmentMan.getTreatment(id);
	        if (treatment != null) {
	            treatmentMan.addTreatmentByDisease(disease, treatment);
	        } else {
	            System.out.println("Invalid treatment ID. Please try again.");
	        }
	    } while (true);
	}
}
