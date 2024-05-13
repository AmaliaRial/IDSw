 
package idsw.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import idsw.db.enums.Pain_Management;
import idsw.db.jdbcInterfaces.SymptomManager;
import idsw.db.pojos.Disease;
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
				String pain_management = rs.getString("pain_management");
				Symptom symptom = new Symptom(id, name, pain_management);
				symptoms.add(symptom);
			}
			rs.close();
			p.close();
		}catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		return symptoms;
	}
	
	
	
	@Override	
	public List<Symptom> listSymptomsByDisease(List<Disease> diseases) {
		List<Symptom> symptoms = new ArrayList<Symptom>();
		try {
			String template ="SELECT nameSymptom, pain_management FROM symptoms JOIN disease_has_symptoms ON symptom_id WHERE disease_id LIKE ?";
			
			String condition="";
			for(Disease disease:diseases) {
			    condition="AND"+condition+"IDdisease="+disease.getIdDisease();
			}
			condition.replaceFirst("AND","");
			condition=condition+";";
			
			PreparedStatement p;
			p = c.prepareStatement(template);
			p.setString(1, condition);
			
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				String nameSymptom = rs.getString("nameSymptom"); 
				String pain_management = rs.getString("pain_management");
				Symptom symptom = new Symptom(nameSymptom,pain_management);
				symptoms.add(symptom);
			}
			
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}catch (NullPointerException e) {
			System.out.println("The list provided is Null, please insert some data.");
			e.printStackTrace();
		}
		
		return symptoms;
	}
	
	
	@Override
	public Symptom getSymptom(int idSymptom) {
		try {
			String sql = "SELECT * FROM symptoms WHERE IDsymptom = " + idSymptom;
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
	public void deleteSymptom(int  idSymptom) {
		try {
			String template = "DELETE FROM symptoms WHERE IDsymptom = ?";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setInt(1, idSymptom);
			ps.executeUpdate();
			ps.close();	
			
			
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
