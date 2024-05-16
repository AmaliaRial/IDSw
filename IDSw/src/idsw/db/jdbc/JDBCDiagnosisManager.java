package idsw.db.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import idsw.db.jdbcInterfaces.DiagnosisManager;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Medical_Record;
import idsw.db.pojos.Patient;


public class JDBCDiagnosisManager implements DiagnosisManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCDiagnosisManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public List<Diagnosis> listSixRecentDiagnosis() {
		List<Diagnosis> diagnoses = new ArrayList<Diagnosis>();
		try {
			String sql = "SELECT * FROM diagnoses ORDER BY IDdiagnosis DESC LIMIT 6; ";
			PreparedStatement ps;
			ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("idDiagnosis");
				String name = rs.getString("nameDiagnosis");
				Date date = rs.getDate("date");
				String comments = rs.getString("comment_section");
				Integer idDisease = rs.getInt("disease_id");
				Disease disease = conMan.getDiseaseMan().getDisease(idDisease);
				Integer idMedicalRecord =rs.getInt("medicalrecord_id"); 
				Medical_Record medicalRecord = conMan.getMedicalRecordMan().getMedical_Record(idMedicalRecord);
				Diagnosis diagnosis = new Diagnosis(id, name, date, comments,medicalRecord,disease);
				diagnoses.add(diagnosis);
			
			}
			rs.close();
			ps.close();
			
		}catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}		
		
		return diagnoses;
	}

	@Override
	public List<Diagnosis> listAllDiagnosis() {
		List<Diagnosis> diagnoses = new ArrayList<Diagnosis>();
		try {
			String sql = "SELECT * FROM diagnoses ORDER BY IDdiagnosis ;";
			PreparedStatement ps;
			ps = c.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("idDiagnosis");
				String name = rs.getString("nameDiagnosis");
				Date date = rs.getDate("date");
				String comments = rs.getString("comment_section");
				Integer idDisease = rs.getInt("disease_id");
				Disease disease = conMan.getDiseaseMan().getDisease(idDisease);
				Integer idMedicalRecord =rs.getInt("medicalrecord_id"); 
				Medical_Record medicalRecord = conMan.getMedicalRecordMan().getMedical_Record(idMedicalRecord);
				Diagnosis diagnosis = new Diagnosis(id, name, date, comments,medicalRecord,disease);
				diagnoses.add(diagnosis);
			
			}
			rs.close();
			ps.close();
			
		}catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}		
		
		return diagnoses;
	}

	@Override
	public Diagnosis getDiagnosis(int idDiagnosis) {
		Diagnosis diagnosis = null;
		try {
			String sql = "SELECT * FROM diagnoses WHERE IDdiagnosis = " + idDiagnosis;
			Statement st;
			st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			Date date = rs.getDate("date");
			Integer idDisease = rs.getInt("disease_id");
			Disease disease = conMan.getDiseaseMan().getDisease(idDisease);
			Integer idMedicalRecord =rs.getInt("medicalrecord_id"); 
			Medical_Record medicalRecord = conMan.getMedicalRecordMan().getMedical_Record(idMedicalRecord);
			diagnosis = new Diagnosis(idDiagnosis, rs.getString("nameDiagnosis") , date, rs.getString("comment_section"),medicalRecord,disease);
			return diagnosis;
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}		
		return diagnosis;
	}

	// con int o con diagnosis???
	@Override
	public void deleteDiagnosis(int IDiagnosis) {
		try {
			String template = "DELETE FROM diagnoses WHERE IDdiagnosis = ?";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setInt(1,IDiagnosis);
			ps.executeUpdate();
			ps.close();	
			
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}

	}

	//Y el treatment falta
	@Override
	public void addDiagnosis(Diagnosis diagnosis) {
		try {
			String template = "INSERT INTO diagnoses (nameDiagnosis, date ,comment_section, disease_id ,medicalrecord_id) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setString(1, diagnosis.getNameDiagnosis());
			Date localdate = diagnosis.getLocalDate();	
			ps.setDate(2, localdate);
			ps.setString(3, diagnosis.getComment_section());
			ps.setInt(4, diagnosis.getDisease().getIdDisease());
			ps.setInt(5, diagnosis.getMedicalRecord().getIdMedical_Record());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		
	}

	//Treatment falta
	@Override
	public void modifyDiagnosis(Diagnosis diagnosis) {
		try {
			String template = "UPDATE diagnoses SET nameDiagnosis = ?, date = ?, comment_section = ? WHERE IDdiagnosis = ?;";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setString(1, diagnosis.getNameDiagnosis());
			Date localdate = diagnosis.getLocalDate();	
			ps.setDate(2, localdate);
			ps.setString(3, diagnosis.getComment_section());
			ps.setInt(4,diagnosis.getIdDiagnosis());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
	}

	public List<Diagnosis> listMatchinDiagnosesByPatient(Integer idPatient){
		List<Diagnosis> diagnoses = new ArrayList<Diagnosis>();
		try {
			String sql = "SELECT * FROM diagnoses WHERE medicalRecord_id = ? ;";
			PreparedStatement ps;
			ps = c.prepareStatement(sql);
			ps.setInt(1,idPatient);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("idDiagnosis");
				String name = rs.getString("nameDiagnosis");
				Date date = rs.getDate("date");
				String comments = rs.getString("comment_section");
				Integer idDisease = rs.getInt("disease_id");
				Disease disease = conMan.getDiseaseMan().getDisease(idDisease);
				Integer idMedicalRecord =rs.getInt("medicalrecord_id"); 
				Medical_Record medicalRecord = conMan.getMedicalRecordMan().getMedical_Record(idMedicalRecord);
				Diagnosis diagnosis = new Diagnosis(id, name, date, comments,medicalRecord,disease);
				diagnoses.add(diagnosis);
			
			}
			rs.close();
			ps.close();
			
		}catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}		
		
		return diagnoses;
	}

	

}
