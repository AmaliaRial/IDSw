package idsw.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.xml.bind.JAXBException;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import idsw.db.enums.Cause;
import idsw.db.enums.Pain_Management;
import idsw.db.jdbc.ConnectionManager;
import idsw.db.jdbcInterfaces.DiagnosisManager;
import idsw.db.jdbcInterfaces.DiseaseManager;
import idsw.db.jdbcInterfaces.MedicalRecordManager;
import idsw.db.jdbcInterfaces.PatientManager;
import idsw.db.jdbcInterfaces.SimulationManager;
import idsw.db.jdbcInterfaces.SymptomManager;
import idsw.db.jdbcInterfaces.TreatmentManager;
import idsw.db.jdbcInterfaces.VirtualPopulationManager;
import idsw.db.jpa.JPAUserManager;
import idsw.db.jpaInterfaces.UserManager;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Medical_Record;
import idsw.db.pojos.Patient;
import idsw.db.pojos.Role;
import idsw.db.pojos.Simulation;
import idsw.db.pojos.Symptom;
import idsw.db.pojos.Treatment;
import idsw.db.pojos.User;
import idsw.db.pojos.Virtual_Population;
import idsw.db.utilities.GraphUtilities;
import idsw.db.xml.CreateFullXML;
import idsw.db.xml.Java2XmlMedicalRecord;
import idsw.db.xml.Xml2HtmlMedicalRecord;
import idsw.db.xml.Xml2JavaMedicalRecord;

public class Menu {

	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	

	private static User loggedInUser;


	private static ConnectionManager conMan;
	private static Connection c;
	private static DiseaseManager diseaseMan;
	private static TreatmentManager treatmentMan;
	private static SymptomManager symptomMan;
	private static DiagnosisManager diagnosisMan;
	private static PatientManager patientMan;
	private static MedicalRecordManager medicalRecordMan;
	private static SimulationManager simulationMan;
	private static VirtualPopulationManager virtualPopulationMan;
	
	private static JPAUserManager userManager;
	private static UserManager userMan;

	/**
	 * Researcher menu
	 * 
	 * @return choice
	 * @throws IOException
	 */
	public static int menuResearcher() throws IOException {
		int choice;
		while (true) {
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
			System.out.println("13. Modify symptom.");
			System.out.println("14. Delete symptom.");
			System.out.println("15. Search disease by symptom.");
			System.out.println("16. List 6 recent diseases.");
			System.out.println("17. Add treatments to a disease.");
			System.out.println("18. Search disease that most matches symptoms.");
			System.out.println("19. Create a simulation.");
			System.out.println("20. List symptom by name");
			System.out.println("21. Show development graph of a disease.");
			System.out.println("22. Search Simulation by Population");
			System.out.println("23. Add symptoms to a disease.");
			System.out.println("24. Edit Profile");
			System.out.println("0. Log Out");
			try {
				choice = Integer.parseInt(r.readLine());
				return choice;
			}catch (NumberFormatException e) {
	            System.err.println("Not a number");
			}
		}	
	}
		
 	
	/**
	 * Patient menu
	 * 
	 * @return choice
	 * @throws IOException
	 */
	public static int menuPatient() throws IOException {
		int choice;
		while (true) {
		System.out.println("\n Choose your desired option");
		System.out.println("1. Search a disease by its name");
		System.out.println("2. Search treatment by name");
		System.out.println("3. Search treatment by diagnosis (Look at your Medical Record)");
		System.out.println("4. Search disease by symptom.");
		System.out.println("5. Search disease that most matches symptoms.");
		System.out.println("6. Search symptom by name");
		System.out.println("7. Show development graph of a disease.");
		System.out.println("8. List my 6 most recent diagnoses.");
		System.out.println("9. Edit Profile");
		System.out.println("0. Log Out");
		try {
			choice = Integer.parseInt(r.readLine());
			return choice;
		}catch (NumberFormatException e) {
            System.err.println("Not a number");
		}
	}
	}
	
	/**
	 * Doctor menu
	 * 
	 * @return choice
	 * @throws IOException
	 */
	public static int menuDoctor() throws IOException {
		int choice;
		while (true) {
		System.out.println("\n Choose your desired option");
		System.out.println("1. Search a disease by its name");
		System.out.println("2. Search treatment by name");
		System.out.println("3. Search treatment by disease");
		System.out.println("4. Search treatments by diagnoses");
		System.out.println("5. Search disease by symptom.");
		System.out.println("6. Add Treatment by Diagnosis.");
		System.out.println("7. Add Diagnosis.");
		System.out.println("8. Search disease that most matches symptoms.");
		System.out.println("9. Create an XML and an HTML file of a Medical Record");
		System.out.println("10. Import an XML file of a Medical Record");
		System.out.println("11. Search symptom by name");
		System.out.println("12. Show development graph of a disease.");
		System.out.println("13. List 6 most recent treatments added.");
		System.out.println("14. Delete a patients diagnosis");
		System.out.println("15. Edit Profile");
		System.out.println("0. Log Out");
		try {
			choice = Integer.parseInt(r.readLine());
			return choice;
		}catch (NumberFormatException e) {
            System.err.println("Not a number");
		}
	}
	}
	
	public static void main(String[] args) {
		
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
			simulationMan = conMan.getSimulationMan();
			virtualPopulationMan = conMan.getVirtualPopulationMan();
			c = DriverManager.getConnection("jdbc:sqlite:./db/idsw.db");
			//JPA managers
			userMan = new JPAUserManager();
			userManager = new JPAUserManager();
			
			while(true) {
			System.out.println("\nChoose your desired option");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("0. Exit");
			int choice1=-1;
			boolean b=false;
			try {
				choice1 = Integer.parseInt(r.readLine());
			}catch (NumberFormatException e) {
	            System.err.println("Not a number");
	            b=true;
			}
				switch (choice1) {
					case 1: {
						loggedInUser = menuLogin();
						displayMenuBasedOnUser(loggedInUser);
						break;
					}
		
					case 2: {
						loggedInUser = menuRegister();
						displayMenuBasedOnUser(loggedInUser);
						break;
						}
						
					case 0: {
						System.out.println("Exiting...");				
						conMan.close();
						
						return;
					}
					default:{
						if(b) {
							
						}else {
						 System.err.println(choice1+" is not an available option. Please select another one.");
						 break;
						}
					}
				}
			
			}
			
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Shows the menu based on the user's role
	 * 
	 * @param user
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws SQLException
	 * @throws JAXBException
	 */
	private static void displayMenuBasedOnUser(User user) throws IOException, NumberFormatException, SQLException, JAXBException {
	    int choice;
	    if(user.getRole().getName().equalsIgnoreCase("patient")) {
	    	do {
				choice = menuPatient();
			switch (choice) {
				case 1: {
					searchDiseaseByName();
					break;
					}

				case 2: {
					searchTreatmentByName();
					break;
				}
				case 3:{
					searchTreatmentByDiagnosisPatient();		
					break;
				}
				case 4:{
					searchDiseaseBySymptom();					
					break;
				}

				case 5: {
					mostMatchingDiseaseBySymptom();
					break;
				}
				case 6: {
					ListMatchingSymptomsByName();
					break;
				}
				case 7: {
					showDevelopmentGraph();
					break;
				}
				case 8:{
					list6recentdiagnoses();
					break;
				}
				case 9: {
					modifyUser();
					break;
				}
					
				case 0: {
					conMan.close();
					if (userManager != null) {
					    userManager.close();
					}
					return;
				}
				default:
				 System.err.println(choice+" is not an available option. Please select another one.");
				 break;
				}
			
			} while (choice != 0);
			
		}else if (user.getRole().getName().equalsIgnoreCase("doctor")) {
			do {
				choice = menuDoctor();
			switch (choice) {
				case 1: {
					searchDiseaseByName();
					break;
				}
				case 2: {
					searchTreatmentByName();
					break;
				}
				case 3:{
					searchTreatmentByDisease();
					break;
				}
				case 4:{
					searchTreatmentByDiagnosis();		
					break;
				}
				case 5:{
					searchDiseaseBySymptom();					
					break;
				}
				case 6:{
					newTreatmentByDiagnosis();
					break;
				}
				case 7:{
					addDiagnosis();
					break;
				}
				case 8: {
					mostMatchingDiseaseBySymptom();
					break;
				}
				case 9:{
					createXMLandHTML();
					break;
				}
				case 10: {
					importXML();
					break;
				}
				case 11: {
					ListMatchingSymptomsByName();
					break;
				}
				case 12: {
					showDevelopmentGraph();
					break;
				}
				case 13:{
					list6treatments();
					break;
				}
				case 14: {
					deleteDiagnosis();
					break;
				}
				case 15: {
					modifyUser();
					break;
				}
				case 0: {
					conMan.close();
					if (userManager != null) {
					    userManager.close();
					}
					return;
				}
				default:
					System.err.println(choice+" is not an available option. Please select another one.");
					break;
					}
			
			} while (choice != 0);
		}else if (user.getRole().getName().equalsIgnoreCase("researcher")) {
			do {
				choice = menuResearcher();
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
					modifySymptom();
					break;
				}
				case 14:{
					deleteSymptom();
					break;
				}
				case 15: {
					searchDiseaseBySymptom();
					break;
				}
				case 16: {
					list6diseases();
					break;
				}

				case 17: {
					addTreatmentsToaDisease();
					break;
				}
				case 18: {
					mostMatchingDiseaseBySymptom();
					break;
				}
				case 19: {
					simulation();
					break;
				}
				case 20: {
					ListMatchingSymptomsByName();
					break;
				}
				case 21: {
					showDevelopmentGraph();
					break;
				}
				case 22: {
					searchSimulation();
					break;
				}
				case 23: {
					addSymptomsToDisease();
					break;
				}
				case 24: {
					modifyUser();
					break;
				}
				case 0: {
					conMan.close();
					if (userManager != null) {
					    userManager.close();
					}
					return;
				}
				default:
					System.err.println(choice+" is not an available option. Please select another one.");
					break;
				}
			
			} while (choice !=0);
		}
	}
	
	/**
	 * Logs in a user
	 * 
	 * @return user if the login is successful
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws SQLException 
	 */
	private static User menuLogin() throws NumberFormatException, IOException, SQLException {
		Boolean verified=false;
		while(!verified) {
			System.out.println("Please, type your username:");
			String username = r.readLine();
			System.out.println("Please, type your password:");
			String password = r.readLine();
			verified = userMan.verifyPassword(password, username);
			if (verified) {
				User user = userMan.login(username);
				System.out.println("\nWelcome " + user.getName());
				// After successful login, setup the database connection again
			    conMan = new ConnectionManager();
			    //Manager setup
			    diseaseMan = conMan.getDiseaseMan();
			    treatmentMan = conMan.getTreatmentMan();
			    symptomMan = conMan.getSymptomMan();
			    diagnosisMan = conMan.getDiagnosisMan();
			    patientMan = conMan.getPatientMan();
			    medicalRecordMan = conMan.getMedicalRecordMan();
			    simulationMan = conMan.getSimulationMan();
			    virtualPopulationMan = conMan.getVirtualPopulationMan();
			    c = DriverManager.getConnection("jdbc:sqlite:./db/idsw.db");
			    //JPA managers
			    userMan = new JPAUserManager();
			    userManager = new JPAUserManager();
				return user;    
			} else {
				System.err.println("Invalid username or password");
			}	
		}
		return null;	
	}
	
	/**
	 * Registers a new user
	 * 
	 * @return user
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws ExistingUserNameException 
	 * @throws InvalidSexException 
	 */
	private static User menuRegister() throws NumberFormatException, IOException {
		Boolean exception=true;
		System.out.println("Please, type your name:");
		String name = r.readLine();
		System.out.println("Please, type your surname:");
		String surname = r.readLine();
		String username=null;
		while(exception) {
			System.out.println("Please, type a username:");
			username = r.readLine();
			if(userMan.login(username)!=null) {
				System.err.println("Username already taken, please choose another one.");
			}else {
				exception=false;
			}
		}
		exception=true;
		System.out.println("Please, type a password:");
		String password = r.readLine();
		LocalDate localDate=null;
		while(exception) {
			System.out.println("Please, type your date of birth (dd-mm-yyyy):");
			try {
				localDate = LocalDate.parse(r.readLine(), formatter);
				exception=false;
			}catch(DateTimeParseException dtpe){
				System.err.println("Invalid date, please insert it as indicated");
			}
		}
		exception=true;
		Date dob = Date.valueOf(localDate);
		String sex=null;
		while(exception) {
			System.out.println("Please, type your sex (MALE/FEMALE):");
			sex =  r.readLine();
			if(sex.equalsIgnoreCase("MALE")||sex.equalsIgnoreCase("FEMALE")) {
				exception=false;
			}else {
				System.err.println("Invalid Sex, please select as shown");
			}
		}
		exception=true;
		String email=null;
		while(exception) {
			System.out.println("Please, type your email: ");
			email = r.readLine();
			Pattern pattern = Pattern.compile(".*.@.*.\\..*.");
			Matcher matcher = pattern.matcher(email);
			if(matcher.find()) {
				exception=false;
			}else {
				System.err.println("Not existing email, shoud be x@x.x");
			}
		}
		exception=true;
		Integer phone=null;
		while(exception) {
			System.out.println("Please, type your phone number: ");
			try {
				phone = Integer.parseInt(r.readLine());
				if(phone<1000000000 && phone>99999999) {
					exception=false;
				}else {
					System.err.println("Not existing phone, please introduce a correct phone number");
				}
			}catch(IllegalArgumentException iae) {
				System.err.println("Not a number, please insert number");
			}
		}
		exception=true;
		String dni =null;
		while(exception) {
			System.out.println("Please, type your DNI (without the letter): ");
			dni = r.readLine();
			try {
				int dniNumber = Integer.parseInt(dni);
				if(dniNumber<100000000 && dniNumber>9999999) {
					exception=false;
				}else {
					System.err.println("Not valid DNI, it must have 8 digits");
				}
			}catch(IllegalArgumentException iae) {
				System.err.println("Not a number, please insert number");
			}
		}
		exception=true;
		
		String roleName =null;
		while(exception) {
			System.out.println("Choose your role (type its NAME):");
			List<Role> roles = userMan.getAllRoles();
			System.out.println(roles);
			roleName = r.readLine();
			if(roleName.equalsIgnoreCase("patient")||roleName.equalsIgnoreCase("doctor")||roleName.equalsIgnoreCase("researcher")) {
				exception=false;
			}else {
				System.err.println("Invalid role, please write one of the indicated roles");
			}
		}
		exception=true;
		
		Role role = userMan.getRole(roleName);
		Long verificationNumber = null;
		while(exception) {
			try {
				if(roleName.equalsIgnoreCase("patient")) {
					System.out.println("Please, enter your Insurance Number:");
					verificationNumber =  Long.parseLong(r.readLine());
				} else if (roleName.equalsIgnoreCase("doctor")) {
					System.out.println("Please, enter your Collegiate Number:");
					verificationNumber = Long.parseLong(r.readLine());
				} else if (roleName.equalsIgnoreCase("researcher")) {
					System.out.println("Please, enter your Collegiate Number:");
					verificationNumber = Long.parseLong(r.readLine());
				}
			exception=false;
			}catch(IllegalArgumentException iae) {
				System.err.println("Not a number, please insert number");
			}	
		}
		exception=true;
		
		User u = new User(dni,dob,email,name, password, verificationNumber, phone, sex, surname, username, role);
		userMan.register(u);
		if (roleName.equalsIgnoreCase("patient")) {
			Patient patient = new Patient(name, surname, username, dob);
			patientMan.addPatient(patient);
			medicalRecordMan.addMedicalRecord(patient);
		}
		
		return u;
	}
	
	/**
	 * Creates a simulation based on parameters given by the user
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void simulation() throws NumberFormatException, IOException {
		System.out.println("\nThese are the the diseases in the database:");
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
		for (Disease disease : diseases) {
			System.out.println(disease);
		}
		boolean b= true;
		Disease disease=null;
		while(b) {
			try {
				System.out.println("\n Please enter the ID of the disease you wish to do a simulation on:");
				Integer id = Integer.parseInt(r.readLine());
				disease = diseaseMan.getDisease(id);
			}catch(NumberFormatException e){
				System.err.println("Not a number");
			}
			if(disease==null) {	
				System.err.println("Not exixting disease for that id");
			}else {
				b=false;
			}
		}
		b=true;
		System.out.println("Please enter the data on the virtual population for this simulation:");
		Integer population=null;
		while(b) {
			try {
			System.out.println("Enter the number of people in the population:");
			population = Integer.parseInt(r.readLine());
			}catch(NumberFormatException e){
				System.err.println("Not a number");
			}
			if(population!=null) {
				if(population<1) {	
					System.err.println("should be grater than 0");
				}else {
					b=false;
				}	
			}
		}
		b=true;
		Float p_infected = null;
		Float p_healthy = null;
		Float p_immune = null;
		while(b) {
			try {
				System.out.println("Enter the percentage of people that are infected:");
				p_infected = Float.parseFloat(r.readLine());
				System.out.println("Enter the percentage of people that are healthy:");
				p_healthy = Float.parseFloat(r.readLine());
				System.out.println("Enter the percentage of people that are immune:");
				p_immune = Float.parseFloat(r.readLine());
			}catch(NumberFormatException e){
				System.err.println("Not a number");
			}
			if(p_infected!=null&&p_healthy!=null&&p_immune!=null) {
				if((p_infected+p_healthy+p_immune)==100) {	
					b=false;
				}else {
					System.err.println("The percenteges should add up to 100");
				}
			}
		}
		b=true;
		Integer immunity_period=null;
		while (b) {
			try {
				System.out.println("Enter the immunity period (number of days a person can be immune, can be 0):");
				immunity_period = Integer.parseInt(r.readLine());
			}catch(NumberFormatException e){
				System.err.println("Not a number");
			}
			if(immunity_period!=null){
				if(immunity_period>=0) {	
					b=false;
				}else {
					System.err.println("Can`t be less that 0");
					
				}
			}
			
		}
		Virtual_Population virtual_Population = new Virtual_Population(population, p_infected, p_healthy, p_immune, immunity_period, disease);
	    virtualPopulationMan.fillPopulation(virtual_Population);
	    //System.out.println(virtual_Population);
	    Simulation simulation = simulationMan.createSimulation(virtual_Population);
	    System.out.println("\nINITIAL PARAMENTER"
	    		+ "\nInitial polilation: "+virtual_Population.getInitial_population()
	    		+ "\nInfected Percentage: "+virtual_Population.getP_infected()
	    		+ "\nHealthy Percentage: "+virtual_Population.getP_healthy()
	    		+ "\nInmune Percentage: "+virtual_Population.getP_immune()
	    		+ "\nImmunity Period: "+virtual_Population.getImmunity_period()
	    		+ "\nDisease: "+virtual_Population.getDisease().getNameDisease()
	    		+ "\n");
	    
	    System.out.println("SIMULATION RESULTS"
	    		+ "\nTotal Infections: "+ simulation.getTotalInfections()
	    		+ "\nTotal Deaths: "+ simulation.getTotalDeaths()
	    		+ "\nTotal Immunitation: "+ simulation.getTotalImmunity()
	    		+ "\nTotal Population: "+ simulation.getTotalPopulation()
	    		+ "\nSimulation Graph on the new window."
	    		+ "\n");	
	    
	    GraphUtilities utilGraph = new GraphUtilities();
	    BufferedImage chartSimulationImage = utilGraph.binaryIntoImage(simulation.getSimulationGraph());
	    
	    showImage(chartSimulationImage);
	}
	
	/**
	 * Creates a window with the image of the simulation created
	 * 
	 * @param image
	 */
	private static void showImage(BufferedImage image) {
        // Create a Swing frame 
        JFrame frame = new JFrame("Imagen");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // create a panel to contain the image
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // draw the image
                g.drawImage(image, 0, 0, null);
            }

            @Override
            public Dimension getPreferredSize() {
                // return the size of the image
                return new Dimension(image.getWidth(), image.getHeight());
            }
        };

        // add the panel to the frame
        frame.getContentPane().add(panel);

        // set the frame size (this will also set the size of the panel)	
        frame.pack();

        // make a pop up
        frame.setVisible(true);
    }
	
	/**
	 * Creates a window with the image of the development graph of a disease in a person
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void showDevelopmentGraph() throws NumberFormatException, IOException {
		System.out.println("\nThese are the the diseases in the database:");
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
		for (Disease disease : diseases) {
			System.out.println("\n "+ disease);
		}
		boolean b= true;
		Disease disease=null;
		while(b) {
			try {
				System.out.println("\n Please enter the ID of the disease you wish to view its development graph:");
				Integer id = Integer.parseInt(r.readLine());
				disease = diseaseMan.getDisease(id);
			}catch(NumberFormatException e){
				System.err.println("Not a number");
			}
			if(disease==null) {	
				System.err.println("Not exixting disease for that id");
			}else {
				b=false;
			}
		}
		
		GraphUtilities graph = new GraphUtilities();
		JFreeChart diseaseGraph = graph.graphDiseaseDevelopment(disease);
		
		JFrame frame = new JFrame("Development Graph");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		ChartPanel chartPanel = new ChartPanel(diseaseGraph);
		frame.getContentPane().add(chartPanel);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Method to create an XML and an HTML file of a Medical Record
	 * 
	 * @throws IOException
	 * @throws SQLException
	 */
	private static void createXMLandHTML() throws IOException, SQLException {
	    System.out.println("These are the Medical Records in the database: ");
	    List<Medical_Record> records = medicalRecordMan.printMedicalRecords();
	    for (Medical_Record record : records) {
			System.out.println("\n"+record);
		}
	    System.out.println("Please, type the ID of the Medical Record you want to create the XML and HTML files:");
	    Integer record_id = null;
	    while (record_id == null) {
	        try {
	            record_id = Integer.parseInt(r.readLine());
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid input. Please enter a number.");
	        }
	    }
	
	    Java2XmlMedicalRecord.createXML(record_id);
	    CreateFullXML.createFULLxml();
	    Xml2HtmlMedicalRecord.simpleTransform("./xmls/External_MedicalRecord.xml", "./xmls/MedicalRecord-Style.xslt", "./xmls/External-MedicalRecord.html");
	}

	
	/**
	 * Imports an XML file of a Medical Record and stores it in the database
	 * 
	 * @throws JAXBException
	 */
	private static void importXML() throws JAXBException {
		Xml2JavaMedicalRecord.importXML();
	}
	

	
	
	/*Stupid for the same method to be here and in Java2XmlMedicalRecord
	 * 
	 * public static void createXML(int record_id) {
        // Get a connection to the database
    	try {
			c = DriverManager.getConnection("jdbc:sqlite:./db/idsw.db"); // replace with your database connection string

			// Create the JAXBContext
			JAXBContext jaxbContext = JAXBContext.newInstance(Medical_Record.class);
			// Get the marshaller
			Marshaller marshaller = jaxbContext.createMarshaller();

			// Pretty formatting
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			String selectSQL = "SELECT * FROM medical_records WHERE idMedical_Record = ?";
			PreparedStatement ps = c.prepareStatement(selectSQL);
			ps.setInt(1, record_id);
			ResultSet rs = ps.executeQuery();
			Medical_Record record = null;
			if (rs.next()) {

				Integer id = rs.getInt("IDMedical_Record");
				Integer patient_id = rs.getInt("patient");
				Patient patient = conMan.getPatientMan().getPatient(patient_id);
				Date dob = patient.getDob();
				patient.setDob(dob);
				record = new Medical_Record(id, patient);
			    
				// Fetch the diagnoses for the current medical record
			    String selectDiagnosesSQL = "SELECT * FROM diagnoses WHERE medicalRecord_id = ?";
			    PreparedStatement psDiagnoses = c.prepareStatement(selectDiagnosesSQL);
			    psDiagnoses.setInt(1, id);
			    ResultSet rsDiagnoses = psDiagnoses.executeQuery();
			    List<Diagnosis> diagnoses = new ArrayList<>();
			    while (rsDiagnoses.next()) {
					Integer idDiag = rsDiagnoses.getInt("IDdiagnosis");
					String name = rsDiagnoses.getString("nameDiagnosis");
					Date date = rsDiagnoses.getDate("date");
					String comments = rsDiagnoses.getString("comment_section");
					Integer idDisease = rsDiagnoses.getInt("disease_id");
					Disease disease = conMan.getDiseaseMan().getDisease(idDisease);
					Integer idMedicalRecord =rsDiagnoses.getInt("medicalrecord_id"); 
					Medical_Record medicalRecord = conMan.getMedicalRecordMan().getMedical_Record(idMedicalRecord);
					Diagnosis diagnosis = new Diagnosis(idDiag, name, date, comments,disease);
					
					// Fetch the treatments for the current diagnosis
			        String selectTreatmentsSQL = "SELECT treatments.* FROM treatments "
			                                    + "JOIN diagnosis_has_treatments ON IDtreatment = treatment_id WHERE diagnosis_id = ?";
			        PreparedStatement psTreatments = c.prepareStatement(selectTreatmentsSQL);
			        psTreatments.setInt(1, idDiag);
			        ResultSet rsTreatments = psTreatments.executeQuery();
			        List<Treatment> treatments = new ArrayList<>();
			        while (rsTreatments.next()) {
			        	String treatmentName = rsTreatments.getString("nameTreatment");
						String comment_section = rsTreatments.getString("comment_section");
						Treatment treatment = new Treatment(treatmentName, comment_section);
						treatments.add(treatment);
			        }
			        rsTreatments.close();
			        psTreatments.close();

			        // Set the treatments to the diagnosis
			        diagnosis.setTreatments(treatments);
					
					diagnoses.add(diagnosis);			
			    }
			    rsDiagnoses.close();
			    psDiagnoses.close();

			    // Set the diagnoses to the medical record
			    record.setDiagnoses(diagnoses);
			}
			rs.close();
			ps.close();

			try {
			    // Use the Marshaller to marshal the Java object to a file
			    File directory = new File("./xmls/");
			    if (! directory.exists()){
			        boolean dirCreated = directory.mkdir();
			        System.out.println("Directory created: " + dirCreated);
			    }
			    File file = new File("./xmls/MedicalRecord.xml");
			    marshaller.marshal(record, file);
			    // Printout
			    marshaller.marshal(record, System.out);
			} catch (Exception e) {
			    e.printStackTrace();
			}
		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
    }*/
	
	/**
	 * List symptoms by their name
	 * 
	 * @throws IOException
	 */
	private static void ListMatchingSymptomsByName() throws IOException {
		System.out.println("\nPlease, type the symptom's name:");
		String name = r.readLine();
		List<Symptom> symptoms = symptomMan.listMatchingSymptomsByName(name);
		for (Symptom symptom : symptoms) {
			System.out.println(symptom);
		}
	}
	
	/**
	 * Updates a Symptom
	 * 
	 * @throws IOException
	 */
	private static void modifySymptom() throws IOException{
		System.out.println("\nThese are the symptoms in the database:");
		List <Symptom> symptoms = symptomMan.listMatchingSymptomsByName("");
		for (Symptom symptom : symptoms) {
			System.out.println(symptom);
		}
		boolean b= true;
		Symptom symptom=null;
		while(b) {
			try {
				System.out.println("\nPlease enter the ID of the symptom you wish to modify:");
				Integer id = Integer.parseInt(r.readLine());
				symptom = symptomMan.getSymptom(id);
			}catch(NumberFormatException e){
				System.err.println("Not a number");
			}
			if(symptom==null) {	
				System.err.println("Not exixting symptom for that id");
			}else {
				b=false;
			}
		}
		b=true;
		System.out.println("Here are the actual Symptoms values");
		System.out.println("Press enter to keep them or type a new value.");
		System.out.println("Name (" + symptom.getNameSymptom() + "): ");
		String newName = r.readLine();
		while(b) {
			System.out.println("Pain management (" + symptom.getPain_management().name() + "): ");
			String pain_Management = r.readLine();
			if (!newName.equals("")) {
				// If I don't keep
				symptom.setNameSymptom(newName);
			}
			if (!pain_Management.equals("")) {
				if(pain_Management.equalsIgnoreCase("MILD")||pain_Management.equalsIgnoreCase("SEVERE")) {
					Pain_Management newPain_management = Pain_Management.valueOf(pain_Management);	
					symptom.setPain_management(newPain_management);
					b=false;;
				}else {
					System.err.println("incorrect Pain Management value");
				}
			}else{
				b=false;
			}
		}
		symptomMan.modifySymptom(symptom);
	}

	/**
	 * Deletes a symptom from the database
	 * 
	 * @throws IOException
	 */
	private static void deleteSymptom() throws IOException{
		System.out.println("\nThese are the symptoms in the database:");
		List<Symptom> symptoms = symptomMan.listMatchingSymptomsByName("");
		for(Symptom sumptom:symptoms) {
			System.out.println(sumptom);
		}

		Integer id=null;
		boolean b= true;
		Symptom symptom=null;
		while(b) {
			try {
				System.out.println("\nPlease enter the ID of the symptom you wish to modify:");
				id = Integer.parseInt(r.readLine());
				symptom = symptomMan.getSymptom(id);
			}catch(NumberFormatException e){
				System.err.println("Not a number");
			}
			if(symptom==null) {	
				System.err.println("Not exixting symptom for that id");
			}else {
				b=false;
			}
		}
		symptomMan.deleteSymptom(id);
	}
	
	/**
	 * This method deletes a diagnosis from a specific medical Record
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	private static void deleteDiagnosis() throws SQLException, IOException {
		Integer record_id=null;
		Medical_Record record = null;
		boolean b= true;
		while(b) {
			try {
				System.out.println("\nThese are the Medical Records in the database, please enter the ID of the one you wish to modify:");
				List<Medical_Record> records = medicalRecordMan.printMedicalRecords();
				for (Medical_Record medical_Record : records) {
					System.out.println("\n"+medical_Record);
				}
				record_id = Integer.parseInt(r.readLine());
				record = medicalRecordMan.getMedical_Record(record_id);
			}catch(NumberFormatException e){
				System.err.println("Not a number");
			}
			if(record==null) {	
				System.err.println("Not exixting record for that id");
			}else {
				b=false;
			}
		}
		b=true;
		System.out.println("\nThese are the diagnoses in the Medical Record:");
		List<Diagnosis> diagnoses = diagnosisMan.listMatchinDiagnosesByPatient(record_id);
		for (Diagnosis diagnosis : diagnoses) {
			System.out.println("\n"+diagnosis.getIdDiagnosis() + "   " + diagnosis.getNameDiagnosis() + "   " + diagnosis.getLocalDate() + "   " + diagnosis.getComment_section() + "   " + diagnosis.getDisease().getNameDisease() + "  [ " + diagnosis.getMedicalRecord().getPatient().getNamePatient() + "   " + diagnosis.getMedicalRecord().getPatient().getSurname() + "   " + diagnosis.getMedicalRecord().getPatient().getDob() + " ]");
		}
		Integer id = Integer.parseInt(r.readLine());
		Diagnosis diagnosis = null;
		while(b) {
			try {
				System.out.println("\n Please enter the ID of the one you wish to delete:");
				id = Integer.parseInt(r.readLine());
				diagnosis = diagnosisMan.getDiagnosis(id);
			}catch(NumberFormatException e){
				System.err.println("Not a number");
			}
			if(diagnosis==null) {	
				System.err.println("Not exixting diagnosis for that id");
			}else {
				b=false;
			}
		}
		diagnosisMan.deleteDiagnosis(id);
	}
	
	/*Method not used
	 * 
	 * private static void getUser() throws NumberFormatException, IOException {
		System.out.println("Please, type your username:");
		String username = r.readLine();
		User user = userMan.getUser(username);
		if (user != null) {
			System.out.println(user);
		} else {
			System.out.println("User not found");
		}
	}*/
	
	/**
	 * Method that allows the user to search a disease that most matches the symptoms selected 
	 * 
	 * @throws IOException
	 */
	private static void mostMatchingDiseaseBySymptom() throws IOException{
		System.out.println("\nThese are the symptoms in the database: ");
		List<Symptom> symptoms = symptomMan.listMatchingSymptomsByName("");
		for (Symptom symptom : symptoms) {
			System.out.println("\n"+symptom.getIdSymptom()+ "   "+symptom.getNameSymptom() + "   "+ symptom.getPain_management());
		}
		System.out.println("\nPlease enter the IDs of the symptoms you wish to search, type END to finish: ");
		List<Integer> symptomIds = new ArrayList<>();
		Symptom symptomSelected=null;
		Integer simptomId=null;
		String lineread;
		while (!(lineread = r.readLine()).equalsIgnoreCase("end")) {
			try {
			simptomId=Integer.parseInt(lineread);
			symptomSelected=symptomMan.getSymptom(simptomId) ;
			}catch(NumberFormatException e){
				System.err.println("Not a number");
			}
			if(symptomSelected==null) {
				System.err.println("no existing symptom for that id");
			}else {
				symptomIds.add(simptomId);
			}
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

		Disease disease = diseaseMan.getMostMatchingDiseaseBySymptoms(selectedSymptoms);
		System.out.println("\nThe most matching disease is: ");
		System.out.println(disease);
	}
	
	
	/**
	 * Method to add a new disease
	 * 
	 * @throws IOException
	 */
	private static void addDisease() throws IOException {
	    System.out.println("\nPlease write the Disease info");
	
	    System.out.println("Its name:");
	    String name = r.readLine();
	
	    Float infectRate = null;
	    while (infectRate == null) {
	        try {
	            System.out.println("Infectious Rate:");
	            infectRate = Float.parseFloat(r.readLine());
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid input. Please enter a number.");
	        }
	    }
	
	    Float mortRate = null;
	    while (mortRate == null) {
	        try {
	            System.out.println("Mortality Rate:");
	            mortRate = Float.parseFloat(r.readLine());
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid input. Please enter a number.");
	        }
	    }
	
	    Float incubPeriod = null;
	    while (incubPeriod == null) {
	        try {
	            System.out.println("Incubation Period:");
	            incubPeriod = Float.parseFloat(r.readLine());
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid input. Please enter a number.");
	        }
	    }
	
	    Float devPeriod = null;
	    while (devPeriod == null) {
	        try {
	            System.out.println("Development Period:");
	            devPeriod = Float.parseFloat(r.readLine());
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid input. Please enter a number.");
	        }
	    }
	
	    Float convPeriod = null;
	    while (convPeriod == null) {
	        try {
	            System.out.println("Convalescense Period:");
	            convPeriod = Float.parseFloat(r.readLine());
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid input. Please enter a number.");
	        }
	    }
	
	    System.out.println("Cause (VIRUS/BACTERIA):");
	    String cause = r.readLine();
	    if (!cause.equalsIgnoreCase("VIRUS") && !cause.equalsIgnoreCase("BACTERIA")) {
	        throw new IllegalArgumentException("Invalid cause. Please enter either VIRUS or BACTERIA.");
	    }
	
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
	    }
	
	    System.out.println("\n Would you like to add symptoms to this disease? Please answer with a Yes or a NO :");
	    String answer2 = r.readLine();
	    if (answer2.equalsIgnoreCase("Yes")) {
	        newSymptomByDisease(disease);
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
	private static void searchDiseaseBySymptom() throws IOException {
	System.out.println("These are the symptoms in the database: ");
	List<Symptom> symptoms = symptomMan.listMatchingSymptomsByName("");
	for (Symptom symptom : symptoms) {
	    System.out.println(symptom);
	}
	System.out.println("\nPlease enter the IDs of the symptoms you wish to search, type END to finish: ");
	List<Integer> symptomIds = new ArrayList<>();
	String lineread;
	while (!(lineread = r.readLine()).equalsIgnoreCase("end")) {
	    try {
	        symptomIds.add(Integer.parseInt(lineread));
	    } catch (NumberFormatException e) {
	        System.err.println("Invalid input. Please enter a number.");
	        continue;
	    }
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
	 * @throws IOException
	 */
	private static void addDiagnosis() throws IOException {
	    System.out.println("Please write the Diagnosis info");
	
	    System.out.println("Name:");
	    String name = r.readLine();
	
	    LocalDate localDate = null;
	    while (localDate == null) {
	        try {
	            System.out.println("Date (dd-mm-yyyy):");
	            localDate = LocalDate.parse(r.readLine(), formatter);
	        } catch (DateTimeParseException e) {
	            System.err.println("Invalid input. Please enter a date in the format dd-mm-yyyy.");
	        }
	    }
	    Date todaysDate = Date.valueOf(localDate);
	
	    System.out.println("\nThese are the the diseases in the database:");
	    List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
	    for (Disease disease : diseases) {
	        System.out.println(disease);
	    }
	
	    Integer idDisease = null;
	    while (idDisease == null) {
	        try {
	            System.out.println("\n Please enter the ID of the disease:");
	            idDisease = Integer.parseInt(r.readLine());
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid input. Please enter a number.");
	        }
	    }
	    Disease disease = diseaseMan.getDisease(idDisease);
	
	    System.out.println("\nThese are the the medical records in the database:");
	    List<Medical_Record> medical_Records = medicalRecordMan.listMedicalRecords();
	    for (Medical_Record medicalR : medical_Records) {
	        System.out.println(medicalR + " " + medicalR.getPatient().getNamePatient() + " " + medicalR.getPatient().getSurname() + " " + medicalR.getPatient().getDob());
	    }
	
	    Integer idMedicalRecord = null;
	    while (idMedicalRecord == null) {
	        try {
	            System.out.println("Please select the ID of the Medical_Record:");
	            idMedicalRecord = Integer.parseInt(r.readLine());
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid input. Please enter a number.");
	        }
	    }
	    Medical_Record medicalRecord = medicalRecordMan.getMedical_Record(idMedicalRecord);
	
	    System.out.println("Comments: ");
	    String comment_section = r.readLine();
	
	    Diagnosis diagnosis = new Diagnosis(name, todaysDate, comment_section, medicalRecord, disease);
	    diagnosisMan.addDiagnosis(diagnosis);
	}

	
	/**
	 * Method to add a new symptom
	 * 
	 * @throws IOException
	 */
	private static void addSymptom() throws IOException{
		System.out.println("Please write the symptom info");
		System.out.println("Its name:");
		String name = r.readLine();
		System.out.println("Its pain level (MILD/SEVERE):");
		String pain_Management =  r.readLine();
	    if (!pain_Management.equalsIgnoreCase("mild") && !pain_Management.equalsIgnoreCase("severe")) {
	        throw new IllegalArgumentException("Invalid pain level. Please enter either MILD or SEVERE.");
	    }
		
		Symptom symptom = new Symptom(name, pain_Management);
		symptomMan.addSymptom(symptom);
	}
	
	/**
	 * Method to add a new treatment
	 * 
	 * @throws IOException
	 */
	private static void addTreatment() throws IOException{
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
	 * @throws IOException
	 */
	private static void modifyTreatment() throws IOException {
	    System.out.println("\nThese are the the treatments in the database:");
	    List<Treatment> treatments = treatmentMan.listMatchingTreatmentsByName("");
	    for (Treatment treatment : treatments) {
	        System.out.println(treatment);
	    }
	
	    Integer id = null;
	    String lineRead;
	    while (id == null) {
	        try {
	            System.out.println("\nPlease enter the ID of the treatment you wish to modify:");
	            lineRead = r.readLine();
	            if (!lineRead.isEmpty()) {
	                id = Integer.parseInt(lineRead);
	            } else {
	                break;
	            }
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid input. Please enter a number.");
	        }
	    }
	    Treatment treatment = treatmentMan.getTreatment(id);
	
	    System.out.println("Here are the actual Treatment's values");
	    System.out.println("Press enter to keep them or type a new value.");
	    System.out.println("Name (" + treatment.getNameTreatment() + "): ");
	    String newName = r.readLine();
	    System.out.println("Comments (" + treatment.getComment_Section() + "): ");
	    String newComments = r.readLine();
	    if (!newName.isEmpty()) {
	        // If I don't keep
	        treatment.setNameTreatment(newName);
	    }
	    if (!newComments.isEmpty()) { // If I don't keep
	        treatment.setComment_Section(newComments);
	    }
	
	    treatmentMan.modifyTreatment(treatment);
	}


	
	/**
	 * Method to delete a treatment
	 * 
	 * @throws IOException
	 */
	private static void deleteTreatment() throws IOException {
	    System.out.println("These are the treatments in the database:");
	    List<Treatment> treatments = treatmentMan.listMatchingTreatmentsByName("");
	    for(Treatment treatment : treatments) {
	        System.out.println(treatment);
	    }
	
	    Integer id = null;
	    while (id == null) {
	        try {
	            System.out.println("\n Please enter the id of the Treatment you want to delete:");
	            id = Integer.parseInt(r.readLine());
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid input. Please enter a number.");
	        }
	    }
	    treatmentMan.deleteTreatment(id);
	}

	
	/**
	 * Method to search a treatment by its name
	 * 
	 * @throws IOException
	 */
	private static void searchTreatmentByName() throws IOException{
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
	 * @throws IOException
	 */
	private static void updateDisease() throws IOException {
	    System.out.println("\nThese are the the diseases in the database:");
	    List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
	    for (Disease disease : diseases) {
	        System.out.println(disease);
	    }
	
	    Integer id = null;
	    while (id == null) {
	        try {
	            System.out.println("\n Please enter the ID of the disease you wish to modify:");
	            id = Integer.parseInt(r.readLine());
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid input. Please enter a number.");
	        }
	    }
	    Disease disease = diseaseMan.getDisease(id);
	
	    System.out.println("Press enter to keep them or type a new value.");
	    System.out.println("Name (" + disease.getNameDisease() + "): ");
	    String newName = r.readLine();
	
	    String input;
	    Float newInfectiousRate = null;
	    while (newInfectiousRate == null) {
	        System.out.println("Infectious Rate ("+ disease.getInfectious_rate() +"): ");
	        input = r.readLine();
	        if (!input.isEmpty()) {
	            try {
	                newInfectiousRate = Float.parseFloat(input);
	            } catch (NumberFormatException e) {
	                System.err.println("Invalid input. Please enter a float number.");
	            }
	        } else {
	            break;
	        }
	    }
	
	    Float newMortalityRate = null;
	    while (newMortalityRate == null) {
	        System.out.println("Mortality Rate ("+ disease.getMortality_rate() +"): ");
	        input = r.readLine();
	        if (!input.isEmpty()) {
	            try {
	                newMortalityRate = Float.parseFloat(input);
	            } catch (NumberFormatException e) {
	                System.err.println("Invalid input. Please enter a float number.");
	            }
	        } else {
	            break;
	        }
	    }
	
	    Float newIncubationPeriod = null;
	    while (newIncubationPeriod == null) {
	        System.out.println("Incubation Period ("+ disease.getIncubation_period() +"): ");
	        input = r.readLine();
	        if (!input.isEmpty()) {
	            try {
	                newIncubationPeriod = Float.parseFloat(input);
	            } catch (NumberFormatException e) {
	                System.err.println("Invalid input. Please enter a float number.");
	            }
	        } else {
	            break;
	        }
	    }
	
	    Float newDevelopmentPeriod = null;
	    while (newDevelopmentPeriod == null) {
	        System.out.println("Development Period ("+ disease.getDevelopment_period() +"): ");
	        input = r.readLine();
	        if (!input.isEmpty()) {
	            try {
	                newDevelopmentPeriod = Float.parseFloat(input);
	            } catch (NumberFormatException e) {
	                System.err.println("Invalid input. Please enter a float number.");
	            }
	        } else {
	            break;
	        }
	    }
	
	    Float newConvalescencePeriod = null;
	    while (newConvalescencePeriod == null) {
	        System.out.println("Convalescence Period ("+ disease.getConvalescence_period() +"): ");
	        input = r.readLine();
	        if (!input.isEmpty()) {
	            try {
	                newConvalescencePeriod = Float.parseFloat(input);
	            } catch (NumberFormatException e) {
	                System.err.println("Invalid input. Please enter a float number.");
	            }
	        } else {
	            break;
	        }
	    }
	
	    System.out.println("Cause ("+ disease.getCause().name() +"): ");
	    String cause = r.readLine();
	    if (!cause.equalsIgnoreCase("VIRUS") && !cause.equalsIgnoreCase("BACTERIA")) {
	        throw new IllegalArgumentException("Invalid cause. Please enter either VIRUS or BACTERIA.");
	    }
	    System.out.println("Comments (" + disease.getComment_section() + "): ");
	    String newComments = r.readLine();
	
	    if (!newName.isEmpty()) {
	        disease.setNameDisease(newName);
	    }
	    if (newInfectiousRate != null) {
	        disease.setInfectious_rate(newInfectiousRate);
	    }
	    if (newMortalityRate != null) {
	        disease.setMortality_rate(newMortalityRate);
	    }
	    if (newIncubationPeriod != null) {
	        disease.setIncubation_period(newIncubationPeriod);
	    }
	    if (newDevelopmentPeriod != null) {
	        disease.setDevelopment_period(newDevelopmentPeriod);
	    }
	    if (newConvalescencePeriod != null) {
	        disease.setConvalescence_period(newConvalescencePeriod);
	    }
	    if (!cause.isEmpty()) {
	        Cause newCause = Cause.valueOf(cause);
	        disease.setCause(newCause);
	    }
	    if (!newComments.isEmpty()) {
	        disease.setComment_section(newComments);
	    }
	
	    diseaseMan.modifyDisease(disease);
	}



	/**
	 * Method to delete a disease
	 * 
	 * @throws IOException
	 */
	private static void deleteDisease() throws IOException{
		System.out.println("These are the Diseases in the database:");
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
		for(Disease disease : diseases) {
			System.out.println(disease);
		}
	
	    Integer id = null;
	    while (id == null) {
	        try {
	            System.out.println("\n Please enter the id of the Disease you want to delete:");
	            id = Integer.parseInt(r.readLine());
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid input. Please enter a number.");
	        }
	    }
		diseaseMan.deleteDisease(id);
	}
	
	/**
	 * Method to add a new symptom by disease
	 * 
	 * @throws IOException
	 */
	private static void newSymptomByDisease(Disease disease) throws IOException {
	    System.out.println("\nThese are the symptoms in the database: ");
	    List<Symptom> symptoms = symptomMan.listMatchingSymptomsByName("");
	    for(Symptom symptom : symptoms) {
	        System.out.println(symptom);
	    }
	    Integer id = null;
	    String input;
	    do {
	        System.out.println("\nPlease enter the ID of the symptom you want to add (type END to finish): ");
	        input = r.readLine();
	        if (input.equalsIgnoreCase("END")) {
	            break;
	        }
	        try {
	            id = Integer.parseInt(input);
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid number.");
	            continue;
	        }
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
	 * @throws IOException
	 */
	private static void newTreatmentByDisease(Disease disease) throws IOException {
	    System.out.println("\nThese are the treatments in the database: ");
	    List<Treatment> treatments = treatmentMan.listMatchingTreatmentsByName("");
	    for(Treatment treatment : treatments) {
	        System.out.println(treatment);
	    }
	    Integer id;
	    String input;
	    do {
	        System.out.println("\nPlease enter the ID of the treatment you want to add (type END to finish): ");
	        input = r.readLine();
	        if (input.equalsIgnoreCase("END")) {
	            break;
	        }
	        try {
	            id = Integer.parseInt(input);
	            Treatment treatment = treatmentMan.getTreatment(id);
	            if (treatment != null) {
	                treatmentMan.addTreatmentByDisease(disease, treatment);
	            } else {
	                System.out.println("Invalid treatment ID. Please try again.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid number.");
	        }
	    } while (true);
	}

	
	/**
	 * Method to add a new treatment by diagnosis
	 * 
	 * @throws IOException
	 */
	private static void newTreatmentByDiagnosis() throws IOException {
	    System.out.println("These are the diagnoses in the database: ");
	    List<Diagnosis> diagnoses = diagnosisMan.listAllDiagnosis();
	    for (Diagnosis diagnosis : diagnoses) {
	        System.out.println(diagnosis);
	    }
	    Integer diagnosisID;
	    String input;
	    do {
	        System.out.println("\nPlease enter the ID of the diagnosis you want to add treatments to (type END to finish): ");
	        input = r.readLine();
	        if (input.equalsIgnoreCase("END")) {
	            break;
	        }
	        try {
	            diagnosisID = Integer.parseInt(input);
	            Diagnosis diagnosis = diagnosisMan.getDiagnosis(diagnosisID);
	            Disease disease = diagnosis.getDisease();
	            System.out.println("\nThese are the treatments in the database belonging to the disease diagnosed: ");
	            List<Treatment> treatments = treatmentMan.getTreatmentsByDisease(disease);
	            for(Treatment treatment : treatments) {
	                System.out.println(treatment);
	            }
	            Integer id;
	            do {
	                System.out.println("\nPlease enter the ID of the treatment you want to add (type END to finish): ");
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
	            } while (true);
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid number.");
	        }
	    } while (true);
	}

	
	
	/**
	 * Method to search a treatment by disease
	 * 
	 * @throws IOException
	 */
	private static void searchTreatmentByDisease() throws IOException{
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

		System.out.println("These are the diseases in the database: ");
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
		for (Disease disease : diseases) {
		    System.out.println(disease);
		}
		System.out.println("\nPlease enter the IDs of the diseases you wish to search, type END to finish");
		List<Integer> diseaseIds = new ArrayList<>();
		String lineread;
		while (!(lineread = r.readLine()).equalsIgnoreCase("end")) {
		    try {
		        diseaseIds.add(Integer.parseInt(lineread));
		    } catch (NumberFormatException e) {
		        System.out.println("Invalid input. Please enter a valid number.");
		    }
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
	 * @throws IOException
	 */
	private static void searchTreatmentByDiagnosis() throws IOException {
	    System.out.println("These are the diagnosis in the database:");
	    List<Diagnosis> diagnoses1 = diagnosisMan.listAllDiagnosis();
	    for (Diagnosis diagnosis : diagnoses1) {
	        System.out.println("\n"+diagnosis.getIdDiagnosis() + "   " + diagnosis.getNameDiagnosis() + "   " + diagnosis.getLocalDate() + "   " + diagnosis.getComment_section() + "   " + diagnosis.getDisease().getNameDisease() + "  [ " + diagnosis.getMedicalRecord().getPatient().getNamePatient() + "   " + diagnosis.getMedicalRecord().getPatient().getSurname() + "   " + diagnosis.getMedicalRecord().getPatient().getDob() + " ]");
	    }
	    System.out.println("\nPlease, enter the id of the Diagnoses (type END when done):");
	    List<Integer> ids = new ArrayList<Integer>();
	    List<Diagnosis> diagnoses = new ArrayList<Diagnosis>();
	    Diagnosis diagnosis = new Diagnosis();
	    String lineread;
	    while (!(lineread = r.readLine()).equalsIgnoreCase("end")) {
	        try {
	            ids.add(Integer.parseInt(lineread));
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid number.");
	        }
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

	
	/*Method not used since a new patient when a user signs up as a patient
	 *
	 * private static void addPatient() throws NumberFormatException, IOException{
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
		
	}*/
	
	/*Nonesense method since I can basically just add the line
	 
	 * private static void createMedicalRecord(Patient patient) {
		medicalRecordMan.addMedicalRecord(patient);
	}*/
	
	/**
	 * Method to add treatments to a disease
	 * 
	 * @throws IOException
	 */
	private static void addTreatmentsToaDisease() throws IOException{
		System.out.println("These are the diseases in the database: ");
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
		for(Disease disease : diseases) {
			System.out.println(disease);
		}
		System.out.println("\nPlease insert the id of the one you wish to add treatments to:");
		Integer diseaseID = Integer.parseInt(r.readLine());
		Disease disease = diseaseMan.getDisease(diseaseID);
		
		System.out.println("\nThese are the treatments in the database: ");
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
	        try {
	            id = Integer.parseInt(input);
	            Treatment treatment = treatmentMan.getTreatment(id);
	            if (treatment != null) {
	                treatmentMan.addTreatmentByDisease(disease, treatment);
	            } else {
	                System.out.println("Invalid treatment ID. Please try again.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid number.");
	        }
	    } while (true);
	}
	
	/**
	 * This method adds existing symptoms to existing diseases in case it wasn't done in the addDisease method
	 * 
	 * @throws IOException
	 */
	private static void addSymptomsToDisease() throws IOException{
		System.out.println("These are the diseases in the database: ");
		List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
		for(Disease disease : diseases) {
			System.out.println(disease);
		}
		System.out.println("\nPlease insert the id of the one you wish to add symptoms to:");
		Integer diseaseID = Integer.parseInt(r.readLine());
		Disease disease = diseaseMan.getDisease(diseaseID);
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
	        try {
	            id = Integer.parseInt(input);
	            Symptom symptom = symptomMan.getSymptom(id);
		        if (symptom != null) {
		            diseaseMan.addSymptomByDisease(disease, symptom);
		        } else {
		            System.out.println("Invalid symptom ID. Please try again.");
		        }
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid number.");
	        }
	        
	    } while (true);
	}
	
	/**
	 * Method to list the 6 most recent diagnoses
	 */
	private static void list6recentdiagnoses() {
		String username = loggedInUser.getUsername();
		Patient patientDB = patientMan.getPatientByUsername(username);
		Integer patientID = patientDB.getIdPatient();
		List<Diagnosis> diagnoses = diagnosisMan.listSixRecentDiagnosis(patientID);
		for (Diagnosis diagnosis : diagnoses) {
			System.out.println("\n"+diagnosis);
		}
	}
	
	/**
	 * Method to search a treatment by diagnosis
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void searchTreatmentByDiagnosisPatient() throws NumberFormatException, IOException{
		System.out.println("These are your diagnoses and their respective treatments:");
		String username = loggedInUser.getUsername();
		Patient patientDB = patientMan.getPatientByUsername(username);
		Integer patientID = patientDB.getIdPatient();
		List<Diagnosis> diagnoses = diagnosisMan.listMatchinDiagnosesByPatient(patientID);
		for (Diagnosis diagnosis : diagnoses) {
			System.out.println("\n Name: "+diagnosis.getNameDiagnosis() +"   Date: "+ diagnosis.getLocalDate() + "   Disease: "+ diagnosis.getDisease().getNameDisease()+ "    Cause: "+ diagnosis.getDisease().getCause() + "   Additional Info: "+ diagnosis.getDisease().getComment_section());
			List <Treatment> treatments = treatmentMan.getTreatmentsByDiagnosis(diagnosis);
			for (Treatment treatment : treatments) {
				System.out.println("\n\t"+treatment.getNameTreatment() +"   Observations: "+ treatment.getComment_Section());
			}
		}
		
	}
	
	/**
	 * This method a researcher to search for an already existing simulation
	 * 
	 * @throws IOException
	 */
	private static void searchSimulation() throws IOException {
	    List<Virtual_Population> virtual_Populations = new ArrayList<Virtual_Population>();
	    System.out.println("\nThese are the diseases in the database: ");
	    List<Disease> diseases = diseaseMan.listMatchingDiseaseByName("");
	    for(Disease disease : diseases) {
	        System.out.println(disease);
	    }
	    System.out.println("\nPlease insert the id of the one you wish search its simulation");
	    Integer diseaseID;
	    try {
	        diseaseID = Integer.parseInt(r.readLine());
	    } catch (NumberFormatException e) {
	        System.out.println("Invalid input. Please enter a valid number.");
	        return;
	    }
	    virtual_Populations = virtualPopulationMan.listMatchingV_PopulationByDiseasease(diseaseID);
	    System.out.println("\nThe virtual populations linked to this disease are the following, please insert the ID of the one you want to search:");
	    for (Virtual_Population virtual_Population : virtual_Populations) {
	        System.out.println(virtual_Population);
	    }
	    Integer virtualPopID;
	    try {
	        virtualPopID = Integer.parseInt(r.readLine());
	    } catch (NumberFormatException e) {
	        System.out.println("Invalid input. Please enter a valid number.");
	        return;
	    }
	    List<Simulation> simulations = new ArrayList<Simulation>();
	    simulations = simulationMan.listMatchingSimulationByV_Population(virtualPopID);
	    System.out.println("\nThese are the simulations linked to this virtual population, please insert the ID of the one you wish to view:");
	    for (Simulation simulation : simulations) {
	        System.out.println(simulation);
	    }
	    Integer simulationID;
	    try {
	        simulationID = Integer.parseInt(r.readLine());
	    } catch (NumberFormatException e) {
	        System.out.println("Invalid input. Please enter a valid number.");
	        return;
	    }
	    Simulation simulation = simulationMan.selectSimulation(simulationID);
	    System.out.println("\n"+simulation);
	    GraphUtilities utilGraph = new GraphUtilities();
	    BufferedImage chartSimulationImage = utilGraph.binaryIntoImage(simulation.getSimulationGraph());
	    showImage(chartSimulationImage);
	}

	/**
	 * This method allows a user to modify some of their account info
	 * 
	 * @throws IOException
	 */
	private static void modifyUser() throws IOException {
	    User user = loggedInUser;
	    System.out.println("Press enter to keep them or type a new value.");
	    System.out.println("Name (" + user.getName() + "): ");
	    String newName = r.readLine();
	    System.out.println("Surname ("+ user.getSurname() +"): ");
	    String newLastName = r.readLine();
	    System.out.println("Phone Number ("+ user.getPhoneNumber() +"): ");
	    String newPhoneNumber =null;
	    boolean exception = true;
	    while(exception) {
	        newPhoneNumber = r.readLine();
	        if (newPhoneNumber.isEmpty()) {
	            exception = false;
	        } else {
	            try {
	                int phone = Integer.parseInt(newPhoneNumber);
	                if(phone < 1000000000 && phone > 99999999) {
	                    exception = false;
	                } else {
	                    System.err.println("Not existing phone, please introduce a correct phone");
	                }
	            } catch(NumberFormatException nfe) {
	                System.err.println("Not a number, please insert number");
	            }
	        }
	    }
	    System.out.println("Email ("+ user.getEmail() +"): ");
	    String newEmail = null;
	    exception = true;
	    while(exception) {
	        newEmail = r.readLine();
	        if (newEmail.isEmpty()) {
	            exception = false;
	        } else {
	            Pattern pattern = Pattern.compile(".*.@.*.\\..*.");
	            Matcher matcher = pattern.matcher(newEmail);
	            if(matcher.find()) {
	                exception = false;
	            } else {
	                System.err.println("Not existing email, should be x@x.x");
	            }
	        }
	    }
	    if (!newName.equals("")) {
	        user.setName(newName);
	    }
	    if (!newLastName.equals("")) {
	        user.setSurname(newLastName);
	    }
	    if (newPhoneNumber != null && !newPhoneNumber.equals("")) {
	        user.setPhoneNumber(Integer.parseInt(newPhoneNumber));
	    }
	    if (newEmail != null && !newEmail.equals("")) {
	        user.setEmail(newEmail);
	    }
	    userManager.updateUser(user);
	}

	
}
