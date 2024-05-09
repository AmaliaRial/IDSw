package idsw.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Medical_Record implements Serializable{
	
		/**
		* 
	 	*/
		private static final long serialVersionUID = 5652570545720874192L;
		private Integer idMedical_Record;
		private List<Diagnosis> diagnoses;
		private Integer idPatient;
		
		//tengo duda nose si poner patient o el id
		
		public Medical_Record() {
			super();
			this.diagnoses = new ArrayList<Diagnosis>();
		}

		public Medical_Record(Integer idMedical_Record, Integer idPatient) {
			super();
			this.idMedical_Record = idMedical_Record;
			this.idPatient = idPatient;
		}
		
		
		public Integer getIdMedical_Record() {
			return idMedical_Record;
		}

		public void setIdMedical_Record(Integer idMedical_Record) {
			this.idMedical_Record = idMedical_Record;
		}
		
		public Integer getIdPatient() {
			return idPatient;
		}

		public void setIdPatient(Integer idPatient) {
			this.idPatient = idPatient;
		}

		public List<Diagnosis> getDiagnoses() {
			return diagnoses;
		}

		public void setDiagnoses(List<Diagnosis> diagnoses) {
			this.diagnoses = diagnoses;
		}

		

		@Override
		public int hashCode() {
			return Objects.hash(idMedical_Record);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Medical_Record other = (Medical_Record) obj;
			return Objects.equals(idMedical_Record, other.idMedical_Record);
		}

		@Override
		public String toString() {
			return "Medical_Record [idMedical_Record=" + idMedical_Record + ", idPatient="
					+ idPatient + "]";
		}
		
		
		

}
