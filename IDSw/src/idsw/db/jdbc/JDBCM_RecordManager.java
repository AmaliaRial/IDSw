package idsw.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import idsw.db.jdbcInterfaces.MedicalRecordManager;
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
			medical_record = new Medical_Record(idMedical_record, conMan.getPatientMan().getPatient(rs.getInt("IDpatient")));
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
	public void modifyMedical_Record(int idMedical_record) {
		//se puede modificar el medical record?
	}
}
