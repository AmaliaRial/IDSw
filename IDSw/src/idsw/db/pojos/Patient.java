package idsw.db.pojos;

import java.io.Serializable;

import java.sql.Date;
import java.util.Objects;

import idsw.db.jdbc.*;

public class Patient implements Serializable{
	
		/**
		* 
	 	*/
		private static final long serialVersionUID = -4979690235303387303L;
		private Integer idPatient;
		private String namePatient;
		private String surname;
		private Date dob; //Recordad que para Date hay que importar java.sql.Date
		private Medical_Record medicalRecord;
		private String username; //add to the database in the create tables
		
		public Patient() {
			super();
		}


		public Patient(int idPatient, String namePatient, String surname, Date dob) {
			super();
			this.idPatient = idPatient;
			this.namePatient = namePatient;
			this.surname = surname;
			this.dob = dob;
		}


		public Patient(String namePatient, String surname, Date dob) {
			super();
			this.namePatient = namePatient;
			this.surname = surname;
			this.dob = dob;
		}


		public Integer getIdPatient() {
			return idPatient;
		}


		public void setIdPatient(Integer idPatient) {
			this.idPatient = idPatient;
		}


		public String getNamePatient() {
			return namePatient;
		}


		public void setNamePatient(String namePatient) {
			this.namePatient = namePatient;
		}


		public String getSurname() {
			return surname;
		}


		public void setSurname(String surname) {
			this.surname = surname;
		}


		public Date getDob() {
			return dob;
		}


		public void setDob(Date dob) {
			this.dob = dob;
		}


		public Medical_Record getMedicalRecord() {
			return medicalRecord;
		}


		public void setMedicalRecord(Medical_Record medicalRecord) {
			this.medicalRecord = medicalRecord;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		@Override
		public int hashCode() {
			return Objects.hash(idPatient);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Patient other = (Patient) obj;
			return Objects.equals(idPatient, other.idPatient);
		}


		@Override
		public String toString() {
			return "Patient [idPatient=" + idPatient + ", namePatient=" + namePatient + ", surname=" + surname
					+ ", dob=" + dob + ", username=" + username + "]";
		}


	    	
		

}
