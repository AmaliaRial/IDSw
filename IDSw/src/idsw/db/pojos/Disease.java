package idsw.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import idsw.db.enums.*;
 
public class Disease implements Serializable{
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 4610418778728477479L;
		private Integer idDisease;
		private String nameDisease;
		private Float infectious_rate;
		private Float mortality_rate;
		private Float incubation_period;
		private Float development_period;
		private Float convalescense_period;
		private cause cause;
		private String comment_section;
		private List<Symptom> symptoms;
		private List<Treatment> treatments;
		private Virtual_Population virtualPopulation;
		private List<Diagnosis> diagnoses;
		
		
		public Disease() {
			super();
			this.symptoms = new ArrayList<Symptom>();
			this.treatments = new ArrayList<Treatment>();
			
		}
		
		

		public Disease(Integer idDisease, String nameDisease, Float infectious_rate, Float mortality_rate,
				Float incubation_period, Float development_period, Float convalescense_period, cause cause, String comment_section) {
			super();
			this.idDisease = idDisease;
			this.nameDisease = nameDisease;
			this.infectious_rate = infectious_rate;
			this.mortality_rate = mortality_rate;
			this.incubation_period = incubation_period;
			this.development_period = development_period;
			this.convalescense_period = convalescense_period;
			this.cause = cause;
			this.comment_section = comment_section;
		}



		public Integer getIdDisease() {
			return idDisease;
		}

		public void setIdDisease(Integer idDisease) {
			this.idDisease = idDisease;
		}

		public String getNameDisease() {
			return nameDisease;
		}

		public void setNameDisease(String nameDisease) {
			this.nameDisease = nameDisease;
		}

		public Float getInfectious_rate() {
			return infectious_rate;
		}

		public void setInfectious_rate(Float infectious_rate) {
			this.infectious_rate = infectious_rate;
		}

		public Float getMortality_rate() {
			return mortality_rate;
		}

		public void setMortality_rate(Float mortality_rate) {
			this.mortality_rate = mortality_rate;
		}

		public Float getIncubation_period() {
			return incubation_period;
		}

		public void setIncubation_period(Float incubation_period) {
			this.incubation_period = incubation_period;
		}

		public Float getDevelopment_period() {
			return development_period;
		}

		public void setDevelopment_period(Float development_period) {
			this.development_period = development_period;
		}

		public Float getConvalescense_period() {
			return convalescense_period;
		}

		public void setConvalescense_period(Float convalescense_period) {
			this.convalescense_period = convalescense_period;
		}

		public cause getCause() {
			return cause;
		}

		public void setCause(cause cause) {
			this.cause = cause;
		}

		public String getComment_section() {
			return comment_section;
		}

		public void setComment_section(String comment_section) {
			this.comment_section = comment_section;
		}

		public List<Symptom> getSymptoms() {
			return symptoms;
		}

		public void setSymptoms(List<Symptom> symptoms) {
			this.symptoms = symptoms;
		}

		public List<Treatment> getTreatments() {
			return treatments;
		}

		public void setTreatments(List<Treatment> treatments) {
			this.treatments = treatments;
		}
		
		

		public Virtual_Population getVirtualPopulation() {
			return virtualPopulation;
		}

		public void setVirtualPopulation(Virtual_Population virtualPopulation) {
			this.virtualPopulation = virtualPopulation;
		}

		public List<Diagnosis> getDiagnoses() {
			return diagnoses;
		}

		public void setDiagnoses(List<Diagnosis> diagnoses) {
			this.diagnoses = diagnoses;
		}

		@Override
		public int hashCode() {
			return Objects.hash(idDisease);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Disease other = (Disease) obj;
			return Objects.equals(idDisease, other.idDisease);
		}

		@Override
		public String toString() {
			return "Disease [idDisease=" + idDisease + ", nameDisease=" + nameDisease + ", infectious_rate="
					+ infectious_rate + ", mortality_rate=" + mortality_rate + ", incubation_period="
					+ incubation_period + ", development_period=" + development_period + ", convalescense_period="
					+ convalescense_period + ", cause=" + cause + ", comment_section=" + comment_section + "]";
		}
		

}
