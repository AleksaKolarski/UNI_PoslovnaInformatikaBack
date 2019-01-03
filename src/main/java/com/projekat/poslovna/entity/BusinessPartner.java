package com.projekat.poslovna.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BusinessPartner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	// TODO private char type; ovo nisam siguran sta je uopste
	@Column(length=255, nullable=false)
	private String name;
	@Column(length=9, nullable=false)
	private String PIB;
	@Column(length=255, nullable=false)
	private String address;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private City city;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Company company; // partner kog preduzeca, moze ih biti vise
	@OneToMany(fetch=FetchType.LAZY, mappedBy="businessPartner")
	private Set<Document> documents = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPIB() {
		return PIB;
	}

	public void setPIB(String pIB) {
		PIB = pIB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof BusinessPartner)) {
			return false;
		}
		BusinessPartner businessPartner = (BusinessPartner) o;
		return id == businessPartner.id &&
				name.equals(businessPartner.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

}
