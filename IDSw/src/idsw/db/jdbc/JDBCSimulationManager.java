package idsw.db.jdbc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import idsw.db.pojos.Disease;
import idsw.db.pojos.Simulation;
import idsw.db.pojos.Virtual_Population;
import idsw.db.utilities.GraphUtilities;
import idsw.db.pojos.Virtual_Person;
import idsw.db.enums.State;
import idsw.db.jdbcInterfaces.SimulationManager;

public class JDBCSimulationManager implements SimulationManager {
	
	private Connection c;
	private ConnectionManager conMan;

	public JDBCSimulationManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}
	
	@Override
	public void addSimulation(Simulation simulation) {
		// TODO añadir los data del resultato
		try {
			String template = "INSERT INTO simulations(totalInfections, totalDeaths, totalImmunity, totalPopulation, simulationGraph, virtual_population) VALUES (?,?,?,?,?,?)";
			PreparedStatement pstmt;
			pstmt = c.prepareStatement(template);
			pstmt.setInt(1, simulation.getTotalInfections());
			pstmt.setInt(2, simulation.getTotalDeaths());
			pstmt.setInt(3, simulation.getTotalImmunity());
			pstmt.setInt(4, simulation.getTotalPopulation());
			pstmt.setBytes(5, simulation.getSimulationGraph());
			pstmt.setInt(6, simulation.getVpopulation().getIdVirtual_population());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error in database");
			e.printStackTrace();
		}
	
	}
	
	public Simulation createSimulation(Virtual_Population virtualPopulation) {
		List<Virtual_Person> people= virtualPopulation.getVirtual_people();
		//TODO cambiar de atributo en simulation estas tres listas en vez de graph
		List<Integer> illCounterData=new ArrayList<>();
		List<Integer> deathCounterData=new ArrayList<>();
		List<Integer> peopleCounterData=new ArrayList<>();
		Random random = new Random();
		int randNum;
		Disease disease= virtualPopulation.getDisease();
		
		int illCounter=illPeopleCounter(people);
		illCounterData.add(illCounter);
		int deathCounter=0;
		deathCounterData.add(deathCounter);
		int peopleCounter=people.size();
		peopleCounterData.add(peopleCounter);
		int total_Infections=0;
		int total_FinalInmunitations=0;
		
		int disease_FullCountdown= (int)(disease.getIncubation_period()+
				disease.getDevelopment_period()+
				disease.getConvalescence_period());
		int immunity_FullPeriod= virtualPopulation.getImmunity_period();
		double likelihood_death= (disease.getMortality_rate())*100;
		double infectiousRate=(double)disease.getInfectious_rate();
		
		while(peopleCounter!=0 && illCounter!=0) {
			double exponent= -(infectiousRate*((double)illCounter/(double)peopleCounter));
			double likelihood_infection=((1-Math.exp(exponent))*10000);
			peopleCounter=0;
			illCounter=0;
			deathCounter=0;
			
			//ciclos de contagios
			for(Virtual_Person vPerson: people) {
				if(vPerson.getState().equals(State.HEALTHY)) {
					randNum= random.nextInt(10000);
					if(randNum<likelihood_infection) {
						vPerson.setState(State.ILL);
						vPerson.setDisease_countdown(disease_FullCountdown);
						illCounter++;
						total_Infections++;
					}
					peopleCounter++;
				}else if(vPerson.getState().equals(State.IMMUNE)) {
					int immunityPersonalCountdown= vPerson.getImmunity_countdown();
					vPerson.setImmunity_countdown(--immunityPersonalCountdown);
					if(immunityPersonalCountdown==0) {
						vPerson.setState(State.HEALTHY);
						total_FinalInmunitations--;
					}
					peopleCounter++;
				}else if(vPerson.getState().equals(State.ILL)) {
					randNum= random.nextInt(10000);
					if(randNum<likelihood_death && vPerson.getDisease_countdown()==disease_FullCountdown) {
						vPerson.setState(State.DECEASED);
						deathCounter++;
					}else{
						int diseasePersonalCountdown= vPerson.getDisease_countdown();
						vPerson.setDisease_countdown(--diseasePersonalCountdown);
						if(diseasePersonalCountdown==0) {
							vPerson.setState(State.IMMUNE);
							vPerson.setImmunity_countdown(immunity_FullPeriod);
							total_FinalInmunitations++;
						}
						illCounter++;
						peopleCounter++;
					}
				}
			}

			illCounterData.add(illCounter);
			deathCounterData.add(deathCounter);
			peopleCounterData.add(peopleCounter);
		}
		int total_deaths=0;
		for(int i:deathCounterData) {
			total_deaths=total_deaths+i;
		}
		
		GraphUtilities graphUtility=new GraphUtilities();
		
		byte[] blob= graphUtility.graphIntoBinary(graphUtility.graphSimulation(illCounterData,deathCounterData, peopleCounterData, disease.getNameDisease()));
	
		Simulation simulation=new Simulation(total_Infections,total_deaths, total_FinalInmunitations, peopleCounter, blob, virtualPopulation);
		addSimulation(simulation);
		return simulation;
		
	}
	
	private int illPeopleCounter(List<Virtual_Person> people) {
		int illCounter=0;
		for(Virtual_Person vPerson: people) {
			if(vPerson.getState().equals(State.ILL)) {
				illCounter++;
			}
		}
		return illCounter;
		
	}
	
	/**
	 * this
	 * @throws IOException 
	 */

	@Override
	public Simulation selectSimulation(Integer simulation_id) throws IOException {
		// TODO Auto-generated method stub
		Simulation simulationSelected=new Simulation();
		String template = "SELECT * FROM simulations WHERE IDsimulation="+simulation_id;
		PreparedStatement pstmt;
		try {
			pstmt = c.prepareStatement(template);
			ResultSet rs= pstmt.executeQuery();
			Integer IDsimulation= rs.getInt("IDsimulation");
			Integer totalInfections= rs.getInt("totalInfections");
			Integer totalDeaths= rs.getInt("totalDeaths");
			Integer totalImmunity= rs.getInt("totalImmunity");
			Integer totalPopulation= rs.getInt("totalPopulation");
			InputStream blobStream = rs.getBinaryStream("simulationGraph");
			byte[] graph = null;
			try {
				graph = new byte[blobStream.available()];
				blobStream.read(graph);
			}catch(IOException ioe){
				System.err.println("Error in reading graph");
			}finally {
				Virtual_Population vPopulation= conMan.getVirtualPopulationMan().getVirtualPopulation(rs.getInt("virtual_population"));
				
				simulationSelected=new Simulation(IDsimulation,totalInfections, totalDeaths,totalImmunity, totalPopulation, graph, vPopulation);
						
				rs.close();
				pstmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Error in database");
			e.printStackTrace();
		}
		//if no matching returns a simulation with null atributes
		return simulationSelected;
	}

	@Override
	public List<Simulation> listMatchingSimulationByV_Population (Integer virtualPopulation_id) {
		List<Simulation> matchingSimulations=new ArrayList<Simulation>();
		String template = "SELECT * FROM simulations WHERE virtual_population="+virtualPopulation_id;
		PreparedStatement pstmt;
		try {
			pstmt = c.prepareStatement(template);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				Integer IDsimulation= rs.getInt("IDsimulation");
				Integer totalInfections= rs.getInt("totalInfections");
				Integer totalDeaths= rs.getInt("totalDeaths");
				Integer totalImmunity= rs.getInt("totalImmunity");
				Integer totalPopulation= rs.getInt("totalPopulation");
				InputStream blobStream = rs.getBinaryStream("simulationGraph");
				byte[] graph = null;
				try {
					graph = new byte[blobStream.available()];
					blobStream.read(graph);
				}catch(IOException ioe){
					System.err.println("Error in reading graph");
				}finally {
					Virtual_Population vPopulation= conMan.getVirtualPopulationMan().getVirtualPopulation(rs.getInt("virtual_population"));	
					matchingSimulations.add(new Simulation(IDsimulation,totalInfections, totalDeaths,totalImmunity, totalPopulation, graph, vPopulation));
				}
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error in database");
			e.printStackTrace();
		}
		
		return matchingSimulations;
	}

	@Override
	public List<Simulation> listSixRecentSimulation() {
		// TODO Auto-generated method stub
		return null;
	}

}
