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
		public String toString() {
			return "Virtual_Person [state=" + state + ", disease_countdown="
					+ disease_countdown + ", immunity_countdown=" + immunity_countdown + "]";
		}
		
		
}