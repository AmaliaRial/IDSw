package idsw.db.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Diagnosis implements Serializable{
	
		/**
		* 
	 	*/
		private static final long serialVersionUID = -8121246897885234549L;
		private Integer idDiagnosis;
		private String nameDiagnosis;
		private Date date;
		private String comment_section;
		private Disease disease;
		private Medical_Record medicalRecord;
		private List<Treatment> treatments; 
		
		public Diagnosis() {
			super();
			this.setTreatments(new ArrayList<Treatment>());
		}
		
		
		
		public Diagnosis(Integer idDiagnosis, String nameDiagnosis, Date date, String comment_section) {
			super();
			this.idDiagnosis = idDiagnosis;
			this.nameDiagnosis = nameDiagnosis;
			this.date = date;
			this.comment_section = comment_section;
			
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

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
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
			return comment_section;
		}

		public void setComment_section(String comment_section) {
			this.comment_section = comment_section;
		}

		public void setMedicalRecord(Medical_Record medicalRecord) {
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
			return "Diagnosis [idDiagnosis=" + idDiagnosis + ", nameDiagnosis=" + nameDiagnosis + ", date=" + date
					+ ", disease=" + disease + ", medicalRecord=" + medicalRecord + "]";
		}
		
		

}
