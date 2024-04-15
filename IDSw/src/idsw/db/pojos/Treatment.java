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
		private List<Disease> diseases;
		private Diagnosis diagnoses;
		
		public Treatment() {
			super();
			this.diseases = new ArrayList<Disease>();
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

		public List<Disease> getDiseases() {
			return diseases;
		}

		public void setDiseases(List<Disease> diseases) {
			this.diseases = diseases;
		}

		public Diagnosis getDiagnoses() {
			return diagnoses;
		}

		public void setDiagnoses(Diagnosis diagnoses) {
			this.diagnoses = diagnoses;
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
			return "Treatment [idTreatment=" + idTreatment + ", nameTreatment=" + nameTreatment + ", diseases="
					+ diseases + ", diagnoses=" + diagnoses + "]";
		}
		
}