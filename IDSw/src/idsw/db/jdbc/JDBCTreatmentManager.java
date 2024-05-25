package idsw.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import idsw.db.jdbcInterfaces.TreatmentManager;
import idsw.db.pojos.Diagnosis;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Treatment;

public class JDBCTreatmentManager implements TreatmentManager {
	
	private Connection c;
	private ConnectionManager conMan;

	/**
	 * Constructor
	 * 
	 * @param conMan
	 */
	public JDBCTreatmentManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
		
	}

	/**
	 * JDBC method that lists the 6 most recent added treatments in the database
	 * 
	 * @return List of treatments
	 */
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

	/**
	 * DBC method that lists the treatments in the database that match the name provided
	 * 
	 * @param Name of the treatment
	 * @return List of treatments
	 */
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

	/**
	 * JDBC method that provides you with the treatment that matches the id provided
	 * 
	 * @param Id of the treatment
	 * @return List of treatments
	 */
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

	/**
	 * JDBC method that deletes a Treatment from the database
	 * 
	 * @param Id of the treatment
	 */
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

	/**
	 * JDBC method that adds a treatment into the database
	 * 
	 * @param Treatment
	 */
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

	/**
	 * JDBC method that modifies a treatment in the database
	 * 
	 * @param Treatment
	 */
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


	/**
	 * JDBC method that adds a Treatment and a Diagnosis to a many to many relationship table
	 * 
	 * @param Diagnosis
	 * @param Treatment
	 */
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

	
	/**
	 * JDBC method that adds a Treatment and a Disease to a many to many relationship table
	 * 
	 * @param Disease
	 * @param Treatment
	 */
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

	/**
	 * JDBC method that lists all the treatments in the database that match the diseases provided
	 * 
	 * @param List of diseases
	 * @return  List of treatments
	 */
	@Override
	public List<Treatment> listTreatmentsByDisease(List<Disease> diseases) {
		/*List<Treatment> treatments = new ArrayList<Treatment>();
		try {
			String template = " SELECT nameTreatment, t.comment_section FROM treatments AS t JOIN disease_has_treatments ON IDtreatment = treatment_id JOIN diseases ON IDdisease = disease_id WHERE ?;";
			String condition = "";
			for (Disease disease : diseases) {
				condition = "AND" +condition+ "IDdisease = "+ disease.getIdDisease();
			}
			condition.replaceFirst("AND ", "");
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
		return treatments;*/
		
		List<Treatment> treatments = new ArrayList<>();
	    try {
	        StringBuilder conditionBuilder = new StringBuilder();
	        for (Disease disease : diseases) {
	            conditionBuilder.append("AND IDdisease = ").append(disease.getIdDisease()).append(" ");
	        }
	        // Remove the first "AND "
	        if (conditionBuilder.length() > 0) {
	            conditionBuilder.delete(0, 4); //AND + " "
	        }

	        String template = "SELECT IDtreatment, nameTreatment, t.comment_section FROM treatments AS t JOIN disease_has_treatments ON IDtreatment = treatment_id JOIN diseases ON IDdisease = disease_id WHERE "
	                + conditionBuilder.toString();

	        PreparedStatement p = c.prepareStatement(template);
	        ResultSet rs = p.executeQuery();
	        while (rs.next()) {
	        	int idTreatment = rs.getInt("IDTreatment");
	            String treatmentName = rs.getString("nameTreatment");
	            String commentSection = rs.getString("comment_section");
	            Treatment treatment = new Treatment(idTreatment, treatmentName, commentSection);
	            treatments.add(treatment);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error in the database");
	        e.printStackTrace();
	    }
	    return treatments;
	}

	/**
	 * JDBC method that lists all the treatments in the database that match the diagnoses provided
	 * 
	 * @param List of diagnoses
	 * @return  List of treatments
	 */
	@Override
	public List<Treatment> listTreatmentByDiagnoses(List<Diagnosis> diagnoses) {
		/*List<Treatment> treatments = new ArrayList<Treatment>();
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
		return treatments;*/
		List<Treatment> treatments = new ArrayList<>();
	    try {
	        StringBuilder conditionBuilder = new StringBuilder();
	        for (Diagnosis diagnosis : diagnoses) {
	            conditionBuilder.append("AND IDdiagnosis = ").append(diagnosis.getIdDiagnosis()).append(" ");
	        }
	        // Remove the first "AND "
	        if (conditionBuilder.length() > 0) {
	            conditionBuilder.delete(0, 4); //AND + " "
	        }

	        String template = "SELECT IDtreatment, nameTreatment, t.comment_section FROM treatments AS t JOIN diagnosis_has_treatments ON IDtreatment = treatment_id JOIN diagnoses ON IDdiagnosis = diagnosis_id WHERE "
	                + conditionBuilder.toString();

	        PreparedStatement p = c.prepareStatement(template);
	        ResultSet rs = p.executeQuery();
	        while (rs.next()) {
	        	int idTreatment = rs.getInt("IDTreatment");
	            String treatmentName = rs.getString("nameTreatment");
	            String commentSection = rs.getString("comment_section");
	            Treatment treatment = new Treatment(idTreatment, treatmentName, commentSection);
	            treatments.add(treatment);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error in the database");
	        e.printStackTrace();
	    }
	    return treatments;
	}

	@Override
	public List<Treatment> getTreatmentsByDiagnosis(Diagnosis diagnosis) {
		List<Treatment> treatments = new ArrayList<>();
		try {
			String selectTreatmentsSQL = "SELECT treatments.* FROM treatments "
                    + "JOIN diagnosis_has_treatments ON IDtreatment = treatment_id WHERE diagnosis_id = ?";
			PreparedStatement psTreatments = c.prepareStatement(selectTreatmentsSQL);
			psTreatments.setInt(1, diagnosis.getIdDiagnosis());
			ResultSet rsTreatments = psTreatments.executeQuery();
			while (rsTreatments.next()) {
				String treatmentName = rsTreatments.getString("nameTreatment");
				String comment_section = rsTreatments.getString("comment_section");
				Treatment treatment = new Treatment(treatmentName, comment_section);
				treatments.add(treatment);
			}
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		return treatments;
	}

	@Override
	public List<Treatment> getTreatmentsByDisease(Disease disease) {
		List<Treatment> treatments = new ArrayList<>();
		try {
			String selectTreatmentsSQL = "SELECT treatments.* FROM treatments "
                    + "JOIN disease_has_treatments ON IDtreatment = treatment_id WHERE disease_id = ?";
			PreparedStatement psTreatments = c.prepareStatement(selectTreatmentsSQL);
			psTreatments.setInt(1, disease.getIdDisease());
			ResultSet rsTreatments = psTreatments.executeQuery();
			while (rsTreatments.next()) {
				String treatmentName = rsTreatments.getString("nameTreatment");
				String comment_section = rsTreatments.getString("comment_section");
				Treatment treatment = new Treatment(treatmentName, comment_section);
				treatments.add(treatment);
			}
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		return treatments;
	}

}
