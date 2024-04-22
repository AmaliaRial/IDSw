package idsw.db.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

	}


	private void createTables() {
		//TODO create table method
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
