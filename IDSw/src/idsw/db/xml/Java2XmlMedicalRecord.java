package idsw.db.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import idsw.db.jdbc.ConnectionManager;
import idsw.db.jdbcInterfaces.MedicalRecordManager;
import idsw.db.pojos.Medical_Record;
import idsw.db.pojos.Patient;

public class Java2XmlMedicalRecord {
	
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ConnectionManager conMan = new ConnectionManager();
    
    private static void printMedicalRecords(Connection c) throws SQLException {
        String selectSQL = "SELECT * FROM medical_records";
        PreparedStatement ps = c.prepareStatement(selectSQL);
        ResultSet rs = ps.executeQuery();
        List<Medical_Record> records = new ArrayList<>();
        while (rs.next()) {
        	Integer id = rs.getInt("IDMedical_Record");
        	Integer patient_id = rs.getInt("patient");
            Medical_Record record = new Medical_Record(rs.getInt("idMedical_Record"), conMan.getPatientMan().getPatient(patient_id));
            records.add(record);
            System.out.println(record);
        }
        rs.close();
        ps.close();
    }

    public static void main(String[] args) throws Exception {
        // Get a connection to the database
        Connection conn = DriverManager.getConnection("jdbc:sqlite:./db/idsw.db"); // replace with your database connection string

        // Create the JAXBContext
        JAXBContext jaxbContext = JAXBContext.newInstance(Medical_Record.class);
        // Get the marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();

        // Pretty formatting
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Choose the medical record to turn into an XML
        printMedicalRecords(conn);
        System.out.print("Choose a medical record to turn into an XML file:");
        int record_id = Integer.parseInt(reader.readLine());
        String selectSQL = "SELECT * FROM medical_records WHERE idMedical_Record = ?";
        PreparedStatement ps = conn.prepareStatement(selectSQL);
        ps.setInt(1, record_id);
        ResultSet rs = ps.executeQuery();
        Medical_Record record = null;
        if (rs.next()) {
            record = new Medical_Record(rs.getInt("idMedical_Record"), conMan.getPatientMan().getPatient(rs.getInt("patient")));
        }

        // Use the Marshaller to marshal the Java object to a file
        File file = new File("./xmls/Sample-MedicalRecord.xml");
        marshaller.marshal(record, file);
        // Printout
        marshaller.marshal(record, System.out);
    }
}
