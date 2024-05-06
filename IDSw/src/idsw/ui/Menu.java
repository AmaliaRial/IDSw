package idsw.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import idsw.db.enums.Cause;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.jdbcInterfaces.DiagnosisManager;
import idsw.db.jdbcInterfaces.DiseaseManager;
import idsw.db.jdbcInterfaces.SymptomManager;
import idsw.db.jdbcInterfaces.TreatmentManager;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Symptom;
import idsw.db.pojos.Treatment;

public class Menu {

	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

	private static DiseaseManager diseaseMan;
	private static TreatmentManager treatmentMan;
	private static SymptomManager symptomMan;
	private static DiagnosisManager diagnosisMan;
	//TODO add interfaces

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
		System.out.println("13. Add symptom by disease.");
		System.out.println("14. Search disease by symptom.");
		System.out.println("15. Add Treatment by Diagnosis.");
		System.out.println("16. Add Treatment by Disease.");
		System.out.println("17. Add Diagnosis.");
		System.out.println("18. List 6 recent diseases.");
		System.out.println("0. Exit");
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
			treatmentMan = conMan.getTreatmentMan();
			symptomMan = conMan.getSymptomMan();
			diagnosisMan = conMan.getDiagnosisMan();
			//TODO add conMans
						
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
					newSymptomByDisease();
					break;
				}
				case 14:{
					searchDiseaseBySymptom();					
					break;
				}
				case 15:{
					newTreatmentByDiagnosis();
					break;
				}
				case 16:{
					newTreatmentByDisease();
					break;
				}
				case 17:{
					addDiagnosis();
					break;
				}
				case 18: {
					list6diseases();
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
	
	
	private static void searchDiseaseByName() throws IOException{
		System.out.println("Please, enter the name of the Disease:");
		String name = r.readLine();
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName(name);
		for (Disease disease : diseases) {
			System.out.println(disease);
		}
	}
	
	private static void searchDiseaseBySymptom() throws IOException{
		System.out.println("Please, enter the name of the Symptoms:");
		List<Integer> ids = new ArrayList<Integer>();
		List<Symptom> symptoms = null;
		Symptom symptom = new Symptom();
		String lineread=r.readLine();
		while(!lineread.equals("")) {
			ids.add(Integer.parseInt(lineread));
			lineread=r.readLine();
		}
		for (Integer integer : ids) {
			symptom = symptomMan.getSymptom(integer);
			symptoms.add(symptom);
		}
		List <Disease> diseases = diseaseMan.listMatchingDiseaseBySymptoms(symptoms);
		for (Disease disease : diseases) {
			System.out.println(disease);
		}
	}
	
	private static void addDiagnosis() throws NumberFormatException, IOException{
		System.out.println("Please, enter the diagnosis info");
		System.out.println("Name:");
		String name = r.readLine();
		LocalDate date = LocalDate.now();		
		System.out.println("Comment Section:");
		String comments = r.readLine();
		System.out.println("Disease id:");
		Integer disease_id = Integer.parseInt(r.readLine());
		System.out.println("Medical record id:");
		Integer medical_record = Integer.parseInt(r.readLine());
		//Diagnosis diagnosis = new Diagnosis(name, date, comments, disease_id, medical_record);
		//diagnosisMan.addDiagnosis(diagnosis);
		//TODO fix diagnosis problems
	}
	
	private static void addSymptom() throws NumberFormatException, IOException{
		System.out.println("Please, enter the sympstom's info:");
		System.out.println("Name:");
		String name = r.readLine();
		System.out.println("Pain level (Mild or Severe):");
		String pain_management = r.readLine();
		//Symptom symptom = new Symptom(name, pain_management);
		//symptomMan.addSymptom(symptom);
		//TODO create constructor
	}
	
	private static void addTreatment() throws NumberFormatException, IOException{
		System.out.println("Please, enter the treatments info");
		System.out.println("Name:");
		String name = r.readLine();
		System.out.println("Comment Section:");
		String comments = r.readLine();
		Treatment treatment = new Treatment(name, comments);
		treatmentMan.addTreatment(treatment);
	}
	
	
	private static void list6treatments() throws IOException{
		List<Treatment> treatments = treatmentMan.listSixRecentTreatment();
		for(Treatment treatment : treatments) {
			System.out.println(treatment);
		}
	}
	
	private static void list6diseases() throws IOException{
		List<Disease> diseases = diseaseMan.listSixRecentDiseases();
		for(Disease disease : diseases) {
			System.out.println(disease);
		}
	}
	
	private static void modifyTreatment() throws NumberFormatException, IOException{
		Treatment treatment = null;
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
	
	private static void deleteTreatment() throws NumberFormatException, IOException{
		System.out.println("These are the treatements in the database:");
		List<Treatment> treatments = treatmentMan.listMatchingTreatmentsByName("");
		for(Treatment treatment : treatments) {
			System.out.println(treatment);
		}
		System.out.println("Please enter the id of the Treatment you want to delete:");
		Integer id = Integer.parseInt(r.readLine());
		treatmentMan.deleteTreatment(id);
	}
	
	private static void searchTreatmentByName() throws NumberFormatException, IOException{
		System.out.println("Please enter the name of the treatment:");
		String name = r.readLine();
		List<Treatment> treatments = treatmentMan.listMatchingTreatmentsByName(name);
		for(Treatment treatment : treatments) {
			System.out.println(treatment);
		}
	}

	
	private static void updateDisease() throws NumberFormatException, IOException{
		Disease disease = null;
		System.out.println("Here are the actual Disease's values");
		System.out.println("Press enter to keep them or type a new value.");
		System.out.println("Name (" + disease.getNameDisease() + "): ");
		String newName = r.readLine();
		System.out.println("Infectious Rate ("+ disease.getInfectious_rate() +"): ");
		Float newInfectiousRate = Float.parseFloat(r.readLine());
		System.out.println("Mortality Rate ("+ disease.getMortality_rate() +"): ");
		Float newMortalityRate = Float.parseFloat(r.readLine());
		System.out.println("Incubation Period ("+ disease.getIncubation_period() +"): ");
		Float newIncubationPeriod = Float.parseFloat(r.readLine());
		System.out.println("Development Period ("+ disease.getDevelopment_period() +"): ");
		Float newDevelopmentPeriod = Float.parseFloat(r.readLine());
		System.out.println("Convalescence Period ("+ disease.getConvalescence_period() +"): ");
		Float newConvalescencePeriod = Float.parseFloat(r.readLine());
		System.out.println("Cause ("+ disease.getCause().name() +"): ");
		String cause = r.readLine();
		Cause newCause = Cause.valueOf(cause);
		System.out.println("Comments (" + disease.getComment_section() + "): ");
		String newComments = r.readLine();
		if (!newName.equals("")) {
			// If I don't keep
			disease.setNameDisease(newName);
		}
		if (!newInfectiousRate.equals("")) {
			// If I don't keep
			disease.setInfectious_rate(newInfectiousRate);
		}
		if (!newMortalityRate.equals("")) {
			// If I don't keep
			disease.setMortality_rate(newMortalityRate);
		}
		if (!newIncubationPeriod.equals("")) {
			// If I don't keep
			disease.setIncubation_period(newIncubationPeriod);
		}
		if (!newDevelopmentPeriod.equals("")) {
			// If I don't keep
			disease.setDevelopment_period(newDevelopmentPeriod);
		}
		if (!newConvalescencePeriod.equals("")) {
			// If I don't keep
			disease.setConvalescence_period(newConvalescencePeriod);
		}
		if (!newCause.equals("")) {
			// If I don't keep
			disease.setCause(newCause);
		}
		if (newComments.equals("")) { // If I keep
		}
		else { // If I don't keep
			disease.setComment_section(newComments);
		}
		
		diseaseMan.modifyDisease(disease);
	}

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
		
	private static void newSymptomByDisease() throws NumberFormatException, IOException{
		//TODO newSymptomByDisease
		//Symptom symptom = symptomMan.getSymptom(idSymptom)
	}
	
	private static void newTreatmentByDisease() throws NumberFormatException, IOException{
		//TODO newTreatment By Disease
	}
	
	private static void newTreatmentByDiagnosis() throws NumberFormatException, IOException{
		//TODO newTreatment By Diagnosis
	}
	
	private static void searchTreatmentByDisease() throws NumberFormatException, IOException{
		System.out.println("Please, enter the name of the Disease:");
		List<Integer> ids = new ArrayList<Integer>();
		List<Disease> diseases = null;
		Disease disease = new Disease();
		String lineread=r.readLine();
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
		}
	}
	
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
		List <Treatment> treatments = treatmentMan.listTreatmentByDiagnosis(diagnoses);
		for (Treatment treatment : treatments) {
			System.out.println(treatment);
		}
	}
}
