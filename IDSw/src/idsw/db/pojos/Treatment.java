package idsw.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Treatment implements Serializable{

	
		/**
		* 
	 	*/
		private static final long serialVersionUID = -3878390729908698825L;
		private Integer idTreatment;
		private String nameTreatment;
		private String comment_Section;
		private List<Disease> diseases;
		private Diagnosis diagnosis;
	
		public Treatment() {
			super();
			this.diseases = new ArrayList<Disease>();
		}

		
		
		public Treatment(Integer idTreatment, String nameTreatment, String comment_Section) {
			super();
			this.idTreatment = idTreatment;
			this.nameTreatment = nameTreatment;
			this.comment_Section = comment_Section;
		}

		public Treatment(String nameTreatment, String comment_Section) {
			super();
			this.nameTreatment = nameTreatment;
			this.comment_Section = comment_Section;
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
			return comment_Section;
		}

		public void setComment_Section(String comment_Section) {
			this.comment_Section = comment_Section;
		}

		public List<Disease> getDiseases() {
			return diseases;
		}

		public void setDiseases(List<Disease> diseases) {
			this.diseases = diseases;
		}

		public Diagnosis getDiagnosis() {
			return diagnosis;
		}

		public void setDiagnosis(Diagnosis diagnosis) {
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
			return "Treatment [idTreatment=" + idTreatment + ", nameTreatment=" + nameTreatment + "]";
		}
		
}
