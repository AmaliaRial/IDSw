package idsw.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import idsw.db.enums.*;

public class Symptom implements Serializable{
			
		/**
		* 
	 	*/
		private static final long serialVersionUID = 1286149037602845323L;
		private Integer idSymptom;
		private String nameSymptom;
		private pain_management pain_management;
		private List<Disease> diseases;
		
		
		public Symptom() {
			super();
			this.diseases = new ArrayList<Disease>();
		}


		public Integer getIdSymptom() {
			return idSymptom;
		}


		public void setIdSymptom(Integer idSymptom) {
			this.idSymptom = idSymptom;
		}


		public String getNameSymptom() {
			return nameSymptom;
		}


		public void setNameSymptom(String nameSymptom) {
			this.nameSymptom = nameSymptom;
		}


		public pain_management getPain_management() {
			return pain_management;
		}


		public void setPain_management(pain_management pain_management) {
			this.pain_management = pain_management;
		}


		public List<Disease> getDiseases() {
			return diseases;
		}


		public void setDiseases(List<Disease> diseases) {
			this.diseases = diseases;
		}


		@Override
		public int hashCode() {
			return Objects.hash(idSymptom);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Symptom other = (Symptom) obj;
			return Objects.equals(idSymptom, other.idSymptom);
		}


		@Override
		public String toString() {
			return "Symptom [idSymptom=" + idSymptom + ", nameSymptom=" + nameSymptom + ", pain_management="
					+ pain_management + ", diseases=" + diseases + "]";
		}
		
		
}
