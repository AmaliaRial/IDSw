package idsw.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import idsw.db.jdbcInterfaces.DiseaseManager;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Symptom;

public class JDBCDiseaseManager implements DiseaseManager {
	
	private Connection c;
	private ConnectionManager conMan;

	/**
	 * Constructor
	 * 
	 * @param conMan
	 */
	public JDBCDiseaseManager(ConnectionManager conMan) {
			this.conMan = conMan;
			this.c = conMan.getConnection();
	}

	/**
	 * JDBC method that lists the 6 most recent added diseases in the database
	 * 
	 * @return List of diseases
	 */
	@Override
	public List<Disease> listSixRecentDiseases() {
		List<Disease> diseases = new ArrayList<Disease>();
		try {
			String sql = "SELECT * FROM diseases ORDER BY IDdisease DESC LIMIT 6; ";
			PreparedStatement ps;
			ps = c.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("IDdisease");
				String name = rs.getString("nameDisease");
				Float infectiousRate = rs.getFloat("infectious_rate");
				Float mortalityRate = rs.getFloat("mortality_rate");
				Float incubationPeriod = rs.getFloat("incubation_period");
				Float developmentPeriod = rs.getFloat("development_period");
				Float convalescencePeriod = rs.getFloat("convalescence_period");
				String cause1 = rs.getString("cause");
				String comments = rs.getString("comment_section");
				Disease disease = new Disease(id, name, infectiousRate, mortalityRate, incubationPeriod, developmentPeriod, convalescencePeriod, cause1, comments);
				diseases.add(disease);
			}
			rs.close();
			ps.close();
		}catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();		}
		return diseases;
	}

	/**
	 * JDBC method that lists the diseases in the database that match the name provided
	 * 
	 * @param Name of the disease
	 * @return List of diseases
	 */
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
				Float convalescencePeriod = rs.getFloat("convalescence_period");
				String cause1 = rs.getString("cause");
				String commentSection = rs.getString("comment_section");
				Disease disease = new Disease(id, diseaseName, infectiousRate, mortalityRate, incubationPeriod, developmentPeriod, convalescencePeriod, cause1, commentSection);
				diseases.add(disease);
			}
				rs.close();
				p.close();
			} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		return diseases;
	}

	/**
	 * JDBC method that lists all the diseases in the database that match the symptoms provided
	 * 
	 * @param List of symptoms
	 * @return List of diseases
	 */
	@Override
	public List<Disease> listMatchingDiseaseBySymptoms(List<Symptom> symptoms) {
	    List<Disease> diseases = new ArrayList<>();

	    try {
	        StringBuilder conditionBuilder = new StringBuilder();
	        for (Symptom symptom : symptoms) {
	            if (conditionBuilder.length() > 0) {
	                conditionBuilder.append(" OR ");
	            }
	            conditionBuilder.append("IDsymptom = ").append(symptom.getIdSymptom());
	        }

	        String template = "SELECT diseases.* FROM diseases JOIN disease_has_symptoms ON IDdisease = disease_id JOIN symptoms ON IDsymptom = symptom_id WHERE "
	                + conditionBuilder.toString() + " GROUP BY IDdisease";

	        PreparedStatement p = c.prepareStatement(template);
	        ResultSet rs = p.executeQuery();
	        while (rs.next()) {
	            int idDisease = rs.getInt("IDdisease");
	            String diseaseName = rs.getString("nameDisease");
	            Float infectiousRate = rs.getFloat("infectious_rate");
	            Float mortalityRate = rs.getFloat("mortality_rate");
	            Float incubationPeriod = rs.getFloat("incubation_period");
	            Float developmentPeriod = rs.getFloat("development_period");
	            Float convalescencePeriod = rs.getFloat("convalescence_period");
	            String cause = rs.getString("cause");
	            String commentSection = rs.getString("comment_section");
	            Disease disease = new Disease(idDisease, diseaseName,infectiousRate,mortalityRate,incubationPeriod,developmentPeriod,convalescencePeriod,cause, commentSection);
	            diseases.add(disease);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error in the database");
	        e.printStackTrace();
	    }

	    if (diseases.isEmpty()) {
	        System.out.println("No diseases found that match the provided symptoms");
	    }

	    return diseases;
	}
	

	/**
	 * JDBC method that provides you with the disease that matches the id provided
	 * 
	 * @param Id of the disease
	 * @return List of diseases
	 */
	@Override
	public Disease getDisease(int idDisease) {
		Disease disease = null;
		try {
			String sql = "SELECT * FROM diseases WHERE IDdisease = " + idDisease;
			Statement st;
			st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			disease = new Disease(rs.getInt("IDdisease"), rs.getString("nameDisease"), rs.getFloat("infectious_rate"), rs.getFloat("mortality_rate"), rs.getFloat("incubation_period"),rs.getFloat("development_period"), rs.getFloat("convalescence_period"), rs. getString("cause"), rs.getString("comment_section"));
			return disease;
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}	
		return disease;
	}

	/**
	 * JDBC method that deletes a disease from the database
	 * 
	 * @param Id of the disease
	 * @return List of diseases
	 */
	@Override
	public void deleteDisease(int IDdisease) {
		try {
			String template = "DELETE FROM diseases WHERE IDdisease = ?";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setInt(1, IDdisease);
			ps.executeUpdate();
			ps.close();	
					
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
	}

	/**
	 * JDBC method that adds a disease into the database
	 * 
	 * @param Disease
	 */
	@Override
	public void addDisease(Disease disease) {
			try {
				String template = "INSERT INTO diseases (nameDisease, infectious_rate, mortality_rate, incubation_period, development_period, convalescence_period, cause, comment_section) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
				PreparedStatement pstmt;
				pstmt = c.prepareStatement(template);
				pstmt.setString(1, disease.getNameDisease());
				pstmt.setFloat(2, disease.getInfectious_rate());
				pstmt.setFloat(3, disease.getMortality_rate());
				pstmt.setFloat(4, disease.getIncubation_period());
				pstmt.setFloat(5, disease.getDevelopment_period());
				pstmt.setFloat(6, disease.getConvalescence_period());
				pstmt.setString(7, disease.getCause().name());
				pstmt.setString(8, disease.getComment_section());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("Error in the database");
				e.printStackTrace();
			}
			
	}

	/**
	 * JDBC method that modifies a disease in the database
	 * 
	 * @param Disease
     */
	@Override
	public void modifyDisease(Disease disease) {
		try {
			String template = "UPDATE diseases SET nameDisease = ?, infectious_rate = ?, mortality_rate = ?, incubation_period = ?, development_period = ?, convalescence_period = ?, cause = ?, comment_section = ? WHERE IDdisease = ?;";
			PreparedStatement ps;
			ps = c.prepareStatement(template);
			ps.setString(1, disease.getNameDisease());
			ps.setFloat(2, disease.getInfectious_rate());
			ps.setFloat(3, disease.getMortality_rate());
			ps.setFloat(4, disease.getIncubation_period());
			ps.setFloat(5, disease.getDevelopment_period());
			ps.setFloat(6, disease.getConvalescence_period());
			ps.setString(7, disease.getCause().name());
			ps.setString(8, disease.getComment_section());
			ps.setInt(9, disease.getIdDisease());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}

	}

	/**
	 * JDBC method that adds a Symptom and a Disease to a many to many relationship table
	 * 
	 * @param Disease
	 * @param Symptom
	 */
	@Override
	public void addSymptomByDisease(Disease disease, Symptom symptom) {
		try {
			String template = "INSERT INTO disease_has_symptoms ( disease_id, symptom_id) VALUES (?, ?);";
			PreparedStatement pstmt;
			pstmt = c.prepareStatement(template);
			pstmt.setInt(1, disease.getIdDisease());
			pstmt.setInt(2, symptom.getIdSymptom());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Disease getMostMatchingDiseaseBySymptoms(List<Symptom> symptoms) {
		List<Disease> diseases = listMatchingDiseaseBySymptoms(symptoms);
	    Disease mostMatchingDisease = null;
	    double highestRelation = 0;

	    try {
	        for (Disease disease : diseases) {
	            StringBuilder symptomIds = new StringBuilder();
	            for (Symptom symptom : symptoms) {
	                if (symptomIds.length() > 0) {
	                    symptomIds.append(", ");
	                }
	                symptomIds.append(symptom.getIdSymptom());
	            }

	            String sql = "SELECT COUNT(*) FROM disease_has_symptoms WHERE disease_id = ? AND symptom_id IN (" + symptomIds.toString() + ")";
	            PreparedStatement p = c.prepareStatement(sql);
	            p.setInt(1, disease.getIdDisease());
	            ResultSet rs = p.executeQuery();
	            if (rs.next()) {
	                int matchingSymptoms = rs.getInt(1);

	                sql = "SELECT COUNT(*) FROM disease_has_symptoms WHERE disease_id = ?";
	                p = c.prepareStatement(sql);
	                p.setInt(1, disease.getIdDisease());
	                rs = p.executeQuery();
	                if (rs.next()) {
	                    int totalSymptoms = rs.getInt(1);
	                    double relation = (double) matchingSymptoms / totalSymptoms;
	                    if (relation > highestRelation) {
	                        highestRelation = relation;
	                        mostMatchingDisease = disease;
	                    }
	                }
	            } else {
	                System.out.println("No symptoms found for disease with ID: " + disease.getIdDisease());
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error in the database");
	        e.printStackTrace();
	    }

	    if (mostMatchingDisease == null) {
	        System.out.println("No matching disease found for the given symptoms");
	    }

	    return mostMatchingDisease;
	}

	public ConnectionManager getConMan() {
		return conMan;
	}

}
