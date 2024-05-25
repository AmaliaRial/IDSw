package idsw.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//xml anotations
@XmlAccessorType(XmlAccessType.FIELD) //allows it to be turned into an xml
@XmlRootElement(name = "MedicalRecord") // allows it to be a root element 
@XmlType(propOrder = { "patient", "diagnoses"}) // specify the order inside the xml
public class Medical_Record implements Serializable{
	
		/**
		* 
	 	*/
		private static final long serialVersionUID = 5652570545720874192L;
		@XmlTransient
		private Integer idMedical_Record;
		@XmlElement(name = "Diagnosis") //each element in the list is a diagnosis
		@XmlElementWrapper(name = "Diagnoses")
		private List<Diagnosis> diagnoses;
		@XmlElement(name = "Patient")// <Medical Record><Patient>...</Patient></Medical Record>  that's why its an element, an attribute goes inside
		private Patient patient;
				
		public Medical_Record() {
			super();
			this.diagnoses = new ArrayList<Diagnosis>();
		}

		public Medical_Record(Integer idMedical_Record, Patient patient) {
			super();
			this.idMedical_Record = idMedical_Record;
			this.patient = patient;
		}
		
		
		public Integer getIdMedical_Record() {
			return idMedical_Record;
		}

		public void setIdMedical_Record(Integer idMedical_Record) {
			this.idMedical_Record = idMedical_Record;
		}
		
		public Patient getPatient() {
			return patient;
		}

		public void setPatient(Patient patient) {
			this.patient = patient;
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
			return "Medical_Record [id = " + idMedical_Record + ", "
					+ patient + "]";
		}
		
}
