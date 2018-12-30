package com.projekat.poslovna.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author alowishusad
 *
 */
public class City {

	private int id;
	private String name;

	private Set<BusinessPartner> businessPartners = new HashSet<>();
	private Set<Company> companies = new HashSet<>();

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

	public Set<BusinessPartner> getBusinessPartners() {
		return businessPartners;
	}

	public void setBusinessPartners(Set<BusinessPartner> businessPartners) {
		this.businessPartners = businessPartners;
	}

	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}
	
	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof City)) {
			return false;
		}
		City city = (City) o;
		return id == city.id &&
				name.equals(city.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

}
