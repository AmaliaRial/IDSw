package idsw.db.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import idsw.db.jdbcInterfaces.DiagnosisManager;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Medical_Record;
import idsw.db.pojos.Treatment;

public class JDBCDiagnosisManager implements DiagnosisManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCDiagnosisManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public List<Diagnosis> listSixRecentDiagnosis() {
		List<Diagnosis> diagnosises = new ArrayList<Diagnosis>();
		try {
			String sql = "SELECT * FROM diagnosis ORDER BY IDdiagnosis DESC LIMIT 6; ";
			PreparedStatement ps;
			ps = c.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("idDiagnosis");
				String name = rs.getString("nameDiagnosis");
				Date date = rs.getDate("date");
				String comments = rs.getString("comment_section");
				Disease disease = conMan.getDiseaseMan().getDisease(rs.getInt("disease_id"));
				Medical_Record medicalRecord = conMan.getMedicalRecordMan().getMedical_Record(rs.getInt("medicalRecord_id"));
				Diagnosis diagnosis = new Diagnosis(id, name, date, comments,medicalRecord,disease);
				diagnosises.add(diagnosis);
			
			}
			rs.close();
			ps.close();
			
		}catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}		
		
		return null;
	}

	@Override
	//creo q solo habia que quitar el limit nose
	public List<Diagnosis> listAllDiagnosis() {
		List<Diagnosis> diagnosises = new ArrayList<Diagnosis>();
		try {
			String sql = "SELECT * FROM diagnosis ORDER BY IDdiagnosis DESC; ";
			PreparedStatement ps;
			ps = c.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("idDiagnosis");
				String name = rs.getString("nameDiagnosis");
				Date date = rs.getDate("date");
				String comments = rs.getString("comment_section");
				Disease disease = conMan.getDiseaseMan().getDisease(rs.getInt("disease_id"));
				Medical_Record medicalRecord = conMan.getMedicalRecordMan().getMedical_Record(rs.getInt("medicalRecord_id"));
				Diagnosis diagnosis = new Diagnosis(id, name, date, comments,medicalRecord,disease);
				diagnosises.add(diagnosis);
			
			}
			rs.close();
			ps.close();
			
		}catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}		
		
		return null;
	}

	@Override
	public Diagnosis getDiagnosis(int idDiagnosis) {
		Diagnosis diagnosis = null;
		try {
			String sql = "SELECT * FROM diagnosis WHERE id = " + idDiagnosis;
			Statement st;
			st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			diagnosis = new Diagnosis(idDiagnosis, rs.getString("nameDiagnosis") , rs.getDate("date") , rs.getString("comment_section"), conMan.getMedicalRecordMan().getMedical_Record(rs.getInt("medicalRecord_id")) , conMan.getDiseaseMan().getDisease(rs.getInt("disease_id")));
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
			String template = "DELETE FROM diagnosis WHERE IDdiagnosis = ?";
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
			String template = "INSERT INTO diagnosis (nameDiagnosis, date,comment_section, disease_id ,medicalrecord_id) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setString(1, diagnosis.getNameDiagnosis());
			ps.setDate(2, diagnosis.getDate());
			ps.setString(3, diagnosis.getComment_section());
			ps.setInt(4, diagnosis.getMedicalRecord().getIdMedical_Record());
			ps.setInt(5, diagnosis.getDisease().getIdDisease());
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
			String template = "UPDATE diagnosis SET nameDiagnosis = ?, AND date = ?, AND comment_section = ?, AND WHERE IDdiagnosis = ?;";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setString(1, diagnosis.getNameDiagnosis());
			ps.setDate(2, diagnosis.getDate());
			ps.setString(3, diagnosis.getComment_section());
			ps.setInt(4,diagnosis.getIdDiagnosis());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
	}

	

}
