package idsw.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public List<Patient> listMatchingPatientByName(String search) {
		List<Patient> patients = new ArrayList<Patient>();
		try {
			String sql = "SELECT * FROM patients WHERE namePatient LIKE ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, "%" + search + "%");
			ResultSet rs= p.executeQuery();
			while(rs.next()) {
				Patient patient = new Patient(rs.getInt("IDpatient"), rs.getString("namePatient"), rs.getString("surname"),rs.getString("username"), rs.getDate("DoB"));
				patients.add(patient);
			}
			rs.close();
			p.close();
		}catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		return patients;
	}

	@Override
	public Patient getPatient(int patient_id) {
		try {
			String sql = "SELECT * FROM patients WHERE IDpatient = " + patient_id;
			Statement st;
			st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			Patient patient = new Patient(rs.getInt("IDpatient"), rs.getString("namePatient"), rs.getString("surname"),rs.getString("username"), rs.getDate("DoB"));
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
			ps.setInt(4,patient.getIdPatient());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		
	}
}
