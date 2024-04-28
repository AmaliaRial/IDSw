package idsw.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import idsw.db.jdbcInterfaces.SymptomManager;
import idsw.db.pojos.Symptom;
import idsw.db.pojos.Treatment;

public class JDBCSymptomManager implements SymptomManager {
	
	private Connection c;
	private ConnectionManager conMan;


	public JDBCSymptomManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
		
	}

	@Override
	public List<Symptom> listMatchingSymptomsByName(String search) {
		List<Symptom> symptoms = new ArrayList<Symptom>();
		try {
			String sql = "SELECT * FROM symptoms WHERE nameSymptom LIKE ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, "%" + search + "%");
			ResultSet rs= p.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("IDsymptom");
				String name = rs.getString("nameSymptom");
				String comments = rs.getString("pain_management");
				Symptom symptom = new Symptom(id, name, comments);
				symptoms.add(symptom);
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
	public Symptom getSymptom(int idSymptom) {
		try {
			String sql = "SELECT * FROM symptoms WHERE id = " + idSymptom;
			Statement st;
			st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			Symptom symptom = new Symptom(rs.getInt("IDSymptom"), rs.getString("nameSymptom"), rs.getString("pain_management"));
			return symptom;
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}		return null;
	}
	

	@Override
	public void deleteSymptom(Symptom symptom) {
		try {
			String template = "DELETE FROM disease_has_symptom WHERE symptom_id = ?";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setInt(1, symptom.getIdSymptom());
			ps.executeUpdate();
			ps.close();	
			
			String sql = "DELETE FROM disease_has_symptom WHERE symptom_id = ?";
			PreparedStatement ps1;
			ps1 = c.prepareStatement(sql);
			ps1.setInt(1, symptom.getIdSymptom());
			ps1.executeUpdate();
			ps1.close();
			
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
	}
		

	@Override
	public void addSymptom(Symptom symptom) {
		try {
			String template = "INSERT INTO symptoms (nameSymptom, pain_management) VALUES (?, ?);";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setString(1, symptom.getNameSymptom());
			ps.setString(2, symptom.getPain_management().name());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}

	}

	@Override
	public void modifySymptom(Symptom symptom) {
		try {
			String template = "UPDATE symptoms SET nameSymptom = ? AND pain_management = ? WHERE IDsymptom = ?;";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setString(1, symptom.getNameSymptom());
			ps.setString(2, symptom.getPain_management().name());
			ps.setInt(3,symptom.getIdSymptom());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}

	}

}
