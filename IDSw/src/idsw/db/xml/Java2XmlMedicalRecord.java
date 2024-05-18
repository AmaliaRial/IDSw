package idsw.db.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import idsw.db.jdbc.ConnectionManager;
import idsw.db.jdbcInterfaces.MedicalRecordManager;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Medical_Record;
import idsw.db.pojos.Patient;
import idsw.db.pojos.Treatment;

public class Java2XmlMedicalRecord {
	
	private static Connection c ;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ConnectionManager conMan = new ConnectionManager();
    
    public static void createXML(int record_id) {
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
    }
    
    private static void printMedicalRecords(Connection c) throws SQLException {
        String selectSQL = "SELECT * FROM medical_records";
        PreparedStatement ps = c.prepareStatement(selectSQL);
        ResultSet rs = ps.executeQuery();
        List<Medical_Record> records = new ArrayList<>();
        while (rs.next()) {
        	Integer id = rs.getInt("IDMedical_Record");
        	Integer patient_id = rs.getInt("patient");
            Medical_Record record = new Medical_Record(rs.getInt("idMedical_Record"), conMan.getPatientMan().getPatient(patient_id));
            
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
            System.out.println(record);
        }
        rs.close();
        ps.close();
    }

    public static void main(String[] args) throws Exception {
        /*// Get a connection to the database
        c = DriverManager.getConnection("jdbc:sqlite:./db/idsw.db"); // replace with your database connection string

        // Create the JAXBContext
        JAXBContext jaxbContext = JAXBContext.newInstance(Medical_Record.class);
        // Get the marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();

        // Pretty formatting
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Choose the medical record to turn into an XML
        printMedicalRecords(c);
        System.out.print("Choose a medical record to turn into an XML file:");
        int record_id = Integer.parseInt(reader.readLine());
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
        */
    	//createXML(1);
    }
}
