package idsw.db.xml;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import idsw.db.pojos.Medical_Record;
import idsw.db.pojos.Patient;

public class Xml2JavaMedicalRecord {
	
    private static final String DB_URL = "jdbc:sqlite:./db/idsw.db";

    public static void main(String[] args) throws JAXBException, SQLException {
        // Create the JAXBContext
        JAXBContext jaxbContext = JAXBContext.newInstance(Medical_Record.class);
        // Get the unmarshaller
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        // Use the Unmarshaller to unmarshal the XML document from a file
        File file = new File("./xmls/External-MedicalRecord.xml");
        Medical_Record record = (Medical_Record) unmarshaller.unmarshal(file);

        // Print the medical record
        System.out.println("Medical Record:");
        System.out.println("ID: " + record.getIdMedical_Record());
        Patient patient = record.getPatient();
        System.out.println("Patient: " + patient.getNamePatient() + patient.getSurname());
        //System.out.println("Diagnoses: ");

        // Store the medical record in the database
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            conn.setAutoCommit(false);

            // Persist
            // We assume the patient is not already in the database
            // In a real world, we should check if they already exist
            // and update them instead of inserting as new
            String insertPatientSQL = "INSERT INTO patients(namePatient, surname, username, dob) VALUES(?,?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertPatientSQL)) {
                pstmt.setString(1, patient.getNamePatient());
                pstmt.setString(2, patient.getSurname());
                pstmt.setString(3, patient.getUsername());
                pstmt.setDate(4, patient.getDob());
                pstmt.executeUpdate();
                pstmt.close();
            }

            String insertRecordSQL = "INSERT INTO medical_records (patient_id) VALUES(?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertRecordSQL)) {
                pstmt.setInt(2, patient.getIdPatient());
                pstmt.executeUpdate();
                pstmt.close();
            }

            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
