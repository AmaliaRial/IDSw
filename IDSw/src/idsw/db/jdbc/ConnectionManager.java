package idsw.db.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import idsw.db.jdbcInterfaces.*;



public class ConnectionManager {
	private Connection c;
	private DiagnosisManager diagnosisMan;
	private DiseaseManager diseaseMan;
	private MedicalRecordManager medicalRecordMan;
	private PatientManager patientMan;
	private SimulationManager simulationMan;
	private SymptomManager symptomMan;
	private TreatmentManager treatmentMan;
	private VirtualPersonManager virtualPersonMan;
	private VirtualPopulationManager virtualPopulationMan;
	
	public Connection getConnection() {
		return c;
		
	}
	
	

	public ConnectionManager() {
		this.connect();
		this.diagnosisMan= new JDBCDiagnosisManager(this);
		this.diseaseMan= new JDBCDiseaseManager(this);
		this.medicalRecordMan= new JDBCM_RecordManager(this);
		this.patientMan= new JDBCPatientManager(this);
		this.simulationMan=new JDBCSimulationManager(this);
		this.symptomMan= new JDBCSymptomManager(this);
		this.treatmentMan= new JDBCTreatmentManager(this);
		this.virtualPersonMan= new JDBCV_PersonManager(this);
		this.virtualPopulationMan = new JDBCV_PopulationManager(this);
		this.createTables();
	}
	
	private void connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./db/idsw.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
		} catch (ClassNotFoundException cnfE) {
			System.out.println("Databases libraries not loaded");
			cnfE.printStackTrace();
		} catch (SQLException sqlE) {
			System.out.println("Error with database");
			sqlE.printStackTrace();
		}
	}


	public void close() {
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println("Error closing the database");
			e.printStackTrace();
		}
	}
	
	
	private void createTables() {
		//TODO create table method
		try {
			//DISEASE TABLE
			Statement createDiseaseTable = c.createStatement();
			String createTableDisease="CREATE TABLE diseases(" 
					+ " IDdisease INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ " nameDisease TEXT NOT NULL,"
					+ " infectious_rate REAL NOT NULL,"
					+ " mortality_rate REAL NOT NULL,"
					+ " incubation_period REAL NOT NULL,"
					+ " development_period REAL NOT NULL,"
					+ " convalescence_period REAL NOT NULL,"
					+ " cause INTEGER NOT NULL,"
					+ " comment_section TEXT);";
			
			createDiseaseTable.executeUpdate(createTableDisease);
			createDiseaseTable.close();
			
			//SYMPTOM TABLE
			Statement createSymptomTable = c.createStatement();
			String createTableSymptom= "CREATE TABLE symptoms("
					+ "IDsymptom INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "nameSymptom TEXT NOT NULL,"
					+ "pain_management INTEGER NOT NULL);";

			createSymptomTable.executeUpdate(createTableSymptom);
			createSymptomTable.close();
			
			//DISEASEhASSYMPTOMS TABLE
			Statement createDiseaseHasSymptomsTable = c.createStatement();
			String createTablediseaseHasSymptoms= "CREATE TABLE disease_has_symptoms("
					+ "disease_id INTEGER REFERENCES disease(IDdisease) ON DELETE CASCADE,"
					+ "symptom_id INTEGER REFERENCES symptom(IDsymptom) ON DELETE CASCADE,"
					+ "PRIMARY KEY(disease_id, symtom_id));\r\n";

			createDiseaseHasSymptomsTable.executeUpdate(createTablediseaseHasSymptoms);
			createDiseaseHasSymptomsTable.close();
			
			//DIAGNOSIS TABLE
			Statement createDiagnosisTable = c.createStatement();
			String createTableDiag="CREATE TABLE diagnoses("
					+ "	IDdiagnosis INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	nameDiagnosis TEXT NOT NULL,"
					+ "	date CURRENT DATE;"
					+ " comment_section TEXT;"
					+ "	disease_id INTEGER REFERENCES disease(IDdisease),"
					+ "	medicalRecord_id INTEGER REFERENCES medical_record(IDmedical_record));";
			createDiagnosisTable.executeUpdate(createTableDiag);
			createDiagnosisTable.close();		
		}catch (SQLException sqlE) {
			if (sqlE.getMessage().contains("already exist")){
				System.out.println("No need to create the tables; already there");
			}
			else {
				System.out.println("Error in query");
				sqlE.printStackTrace();
			}
		}
	}
	

	public DiagnosisManager getDiagnosisMan() {
		return diagnosisMan;
	}

	public DiseaseManager getDiseaseMan() {
		return diseaseMan;
	}

	public MedicalRecordManager getMedicalRecordMan() {
		return medicalRecordMan;
	}

	public PatientManager getPatientMan() {
		return patientMan;
	}

	public SimulationManager getSimulationMan() {
		return simulationMan;
	}

	public SymptomManager getSymptomMan() {
		return symptomMan;
	}

	public TreatmentManager getTreatmentMan() {
		return treatmentMan;
	}

	public VirtualPersonManager getVirtualPersonMan() {
		return virtualPersonMan;
	}

	public VirtualPopulationManager getVirtualPopulationMan() {
		return virtualPopulationMan;
	}
	
	
	
	
	

}
