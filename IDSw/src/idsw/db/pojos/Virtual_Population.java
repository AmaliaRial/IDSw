package idsw.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import idsw.db.jdbc.*;

public class Virtual_Population implements Serializable{
	
		/**
		* 
	 	*/
		private static final long serialVersionUID = 5867685344047960434L;
		private Integer idVirtual_population;
		private Integer initial_population; 
		private Float p_infected;
		private Float p_healthy;
		private Float p_immune;
		private Integer immunity_period; //From disease
		private Disease disease;
		private List<Virtual_Person> virtual_people;
		
		public Virtual_Population(Integer idVirtual_population2, Integer initial_population2, Float p_infected2, Float p_healthy2, Float p_immune2, Integer immunity_period2, Disease disease2) {
			this.idVirtual_population=idVirtual_population2;
			this.initial_population=initial_population2;
			this.p_infected= p_infected2;
			this.p_healthy=  p_healthy2;
			this.p_immune= p_immune2;
			this.immunity_period= immunity_period2;
			this.disease =disease2;
			
			this.virtual_people = new ArrayList<Virtual_Person>();
		}
		
		public Virtual_Population(Integer initial_population2, Float p_infected2, Float p_healthy2, Float p_immune2, Integer immunity_period2, Disease disease2) {
			this.initial_population=initial_population2;
			this.p_infected= p_infected2;
			this.p_healthy=  p_healthy2;
			this.p_immune= p_immune2;
			this.immunity_period= immunity_period2;
			this.disease =disease2;
			
			this.virtual_people = new ArrayList<Virtual_Person>();
		}
		
		public Virtual_Population() {
			//TODO HACE FALTA PONER TOdO COMO NULL?
		}

		public Integer getIdVirtual_population() {
			return idVirtual_population;
		}

		public void setIdVirtual_population(Integer idVirtual_population) {
			this.idVirtual_population = idVirtual_population;
		}

		public Integer getInitial_population() {
			return initial_population;
		}

		public void setInitial_population(Integer initial_population) {
			this.initial_population = initial_population;
		}

		public Float getP_infected() {
			return p_infected;
		}

		public void setP_infected(Float p_infected) {
			this.p_infected = p_infected;
		}

		public Float getP_healthy() {
			return p_healthy;
		}

		public void setP_healthy(Float p_healthy) {
			this.p_healthy = p_healthy;
		}

		public Float getP_immune() {
			return p_immune;
		}

		public void setP_immune(Float p_immune) {
			this.p_immune = p_immune;
		}

		public Integer getImmunity_period() {
			return immunity_period;
		}

		public void setImmunity_period(Integer immunity_period) {
			this.immunity_period = immunity_period;
		}

		public Disease getDisease() {
			return disease;
		}

		public void setDisease(Disease disease) {
			this.disease = disease;
		}

		public List<Virtual_Person> getVirtual_people() {
			return virtual_people;
		}

		public void setVirtual_people(List<Virtual_Person> virtual_people) {
			this.virtual_people = virtual_people;
		}
		
		

		@Override
		public int hashCode() {
			return Objects.hash(idVirtual_population);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Virtual_Population other = (Virtual_Population) obj;
			return Objects.equals(idVirtual_population, other.idVirtual_population);
		}

		@Override
		public String toString() {
			return "Virtual_Population [initial_population=" + initial_population + ", % of infected=" + p_infected
					+ ", % of healthy=" + p_healthy + ", % of immune=" + p_immune + ", immunity_period=" + immunity_period
					+ ", virtual_people=" + virtual_people+"]";
		}
		
		public static void main(String args[]) {
			Disease disease= new Disease();
			disease.setIncubation_period((float) 1);
			disease.setDevelopment_period((float) 2);
			disease.setConvalescence_period((float) 1);
			disease.setMortality_rate((float) 0.3);
			ConnectionManager conMan= new ConnectionManager();
			Virtual_Population populationTest= new Virtual_Population(20,(float) 30,(float) 60,(float) 10, 5, disease);
			conMan.getVirtualPopulationMan().fillPopulation(populationTest);
			System.out.println(populationTest);
		}
		
		
}
