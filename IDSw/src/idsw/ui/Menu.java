package idsw.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;

import idsw.db.jdbc.ConnectionManager;
import idsw.db.jdbcInterfaces.DiseaseManager;
import idsw.db.jdbcInterfaces.TreatmentManager;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Treatment;

public class Menu {

	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private static DiseaseManager diseaseMan;
	private static TreatmentManager treatmentMan;
	//TODO add interfaces

	public static void main(String[] args) {
		try {
		System.out.println("Welcome to IDSW!");
		ConnectionManager conMan = new ConnectionManager();
		//Manager setup
		diseaseMan = conMan.getDiseaseMan();
		treatmentMan = conMan.getTreatmentMan();
		//TODO add conMans
		
		System.out.println("Choose your desired option");
		System.out.println("1. Add a new disease");
		System.out.println("2. Search a disease by its name");
		System.out.println("3. Add a new treatment");
		System.out.println("4. List 6 recent treatments");
		System.out.println("5. Modify a treatment");
		System.out.println("6. Delete a treatement");
		System.out.println("7. Search treatment by name");
		System.out.println("0. Exit");
		int choice = Integer.parseInt(r.readLine());
		
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
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
	}
	
	
	private static void addTreatment() throws NumberFormatException, IOException{
		
	}
	
	
	private static void list6treatments() throws IOException{
		
	}
	
	private static void modifyTreatment() throws NumberFormatException, IOException{
		
	}
	
	private static void deleteTreatment() throws NumberFormatException, IOException{
		
	}
	
	private static void searchTreatmentByName() throws NumberFormatException, IOException{
		
	}
	

}
