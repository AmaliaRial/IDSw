package idsw.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import idsw.db.jdbcInterfaces.TreatmentManager;
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
		
		return null;
	}

	@Override
	public Treatment getTreatment(int idTreatment) {
		try {
			String sql = "SELECT * FROM treatments WHERE id = " + idTreatment;
			Statement st;
			st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			Treatment treatment = new Treatment(rs.getInt("IDtreatment"), rs.getString("nameTreatment"), rs.getString("comment_section"));
			return treatment;
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}		return null;
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
			String template = "UPDATE treatments SET nameTreatment = ? AND comment_section = ? WHERE IDtreatment = ?;";
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
	public List<Treatment> listTreatmentsByDisease() {
		// TODO list Treatments By Disease
		return null;
	}

	@Override
	public List<Treatment> listTreatmentByDiagnosis() {
		// TODO list Treatments By Diagnosis
		return null;
	}

}
