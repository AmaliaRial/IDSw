package idsw.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

import idsw.db.jdbc.ConnectionManager;
import idsw.db.jdbcInterfaces.DiagnosisManager;
import idsw.db.jdbcInterfaces.DiseaseManager;
import idsw.db.jdbcInterfaces.MedicalRecordManager;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Medical_Record;


public class jorge1menu {
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

	private static DiseaseManager diseaseMan;
	private static DiagnosisManager diagnosisMan;
	private static MedicalRecordManager medicalRecordMan;
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
				System.out.println("Elige que hacer");
				choice = menuPrincipal();
			switch (choice) {
				case 1: {
					addDiagnosis();
					System.out.println("Diagnosis in the data base");
					break;
				}
				case 2: {
					
					System.out.println("Select the diagnosis you what to modify");
					Diagnosis diagnosis = getDiagnosis();
					deleteDiagnosis(diagnosis);
					System.out.println("Diagnosis delete from the data base");
					break;
				}
				case 3: {
					System.out.println("Select the diagnosis you what to modify");
					Diagnosis diagnosis = getDiagnosis();	
					modifyDiagnosis(diagnosis);
					System.out.println("Diagnostico modificado");
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
		LocalDate todaysDate = LocalDate.now();
		System.out.println("comment_section");
		String comment_section = r.readLine();
		System.out.println("idDisease:");
		Integer idDisease = Integer.parseInt(r.readLine());
		Disease disease = diseaseMan.getDisease(idDisease);
		System.out.println("idMedical_Record");
		Integer idMedicalRecord = Integer.parseInt(r.readLine());
		Medical_Record medicalRecord = medicalRecordMan.getMedical_Record(idMedicalRecord);
		
		Diagnosis diagnosis = new Diagnosis(name, todaysDate, comment_section, medicalRecord, disease);
		diagnosisMan.addDiagnosis(diagnosis);
		
	}
private static Diagnosis getDiagnosis() throws NumberFormatException, IOException{
		
		System.out.println("Cual es el id del paciente:");		
		Integer idMedicalRecord = Integer.parseInt(r.readLine());
		System.out.println("These are the diagnosis in the database:");		
		List<Diagnosis> diagnoses = diagnosisMan.listAllDiagnosis();
		for(Diagnosis diagnosis : diagnoses) {
			if (diagnosis.getMedicalRecord().getIdMedical_Record() == idMedicalRecord) {
			System.out.println(diagnosis);
			} else {}
		}
		System.out.println("Please enter the id of the diagnosis");
		Integer id = Integer.parseInt(r.readLine());
		Diagnosis diagnosis1 = diagnosisMan.getDiagnosis(id);
		return diagnosis1;

		
	}
	
	
	private static void deleteDiagnosis(Diagnosis diagnosis) throws NumberFormatException, IOException{
	
		diagnosisMan.deleteDiagnosis(diagnosis.getIdDiagnosis());
	}
	
	

	private static void modifyDiagnosis(Diagnosis diagnosis)throws NumberFormatException, IOException{
		System.out.println("What do you want to modify:");
		System.out.println("1 - nameDiagnosis");
		System.out.println("2 - date");
		System.out.println("3 - comment_section");
		Boolean a = true;
		while(a) {	
			
			Integer eleccion = Integer.parseInt(r.readLine());
			if(eleccion == 1 ) {
					System.out.println("Nombre actual:" + diagnosis.getNameDiagnosis());
					System.out.println("Escribe el nuevo nombre:");
					String nameNew = r.readLine();
					diagnosis.setNameDiagnosis(nameNew);
					a = false;
			}
			if(eleccion == 2 ) {		
					LocalDate date = diagnosis.getLocalDate();
					System.out.println("Date actual:" + date );
					System.out.println("Escribe la nueva fecha YYYY-MM-DD:");
					LocalDate dateNew = LocalDate.parse(r.readLine());
					diagnosis.setLocalDate(dateNew);
					a = false;
			}
			if(eleccion == 3 ) {
					System.out.println("Comment section actual:" + diagnosis.getComment_section() );
					System.out.println("Escribe una nueva comment section");
					String comment_sectionNew = r.readLine();
					diagnosis.setComment_section(comment_sectionNew);
					a = false;
			}
			
		}
		
		diagnosisMan.modifyDiagnosis(diagnosis);
		
	}
		
	
	
	
}
