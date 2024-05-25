package idsw.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import idsw.db.enums.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Disease")
@XmlType(propOrder = { "nameDisease", "cause", "disease_comment_section" })
public class Disease implements Serializable{
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 4610418778728477479L;
		@XmlAttribute
		private Integer idDisease;
		@XmlElement
		private String nameDisease;
		@XmlAttribute
		private Float infectious_rate;
		@XmlAttribute
		private Float mortality_rate;
		@XmlAttribute
		private Float incubation_period;
		@XmlAttribute
		private Float development_period;
		@XmlAttribute
		private Float convalescence_period;
		@XmlElement
		private Cause cause;
		@XmlElement
		private String disease_comment_section;
		@XmlTransient
		private List<Symptom> symptoms;
		@XmlTransient
		private List<Treatment> treatments;
		@XmlTransient
		private Virtual_Population virtualPopulation;
		@XmlTransient
		private List<Diagnosis> diagnoses;
		
		
		public Disease() {
			super();
			this.symptoms = new ArrayList<Symptom>();
			this.treatments = new ArrayList<Treatment>();
			
		}
		
		

		public Disease(Integer idDisease, String nameDisease, Float infectious_rate, Float mortality_rate,
				Float incubation_period, Float development_period, Float convalescence_period, String cause1, String comment_section) {
			super();
			this.idDisease = idDisease;
			this.nameDisease = nameDisease;
			this.infectious_rate = infectious_rate;
			this.mortality_rate = mortality_rate;
			this.incubation_period = incubation_period;
			this.development_period = development_period;
			this.convalescence_period = convalescence_period;
			this.cause = Cause.valueOf(cause1);
			this.disease_comment_section = comment_section;
		}
		
		public Disease(String nameDisease, Float infectious_rate, Float mortality_rate,
				Float incubation_period, Float development_period, Float convalescence_period, String cause1, String comment_section) {
			super();
			this.nameDisease = nameDisease;
			this.infectious_rate = infectious_rate;
			this.mortality_rate = mortality_rate;
			this.incubation_period = incubation_period;
			this.development_period = development_period;
			this.convalescence_period = convalescence_period;
			this.cause = Cause.valueOf(cause1.toUpperCase());
			this.disease_comment_section = comment_section;
		}

		

		public Disease(Integer idDisease, String nameDisease, String comment_section) {
			super();
			this.idDisease = idDisease;
			this.nameDisease = nameDisease;
			this.disease_comment_section = comment_section;
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

		public Float getConvalescence_period() {
			return convalescence_period;
		}

		public void setConvalescence_period(Float convalescense_period) {
			this.convalescence_period = convalescense_period;
		}

		public Cause getCause() {
			return cause;
		}

		public void setCause(Cause cause) {
			this.cause = cause;
		}

		public String getComment_section() {
			return disease_comment_section;
		}

		public void setComment_section(String comment_section) {
			this.disease_comment_section = comment_section;
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
			return "\n Disease [idDisease=" + idDisease + ", nameDisease=" + nameDisease + ", infectious_rate="
					+ infectious_rate + ", mortality_rate=" + mortality_rate + ", incubation_period="
					+ incubation_period + ", development_period=" + development_period + ", convalescense_period="
					+ convalescence_period + ", cause=" + cause + ", comment_section=" + disease_comment_section + "]";
		}
		

}
