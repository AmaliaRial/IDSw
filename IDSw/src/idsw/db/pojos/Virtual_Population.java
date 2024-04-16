package idsw.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
		
		public Virtual_Population() {
			super();
			this.virtual_people = new ArrayList<Virtual_Person>();
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
			return "Virtual_Population [initial_population=" + initial_population + ", p_infected=" + p_infected
					+ ", p_healthy=" + p_healthy + ", p_immune=" + p_immune + ", immunity_period=" + immunity_period
					+ ", disease=" + disease + ", virtual_people=" + virtual_people + "]";
		}
		
		
}
