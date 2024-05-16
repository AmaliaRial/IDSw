package idsw.db.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.*;

import idsw.db.enums.Sex;

@Entity
@Table(name="users")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2454800077990284437L;
	@Id
	@GeneratedValue(generator = "users")
	@TableGenerator(name = "users", table = "sqlite_sequence",
	pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "users") //notice how the 3 employees here match the name of the @Table
	private Long roleVerificationNumber;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Date dob;
	@Column(nullable = false)
	private Sex sex;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private Integer phoneNumber;
	@Column(nullable = false, unique = true)
	private String dni;	
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;

	public User() {
		super();
	}
	
	public User(String dni,Date dob, String email, String name, String password, Long roleVerificationNumber, Integer phoneNumber, String sex, String surname, String username, Role role) {
        super();
        this.dni = dni;
        this.dob = dob;
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.roleVerificationNumber = roleVerificationNumber;
        this.sex = Sex.valueOf(sex.toUpperCase());
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role = role;
        }


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public Long getRoleVerificationNumber() {
		return roleVerificationNumber;
	}

	public void setRoleVerificationNumber(Long roleVerificationNumber) {
		this.roleVerificationNumber = roleVerificationNumber;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(roleVerificationNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(roleVerificationNumber, other.roleVerificationNumber);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", username=" + username + ", password="
				+ password + ", dob=" + dob + ", sex=" + sex + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", dni=" + dni + ", role=" + role + "]";
	}
	
	
}
