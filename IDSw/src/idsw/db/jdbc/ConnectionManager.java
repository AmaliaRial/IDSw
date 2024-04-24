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
		try {
			//DISEASE TABLE
			Statement createDiseaseTable = c.createStatement();
			String createTableDisease=" CREATE TABLE diseases(" 
					+ " IDdisease INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ " nameDisease TEXT NOT NULL,"
					+ " infectious_rate REAL NOT NULL,"
					+ " mortality_rate REAL NOT NULL,"
					+ " incubation_period REAL NOT NULL,"
					+ " development_period REAL NOT NULL,"
					+ " convalescence_period REAL NOT NULL,"
					+ " cause TEXT NOT NULL,"
					+ " comment_section TEXT);";
			
			createDiseaseTable.executeUpdate(createTableDisease);
			createDiseaseTable.close();
			
			//SYMPTOM TABLE
			Statement createSymptomTable = c.createStatement();
			String createTableSymptom= " CREATE TABLE symptoms("
					+ " IDsymptom INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ " nameSymptom TEXT NOT NULL,"
					+ " pain_management TEXT NOT NULL);";

			createSymptomTable.executeUpdate(createTableSymptom);
			createSymptomTable.close();
			
			//DISEASEhasSYMPTOMS TABLE
			Statement createDiseaseHasSymptomsTable = c.createStatement();
			String createTablediseaseHasSymptoms= " CREATE TABLE disease_has_symptoms("
					+ " disease_id INTEGER REFERENCES diseases(IDdisease) ON DELETE CASCADE,"
					+ " symptom_id INTEGER REFERENCES symptoms(IDsymptom) ON DELETE CASCADE,"
					+ " PRIMARY KEY(disease_id, symptom_id));";

			createDiseaseHasSymptomsTable.executeUpdate(createTablediseaseHasSymptoms);
			createDiseaseHasSymptomsTable.close();
			
			//PATIENTS TABLE
			Statement createPatientsTable = c.createStatement();
			String createTablePatients = " CREATE TABLE patients("
					+ "	IDpatient INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	namePatient TEXT NOT NULL,"
					+ "	surname TEXT NOT NULL,"
					+ "	DoB DATE NOT NULL);";
			createPatientsTable.executeUpdate(createTablePatients);
			createPatientsTable.close();
			
			//MEDICAL RECORDS TABLE
			Statement createMedicalRecordsTable = c.createStatement();
			String createTableMedicalRecords = " CREATE TABLE medical_records ("
					+ "	IDmedical_record INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	patient INTEGER REFERENCES patients(IDpatient));";
			createMedicalRecordsTable.executeUpdate(createTableMedicalRecords);
			createMedicalRecordsTable.close();
			
			//DIAGNOSIS TABLE
			Statement createDiagnosisTable = c.createStatement();
			String createTableDiag=" CREATE TABLE diagnoses ("
					+ "	IDdiagnosis INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	nameDiagnosis TEXT NOT NULL,"
					+ "	date CURRENT DATE;"
					+ " comment_section TEXT,"
					+ "	disease_id INTEGER REFERENCES diseases(IDdisease),"
					+ "	medicalRecord_id INTEGER REFERENCES medical_records(IDmedical_record));";
			createDiagnosisTable.executeUpdate(createTableDiag);
			createDiagnosisTable.close();		
			
			//TREATMENTS TABLE
			Statement createTreatmentsTable = c.createStatement();
			String createTableTreatments = " CREATE TABLE treatments ("
					+ " IDtreatment INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ " nameTreatment TEXT NOT NULL,"
					+ " comment_section TEXT,"
					+ " diagnosis_id INTEGER REFERENCES diagnoses(IDdiagnosis));";
			
			createTreatmentsTable.executeUpdate(createTableTreatments);
			createTreatmentsTable.close();
			
			//DISEASEhasTREATMENTS TABLE
			Statement createDiseaseHasTreatmentsTable = c.createStatement();
			String createTableDiseaseHasTreatments = " CREATE TABLE disease_has_treatments ("
					+ " disease_id INTEGER REFERENCES diseases(IDdisease) ON DELETE CASCADE,"
					+ "	treatment_id INTEGER REFERENCES treatments(IDtreatment) ON DELETE CASCADE,"
					+ "	PRIMARY KEY (disease_id, treatment_id));";
			
			createDiseaseHasTreatmentsTable.executeUpdate(createTableDiseaseHasTreatments);
			createDiseaseHasTreatmentsTable.close();
			
			//DIAGNOSIS HAS TREATMENTS TABLE
			Statement createDiagnosisHasTreatmentsTable = c.createStatement();
			String createTableDiagnosisHasTreatments = "CREATE TABLE diagnosis_has_treatments ("
					+ "	diagnosis_id INTEGER REFERENCES diagnoses(IDdiagnosis) ON DELETE CASCADE,"
					+ "	treatment_id INTEGER REFERENCES treatments(IDtreatment) ON DELETE CASCADE,"
					+ "	PRIMARY KEY (diagnosis_id, treatment_id));";
			
			createDiagnosisHasTreatmentsTable.executeUpdate(createTableDiagnosisHasTreatments);
			createDiagnosisHasTreatmentsTable.close();
			
			//VIRTUAL POPULATION TABLE
			Statement createVirtualPopulationsTable = c.createStatement();
			String createTableVirtualPopulations = " CREATE TABLE virtual_populations ("
					+ "	idVirtual_population INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ " Initial_population INTEGER  NOT NULL,"
					+ "	p_infected REAL NOT NULL,"
					+ "	p_healthy REAL NOT NULL,"
					+ "	p_immune REAL NOT NULL,"
					+ "	Immunity_period INTEGER,"
					+ "	disease_id INTEGER REFERENCES diseases(IDdisease));";
			
			createVirtualPopulationsTable.executeUpdate(createTableVirtualPopulations);
			createVirtualPopulationsTable.close();
			
			//VIRTUAL PERSONS TABLE
			Statement createVirtualPersonsTable = c.createStatement();
			String createTableVirtualPersons = " CREATE TABLE virtual_persons ("
					+ "	IDvirtual_person INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	state TEXT NOT NULL, "
					+ "	disease_countdown REAL NOT NULL,"
					+ "	immunity_countdown REAL,"
					+ "	virtual_population INTEGER REFERENCES virtual_populations(idVirtual_population));";
			
			createVirtualPersonsTable.executeUpdate(createTableVirtualPersons);
			createVirtualPersonsTable.close();
			
			//SIMULATIONS TABLE
			Statement createSimulationsTable = c.createStatement();
			String createTableSimulations = "CREATE TABLE simulations ("
					+ "	IDsimulation INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	totalInfections INTEGER NOT NULL,"
					+ "	totalDeaths INTEGER NOT NULL,"
					+ "	totalImmunity INTEGER,"
					+ "	totalPopulation INTEGER NOT NULL,"
					+ "	simulationGraph BLOB NOT NULL,"
					+ "	virtual_population INTEGER REFERENCES virtual_populations(idVirtual_population));";
			
			createSimulationsTable.executeUpdate(createTableSimulations);
			createSimulationsTable.close();
			
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
