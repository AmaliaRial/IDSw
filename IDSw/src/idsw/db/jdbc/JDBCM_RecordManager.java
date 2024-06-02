package idsw.db.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import idsw.db.jdbcInterfaces.MedicalRecordManager;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Medical_Record;
import idsw.db.pojos.Patient;
import idsw.db.pojos.Treatment;

public class JDBCM_RecordManager implements MedicalRecordManager {
	
	private Connection c;
	private ConnectionManager conMan;
	
	public JDBCM_RecordManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	//En el get tendria q enseñar los medical records
	@Override
	public Medical_Record getMedical_Record(int idMedical_record) {
		Medical_Record medical_record = null;
		try {
			String sql = "SELECT * FROM medical_records WHERE IDmedical_record = " + idMedical_record;
			Statement st;
			st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			medical_record = new Medical_Record(idMedical_record, conMan.getPatientMan().getPatient(rs.getInt("patient")));
			return medical_record;
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}		
		return medical_record;
	}
	

	@Override
	public void addMedicalRecord(Patient patient) {
		try {
			String template = "INSERT INTO medical_records (patient) VALUES (?);";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setInt(1, patient.getIdPatient());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}

	}
	


	@Override
	public List<Medical_Record> listMedicalRecords() {
		List<Medical_Record> medical_records = new ArrayList<Medical_Record>();
		try {
			String sql = "SELECT * FROM medical_records";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			ResultSet rs= p.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("IDmedical_record");
				Integer patient_id = rs.getInt("patient");
                Medical_Record medical_record = new Medical_Record(id, conMan.getPatientMan().getPatient(patient_id));
				medical_records.add(medical_record);
			}
				rs.close();
				p.close();
			} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		return medical_records;
	}

	
	@Override
	public List<Medical_Record> printMedicalRecords() {
		List<Medical_Record> records = new ArrayList<>();
		try {
		String selectSQL = "SELECT * FROM medical_records";
        PreparedStatement ps = c.prepareStatement(selectSQL);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
        	Integer id;
        	Integer patient_id = rs.getInt("patient");
            Medical_Record record = new Medical_Record(rs.getInt("idMedical_Record"), conMan.getPatientMan().getPatient(patient_id));
            
         // Fetch the diagnoses for the current medical record
            String selectDiagnosesSQL = "SELECT * FROM diagnoses WHERE medicalRecord_id = ?";
            PreparedStatement psDiagnoses = c.prepareStatement(selectDiagnosesSQL);
            psDiagnoses.setInt(1, record.getIdMedical_Record());
            ResultSet rsDiagnoses = psDiagnoses.executeQuery();
            List<Diagnosis> diagnoses = new ArrayList<>();
            while (rsDiagnoses.next()) {
				Integer idDiag = rsDiagnoses.getInt("IDdiagnosis");
				String name = rsDiagnoses.getString("nameDiagnosis");
				Date date = rsDiagnoses.getDate("date");
				String comments = rsDiagnoses.getString("comment_section");
				Integer idDisease = rsDiagnoses.getInt("disease_id");
				Disease disease = conMan.getDiseaseMan().getDisease(idDisease);
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
            
            records.add(record);
            
        }
        rs.close();
        ps.close();
        }catch (SQLException e) {
        	System.out.println("Error in the database");
			e.printStackTrace();
		}
        
        return records;
	}
	
	
}
