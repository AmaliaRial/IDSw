package idsw.db.jdbc;

import java.awt.event.FocusEvent.Cause;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import idsw.db.enums.cause;
import idsw.db.enums.state;
import idsw.db.jdbcInterfaces.DiseaseManager;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Symptom;

public class JDBCDiseaseManager implements DiseaseManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCDiseaseManager(ConnectionManager conMan) {
			this.conMan = conMan;
			this.c = conMan.getConnection();
	}

	@Override
	public List<Disease> listSixRecentDiseases() {
		List<Disease> diseases = new ArrayList<Disease>();
		try {
			String sql = "SELECT * FROM diseases GROUP BY IDdisease DESC LIMIT 6; ";
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Disease> listMatchingDiseaseByName(String name) {
		List<Disease> diseases = new ArrayList<Disease>();
		try {
			String sql = "SELECT * FROM diseases WHERE nameDisease LIKE ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, "%" + name + "%");
			ResultSet rs= p.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("IDdisease");
				String diseaseName = rs.getString("nameDisease");
				Float infectiousRate = rs.getFloat("infectious_rate");
				Float mortalityRate = rs.getFloat("mortality_rate");
				Float incubationPeriod = rs.getFloat("incubation_period");
				Float developmentPeriod = rs.getFloat("development_period");
				Float convalescensePeriod = rs.getFloat("convalescense_period");
				cause cause = rs.getString("cause");
				String commentSection = rs.getString("comment_section");
				Disease disease = new Disease(id, infectiousRate, mortalityRate, incubationPeriod, developmentPeriod, convalescensePeriod, cause, commentSection);
				}
				rs.close();
				p.close();
			} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Symptom> listMatchingDiseaseBySymptoms(List<Symptom> symptoms) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disease getDisease(int idDisease) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDisease(Disease disease) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDisease(Disease disease) {
			try {
				String template = "INSERT INTO diseases (nameDisease, infectious_rate, mortality_rate, incubation_period, development_period, convalescense_period, cause, comment_section) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
				PreparedStatement pstmt;
				pstmt = c.prepareStatement(template);
				pstmt.setString(1, disease.getNameDisease());
				pstmt.setFloat(2, disease.getInfectious_rate());
				pstmt.setFloat(3, disease.getMortality_rate());
				pstmt.setFloat(4, disease.getIncubation_period());
				pstmt.setFloat(5, disease.getDevelopment_period());
				pstmt.setFloat(6, disease.getConvalescense_period());
				pstmt.setString(7, disease.getCause().name());
				pstmt.setString(8, disease.getComment_section());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("Error in the database");
				e.printStackTrace();
			}
			
	}

	@Override
	public void modifyDisease(Disease disease) {
		// TODO Auto-generated method stub

	}

}
