package idsw.db.jdbc;

import java.sql.*;
import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Disease> listMatchingDiseaseByName(String search) {
		// TODO Auto-generated method stub
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
				String template = "INSERT INTO disease (nameDisease, infectious_rate, mortality_rate, incubation_period, development_period, convalescense_period, cause, comment_section) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
				PreparedStatement pstmt;
				pstmt = c.prepareStatement(template);
				pstmt.setString(1, disease.getNameDisease());
				pstmt.setFloat(2, disease.getInfectious_rate());
				pstmt.setFloat(3, disease.getMortality_rate());
				pstmt.setFloat(4, disease.getIncubation_period());
				pstmt.setFloat(5, disease.getDevelopment_period());
				pstmt.setFloat(6, disease.getConvalescense_period());
				pstmt.setString(7, disease.getCause());
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
