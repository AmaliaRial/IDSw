package idsw.db.xml;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import idsw.db.jdbc.ConnectionManager;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Medical_Record;
import idsw.db.pojos.Patient;

public class Xml2JavaMedicalRecord {
	
    private static final String DB_URL = "jdbc:sqlite:./db/idsw.db";
    private static Connection c;
    private static ConnectionManager conMan;

    public static void main(String[] args) throws JAXBException, SQLException {
    	
    	conMan = new ConnectionManager();
        // Create the JAXBContext
        JAXBContext jaxbContext = JAXBContext.newInstance(Medical_Record.class);
        // Get the unmarshaller
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        // Use the Unmarshaller to unmarshal the XML document from a file
        File file = new File("./xmls/External-MedicalRecord.xml");
        Medical_Record record = (Medical_Record) unmarshaller.unmarshal(file);

        // Print the medical record
        System.out.println("Medical Record:");
        Patient patient = record.getPatient();
        System.out.println("Patient: " + patient.getNamePatient() +" " +patient.getSurname());
        System.out.println("Diagnoses: " + record.getDiagnoses());

        // Store the medical record in the database
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            conn.setAutoCommit(false);

            // Persist
            // We assume the patient is not already in the database
            // In a real world, we should check if they already exist
            // and update them instead of inserting as new
            
            // Check if the patient already exists in the database
            String checkPatientSQL = "SELECT * FROM patients WHERE username = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(checkPatientSQL)) {
                pstmt.setString(1, patient.getUsername());
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    // The patient already exists, update it from the Record
                    try (PreparedStatement pstmtUpdate = conn.prepareStatement("UPDATE patients SET namePatient = ?, surname = ?, dob = ? WHERE username = ?")) {
                        pstmtUpdate.setString(1, patient.getNamePatient());
                        pstmtUpdate.setString(2, patient.getSurname());
                        pstmtUpdate.setDate(3, patient.getDob());
                        pstmtUpdate.setString(4, patient.getUsername());
                        pstmtUpdate.executeUpdate();
                        pstmtUpdate.close();
                    }				
                } else {
                    // The patient does not exist, insert a new patient
                    String insertPatientSQL = "INSERT INTO patients(namePatient, surname, username, dob) VALUES(?,?,?,?)";
                    try (PreparedStatement pstmtInsert = conn.prepareStatement(insertPatientSQL)) {
                        pstmtInsert.setString(1, patient.getNamePatient());
                        pstmtInsert.setString(2, patient.getSurname());
                        pstmtInsert.setString(3, patient.getUsername());
                        pstmtInsert.setDate(4, patient.getDob());
                        pstmtInsert.executeUpdate();
                        pstmtInsert.close();
                    }
                    
                }
            }

            String insertRecordSQL = "INSERT INTO medical_records (patient) VALUES(?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertRecordSQL)) {
                pstmt.setInt(1, patient.getIdPatient());
                pstmt.executeUpdate();
                pstmt.close();
            }
            //Get the ID of the last inserted medical record
            Integer lastId = conMan.getLastInsertedID();
			record.setIdMedical_Record(lastId);            
            String insertDiagnosisSQL = "INSERT INTO diagnoses (nameDiagnosis, date, comment_section, disease_id, medicalrecord_id) VALUES(?,?,?,?,?)";
			try (PreparedStatement pstmt = conn.prepareStatement(insertDiagnosisSQL)) {
				for (Diagnosis diagnosis : record.getDiagnoses()) {
					pstmt.setString(1, diagnosis.getNameDiagnosis());
					pstmt.setDate(2, diagnosis.getLocalDate());
					pstmt.setString(3, diagnosis.getComment_section());
					pstmt.setInt(4, diagnosis.getDisease().getIdDisease());
					pstmt.setInt(5, record.getIdMedical_Record());
					pstmt.executeUpdate();
				}
				pstmt.close();
			}

            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
