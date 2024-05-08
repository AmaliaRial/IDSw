package idsw.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import idsw.db.jdbcInterfaces.TreatmentManager;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Treatment;

public class JDBCTreatmentManager implements TreatmentManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCTreatmentManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
		
	}

	@Override
	public List<Treatment> listSixRecentTreatment() {
		List<Treatment> treatments = new ArrayList<Treatment>();
		try {
			String sql = "SELECT * FROM treatments ORDER BY IDtreatment DESC LIMIT 6; ";
			PreparedStatement ps;
			ps = c.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("IDtreatment");
				String name = rs.getString("nameTreatment");
				String comments = rs.getString("comment_section");
				Treatment treatment = new Treatment(id, name, comments);
				treatments.add(treatment);
			}
			rs.close();
			ps.close();
			
		}catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}		
		
		return treatments;
	}

	@Override
	public List<Treatment> listMatchingTreatmentsByName(String search) {
		List<Treatment> treatments = new ArrayList<Treatment>();
		try {
			String sql = "SELECT * FROM treatments WHERE nameTreatment LIKE ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, "%" + search + "%");
			ResultSet rs= p.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("IDtreatment");
				String name = rs.getString("nameTreatment");
				String comments = rs.getString("comment_section");
				Treatment treatment = new Treatment(id, name, comments);
				treatments.add(treatment);
			}
			rs.close();
			p.close();
		}catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		
		return treatments;
	}

	@Override
	public Treatment getTreatment(int idTreatment) {
		Treatment treatment = new Treatment();
		try {
			String sql = "SELECT * FROM treatments WHERE IDtreatment = " + idTreatment;
			Statement st;
			st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			treatment = new Treatment(rs.getInt("IDtreatment"), rs.getString("nameTreatment"), rs.getString("comment_section"));
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}		
		return treatment;
	}

	@Override
	public void deleteTreatment(int id_treatment) {
		try {
			String template = "DELETE FROM treatments WHERE IDtreatment = ?";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setInt(1, id_treatment);
			ps.executeUpdate();
			ps.close();	
					
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		
	}

	@Override
	public void addTreatment(Treatment treatment) {
		try {
			String template = "INSERT INTO treatments (nameTreatment, comment_section) VALUES (?, ?);";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setString(1, treatment.getNameTreatment());
			ps.setString(2, treatment.getComment_Section());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
	}

	@Override
	public void modifyTreatment(Treatment treatment) {
		try {
			String template = "UPDATE treatments SET nameTreatment = ?, comment_section = ? WHERE IDtreatment = ?;";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setString(1, treatment.getNameTreatment());
			ps.setString(2, treatment.getComment_Section());
			ps.setInt(3,treatment.getIdTreatment());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
	}



	@Override
	public void addTreatmentByDiagnosis(Diagnosis diagnosis, Treatment treatment) {
		try {
			String template = "INSERT INTO diagnosis_has_treatments ( diagnosis_id, treatment_id) VALUES (?, ?);";
			PreparedStatement pstmt;
			pstmt = c.prepareStatement(template);
			pstmt.setInt(1, diagnosis.getIdDiagnosis());
			pstmt.setInt(2, treatment.getIdTreatment());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}		
	}

	@Override
	public void addTreatmentByDisease(Disease disease, Treatment treatment) {
		try {
			String template = "INSERT INTO disease_has_treatments ( disease_id, treatment_id) VALUES (?, ?);";
			PreparedStatement pstmt;
			pstmt = c.prepareStatement(template);
			pstmt.setInt(1, disease.getIdDisease());
			pstmt.setInt(2, treatment.getIdTreatment());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}				
	}

	@Override
	public List<Treatment> listTreatmentsByDisease(List<Disease> diseases) {
		List<Treatment> treatments = new ArrayList<Treatment>();
		try {
			String template = " SELECT nameTreatment, t.comment_section FROM treatments AS t JOIN disease_has_treatments ON IDtreatment = treatment_id JOIN diseases ON IDdisease = disease_id WHERE ?;";
			String condition = "";
			for (Disease disease : diseases) {
				condition = "AND" +condition+ "IDdisease = "+ disease.getIdDisease();
			}
			condition.replaceFirst("AND", "");
			condition = condition + ";";
			
			PreparedStatement p;
			p = c.prepareStatement(template);
			p.setString(1, condition);
			
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				String treatmentName = rs.getString("nameTreatment");
				String comment_section = rs.getString("comment_section");
				Treatment treatment = new Treatment(treatmentName, comment_section);
				treatments.add(treatment);
			}
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}catch (NullPointerException e) {
			System.out.println("The list provided is Null, please insert some data.");
			e.printStackTrace();
		}
		return treatments;
	}

	@Override
	public List<Treatment> listTreatmentByDiagnosis(List<Diagnosis> diagnoses) {
		List<Treatment> treatments = new ArrayList<Treatment>();
		try {
			String template = "SELECT nameTreatment, t.comment_section FROM treatments AS t JOIN diagnosis_has_treatments ON IDtreatment = treatment_id JOIN diagnoses ON IDdiagnosis = diagnosis_id WHERE ?";
			String condition = "";
			for (Diagnosis diagnosis : diagnoses) {
				condition = "AND" +condition+ "IDdiagnosis = "+ diagnosis.getIdDiagnosis();
			}
			condition.replaceFirst("AND", "");
			condition = condition + ";";
			
			PreparedStatement p;
			p = c.prepareStatement(template);
			p.setString(1, condition);
			
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				String treatmentName = rs.getString("nameTreatment");
				String comment_section = rs.getString("comment_section");
				Treatment treatment = new Treatment(treatmentName, comment_section);
				treatments.add(treatment);
			}
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}catch (NullPointerException e) {
			System.out.println("The list provided is Null, please insert some data.");
			e.printStackTrace();
		}
		return treatments;
	}

}
