package idsw.db.pojos;

import java.io.Serializable;
import java.util.Objects;

import idsw.db.enums.*;

public class Virtual_Person implements Serializable{
		
		/**
		* 
	 	*/
		private static final long serialVersionUID = 6152860231636655190L;
		private Integer idVirtual_Person;
		private state state;
		private Float disease_countdown;
		private Float immunity_countdown;
		private Virtual_Population virtual_population;
		//should we add disease?
		
		public Virtual_Person() {
			super();
		}


		public Integer getIdVirtual_Person() {
			return idVirtual_Person;
		}


		public void setIdVirtual_Person(Integer idVirtual_Person) {
			this.idVirtual_Person = idVirtual_Person;
		}


		public state getState() {
			return state;
		}


		public void setState(state state) {
			this.state = state;
		}


		public Float getDisease_countdown() {
			return disease_countdown;
		}


		public void setDisease_countdown(Float disease_countdown) {
			this.disease_countdown = disease_countdown;
		}


		public Float getImmunity_countdown() {
			return immunity_countdown;
		}


		public void setImmunity_countdown(Float immunity_countdown) {
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
			return "Virtual_Person [idVirtual_Person=" + idVirtual_Person + ", state=" + state + ", disease_countdown="
					+ disease_countdown + ", immunity_countdown=" + immunity_countdown + ", virtual_population="
					+ virtual_population + "]";
		}
		
		
}