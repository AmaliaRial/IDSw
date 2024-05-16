package idsw.db.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import idsw.db.xml.utils.SQLDateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Diagnosis")
@XmlType(propOrder = { "nameDiagnosis", "date","disease", "treatments", "diagnosis_comment_section" })
public class Diagnosis implements Serializable{
	
		/**
		* 
	 	*/
		private static final long serialVersionUID = -8121246897885234549L;
		@XmlAttribute
		private Integer idDiagnosis;
		@XmlAttribute
		private String nameDiagnosis;
		@XmlElement
		// Note the type adapter
		@XmlJavaTypeAdapter(SQLDateAdapter.class)
		private Date date;
		@XmlElement
		private String diagnosis_comment_section;
		@XmlElement
		private Disease disease;
		@XmlTransient
		private Medical_Record medicalRecord;
		@XmlElement(name = "Treatment")
		private List<Treatment> treatments; 
		
		public Diagnosis() {
			super();
			this.treatments = new ArrayList<Treatment>();
		}
		
		
		
		public Diagnosis(Integer idDiagnosis, String nameDiagnosis, Date localDate, String comment_section, Medical_Record medicalRecord,Disease disease) {
			super();
			this.idDiagnosis = idDiagnosis;
			this.nameDiagnosis = nameDiagnosis;
			this.date = localDate;
			this.diagnosis_comment_section = comment_section;
			this.medicalRecord = medicalRecord;
			this.disease = disease;
			this.treatments = new ArrayList<Treatment>();
			
			
		}		
		
		public Diagnosis( String nameDiagnosis, Date LocalDate, String comment_section, Medical_Record medicalRecord, Disease disease) {
			super();
			this.nameDiagnosis = nameDiagnosis;
			this.date = LocalDate;
			this.diagnosis_comment_section = comment_section;
			this.medicalRecord = medicalRecord;
			this.disease = disease;
			this.treatments = new ArrayList<Treatment>();
			
			
		}


		
		

		public Diagnosis(Integer idDiagnosis, String nameDiagnosis, Date date, String comment_section,
				Disease disease) {
			super();
			this.idDiagnosis = idDiagnosis;
			this.nameDiagnosis = nameDiagnosis;
			this.date = date;
			this.diagnosis_comment_section = comment_section;
			this.disease = disease;
		}



		public Integer getIdDiagnosis() {
			return idDiagnosis;
		}

		public void setIdDiagnosis(Integer idDiagnosis) {
			this.idDiagnosis = idDiagnosis;
		}

		public String getNameDiagnosis() {
			return nameDiagnosis;
		}

		public void setNameDiagnosis(String nameDiagnosis) {
			this.nameDiagnosis = nameDiagnosis;
		}

		public Date getLocalDate() {
			return date;
		}

		public void setLocalDate(Date localDate) {
			this.date = localDate;
		}

		public Disease getDisease() {
			return disease;
		}

		public void setDisease(Disease disease) {
			this.disease = disease;
		}

		public Medical_Record getMedicalRecord() {
			return medicalRecord;
		}

		public String getComment_section() {
			return diagnosis_comment_section;
		}

		public void setComment_section(String comment_section) {
			this.diagnosis_comment_section = comment_section;
		}

		public void seMedicalRecord(Medical_Record medicalRecord) {
			this.medicalRecord = medicalRecord;
		}

		public List<Treatment> getTreatments() {
			return treatments;
		}

		public void setTreatments(List<Treatment> treatments) {
			this.treatments = treatments;
		}

		@Override
		public int hashCode() {
			return Objects.hash(idDiagnosis);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Diagnosis other = (Diagnosis) obj;
			return Objects.equals(idDiagnosis, other.idDiagnosis);
		}

		@Override
		public String toString() {
			return "Diagnosis [idDiagnosis=" + idDiagnosis + ", nameDiagnosis=" + nameDiagnosis + ", LocalDate=" + date
					+ ", disease=" + disease + ", medicalRecord=" + medicalRecord + "]";
		}
		
		

}
