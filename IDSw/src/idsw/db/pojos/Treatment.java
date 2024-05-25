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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Treatment")
@XmlType(propOrder = { "nameTreatment", "treatment_comment_Section"})
public class Treatment implements Serializable{

	
		/**
		* 
	 	*/
		private static final long serialVersionUID = -3878390729908698825L;
		@XmlAttribute
		private Integer idTreatment;
		@XmlElement
		private String nameTreatment;
		@XmlElement
		private String treatment_comment_Section;
		@XmlTransient
		private List<Disease> diseases;
		@XmlTransient
		private List<Diagnosis> diagnosis;
	
		public Treatment() {
			super();
			this.diseases = new ArrayList<Disease>();
			this.diagnosis = new ArrayList<Diagnosis>();
		}

		
		
		public Treatment(Integer idTreatment, String nameTreatment, String comment_Section) {
			super();
			this.idTreatment = idTreatment;
			this.nameTreatment = nameTreatment;
			this.treatment_comment_Section = comment_Section;
		}

		public Treatment(String nameTreatment, String comment_Section) {
			super();
			this.nameTreatment = nameTreatment;
			this.treatment_comment_Section = comment_Section;
		}

		public Integer getIdTreatment() {
			return idTreatment;
		}

		public void setIdTreatment(Integer idTreatment) {
			this.idTreatment = idTreatment;
		}

		public String getNameTreatment() {
			return nameTreatment;
		}

		public void setNameTreatment(String nameTreatment) {
			this.nameTreatment = nameTreatment;
		}

		public String getComment_Section() {
			return treatment_comment_Section;
		}

		public void setComment_Section(String comment_Section) {
			this.treatment_comment_Section = comment_Section;
		}

		public List<Disease> getDiseases() {
			return diseases;
		}

		public void setDiseases(List<Disease> diseases) {
			this.diseases = diseases;
		}


		public List<Diagnosis> getDiagnosis() {
			return diagnosis;
		}



		public void setDiagnosis(List<Diagnosis> diagnosis) {
			this.diagnosis = diagnosis;
		}


		@Override
		public int hashCode() {
			return Objects.hash(idTreatment);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Treatment other = (Treatment) obj;
			return Objects.equals(idTreatment, other.idTreatment);
		}



		@Override
		public String toString() {
			return "\n Treatment [idTreatment=" + idTreatment + ", nameTreatment=" + nameTreatment + ", comment_Section="
					+ treatment_comment_Section + "]";
		}


		
		
}
