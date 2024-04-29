package idsw.db.pojos;

import java.io.Serializable;
import java.util.Objects;

import idsw.db.enums.*;

public class Virtual_Person implements Serializable{
		
		/**
		* 
	 	*/
		private static final long serialVersionUID = 6152860231636655190L;
		//private Integer idVirtual_Person;
		private State state;
		private Integer disease_countdown;
		private Integer immunity_countdown;
		private Virtual_Population virtual_population;
		
		public Virtual_Person() {
			super();
		}


		public Virtual_Person(State state1,Integer diseaseCountdown,Integer immunityCountdown) {
			this.state=state1;
			this.disease_countdown= diseaseCountdown;
			this.immunity_countdown=immunityCountdown;
		}


		public Integer getIdVirtual_Person() {
			return idVirtual_Person;
		}


		public void setIdVirtual_Person(Integer idVirtual_Person) {
			this.idVirtual_Person = idVirtual_Person;
		}


		public State getState() {
			return state;
		}


		public void setState(State state) {
			this.state = state;
		}


		public Integer getDisease_countdown() {
			return disease_countdown;
		}


		public void setDisease_countdown(Integer disease_countdown) {
			this.disease_countdown = disease_countdown;
		}


		public Integer getImmunity_countdown() {
			return immunity_countdown;
		}


		public void setImmunity_countdown(Integer immunity_countdown) {
			this.immunity_countdown = immunity_countdown;
		}


		public Virtual_Population getVirtual_population() {
			return virtual_population;
		}


		public void setVirtual_population(Virtual_Population virtual_population) {
			this.virtual_population = virtual_population;
		}


		@Override
		public int hashCode() {
			return Objects.hash(idVirtual_Person);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Virtual_Person other = (Virtual_Person) obj;
			return Objects.equals(idVirtual_Person, other.idVirtual_Person);
		}


		@Override
		public String toString() {
			return "Virtual_Person [state=" + state + ", disease_countdown="
					+ disease_countdown + ", immunity_countdown=" + immunity_countdown + "]";
		}
		
		
}