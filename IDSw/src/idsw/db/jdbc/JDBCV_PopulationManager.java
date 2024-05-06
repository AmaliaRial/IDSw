package idsw.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import idsw.db.enums.State;
import idsw.db.jdbcInterfaces.VirtualPopulationManager;
import idsw.db.pojos.Disease;
import idsw.db.pojos.Simulation;
import idsw.db.pojos.Virtual_Person;
import idsw.db.pojos.Virtual_Population;

public class JDBCV_PopulationManager implements VirtualPopulationManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCV_PopulationManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
		
	}

	@Override
	public void addVirtualPopulation(Virtual_Population virtualPopulation) {
		
		String template = "INSERT INTO virtual_populations(Initial_population, p_infected, p_healthy, p_immune, Immunity_period, disease_id) VALUES ('?','?','?','?','?','?')";
		PreparedStatement pstmt;
		try {
			pstmt = c.prepareStatement(template);
			pstmt.setInt(1, virtualPopulation.getInitial_population());
			pstmt.setFloat(2, virtualPopulation.getP_infected());
			pstmt.setFloat(3, virtualPopulation.getP_healthy());
			pstmt.setFloat(4, virtualPopulation.getP_immune());
			pstmt.setInt(5, virtualPopulation.getImmunity_period());
			pstmt.setInt(6, virtualPopulation.getDisease().getIdDisease());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error in database");
			e.printStackTrace();
		}
		
	}

	@Override
	public Virtual_Population getVirtualPopulation(int idVirtual_Population) {
		Virtual_Population VirtualPopulation_Selected=new Virtual_Population();
		String template = "SELECT * FROM virtual_populations WHERE idVirtual_population="+idVirtual_Population;
		PreparedStatement pstmt;
		try {
			pstmt = c.prepareStatement(template);
			ResultSet rs= pstmt.executeQuery();
			Integer idVirtual_population= rs.getInt("IDvirtual_population");
			Integer initial_population= rs.getInt("Initial_population");
			Float p_infected= rs.getFloat("p_infected");
			Float p_healthy= rs.getFloat("p_healthy");
			Float p_immune= rs.getFloat("p_immune");
			Integer immunity_period= rs.getInt("Immunity_period");
			Integer idDisease= rs.getInt("disease_Id");
			Disease disease= this.conMan.getDiseaseMan().getDisease(idDisease);
			VirtualPopulation_Selected=new Virtual_Population(idVirtual_population, initial_population, p_infected, p_healthy, p_immune, immunity_period, disease);
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error in database");
			e.printStackTrace();
		}
		return VirtualPopulation_Selected;
	}
	
	
	/**
	 * makes a set of the virtual people by the percentage of each tipe
	 */
	public void fillPopulation(Virtual_Population virtualPopulation){
		List<Virtual_Person> people= new ArrayList<Virtual_Person>();
		int peopleNum=virtualPopulation.getInitial_population();
		int intervalPercentageHealthy=(int) ((virtualPopulation.getP_healthy()/100)*peopleNum);
		int intervalPercentageImmune= (int) ((virtualPopulation.getP_immune()/100)*peopleNum);
		for(int i=0; i<virtualPopulation.getInitial_population(); i++ ){
			 //TODO en utilities asegurarse que la suma de los porcentajes no sea mayor que 100
			 if(i<intervalPercentageHealthy) {
				 State healthy= State.HEALTHY;
				 Virtual_Person vPerson=new Virtual_Person(healthy,0,0);
				 people.add(vPerson);
				 
			 }else if(intervalPercentageHealthy<=i && i<(intervalPercentageHealthy+intervalPercentageImmune)){
				 
				 State immune= State.IMMUNE;
				 Virtual_Person vPerson=new Virtual_Person(immune,0,virtualPopulation.getImmunity_period());
				 people.add(vPerson);
			 }else if((intervalPercentageHealthy+intervalPercentageImmune)<=i){
				 
				 State ill= State.ILL;
				 int disease_countdown= (int)(virtualPopulation.getDisease().getIncubation_period()+
						 virtualPopulation.getDisease().getDevelopment_period()+
						 virtualPopulation.getDisease().getConvalescence_period());
				 Virtual_Person vPerson=new Virtual_Person(ill,disease_countdown,0);
				 people.add(vPerson);
			 }
		}
		virtualPopulation.setVirtual_people(people);
	}
	
	
	@Override
	public List<Virtual_Population> listMatchingV_PopulationByDiseasease(Integer disease_id) {
		List<Virtual_Population> matchingPopulation=new ArrayList<Virtual_Population>();
		String template = "SELECT * FROM virtual_populations WHERE disease_id="+disease_id;
		PreparedStatement pstmt;
		try {
			pstmt = c.prepareStatement(template);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				Integer IDpopulation= rs.getInt("idVirtual_population");
				Integer initialPopulation= rs.getInt("Initial_population");
				Float pInfected= rs.getFloat("p_infected");
				Float pHealthy= rs.getFloat("p_healthy");
				Float pImmune= rs.getFloat("p_immune");
				Integer immunityPeriod=rs.getInt("Immunity_period");
				Disease disease= conMan.getDiseaseMan().getDisease(rs.getInt("disease_id"));
				
				matchingPopulation.add(new Virtual_Population(IDpopulation, initialPopulation, pInfected, pHealthy, pImmune,immunityPeriod,disease));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error in database");
			e.printStackTrace();
		}
		return matchingPopulation;
		
	}
	
	

}
