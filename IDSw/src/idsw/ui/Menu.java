package idsw.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.List;

import idsw.db.jdbc.ConnectionManager;
import idsw.db.jdbcInterfaces.DiseaseManager;
import idsw.db.jdbcInterfaces.TreatmentManager;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Treatment;

public class Menu {

	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

	private static DiseaseManager diseaseMan;
	private static TreatmentManager treatmentMan;
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
		System.out.println(treatments);
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
	

}
