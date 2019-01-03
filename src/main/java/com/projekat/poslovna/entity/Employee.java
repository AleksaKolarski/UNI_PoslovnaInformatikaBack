package com.projekat.poslovna.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=25, nullable=false) 
	private String firstName;
	@Column(length=25, nullable=false) 
	private String lastName;
	@Column(length=25, unique=true, nullable=false) 
	@Email
	private String email;
	@Column(length=25, nullable=false) 
	private String password;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role", nullable=false)
	private Role role;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company", nullable=false)
	private Company company;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="warehouse", nullable=false)
	private Warehouse warehouse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Employee)) {
			return false;
		}
		Employee employee = (Employee) o;
		return id == employee.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
