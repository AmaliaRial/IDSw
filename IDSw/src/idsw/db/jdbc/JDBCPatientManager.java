package idsw.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import idsw.db.jdbcInterfaces.PatientManager;
import idsw.db.pojos.Patient;
import idsw.db.pojos.Symptom;
import idsw.db.pojos.Treatment;

public class JDBCPatientManager implements PatientManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCPatientManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public Patient getPatient(int patient_id) {
		try {
			String sql = "SELECT * FROM patients WHERE IDpatient = " + patient_id;
			Statement st;
			st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			Patient patient = new Patient(rs.getInt("IDpatient"), rs.getString("namePatient"), rs.getString("surname"), rs.getDate("DoB"));
			return patient;
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}		return null;
	}

	@Override
	public void addPatient(Patient patient) {
		try {
			String template = "INSERT INTO patients (namePatient, surname, username, DoB) VALUES (?, ?, ?, ?);";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setString(1, patient.getNamePatient());
			ps.setString(2, patient.getSurname());
			ps.setString(3, patient.getUsername());
			ps.setDate(4, patient.getDob());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void modifyPatient(Patient patient) {
		try {
			String template = "UPDATE patients SET namePatient = ?, surname = ?, doB = ? WHERE IDpatient = ?;";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setString(1, patient.getNamePatient());
			ps.setString(2, patient.getSurname());
			ps.setDate(3,patient.getDob());
			ps.setInt(3,patient.getIdPatient());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		
	}
}
