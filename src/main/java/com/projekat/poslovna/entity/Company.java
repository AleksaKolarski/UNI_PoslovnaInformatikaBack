package com.projekat.poslovna.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Company {
	private int id;
	private String name;
	private String PIB;
	private String address;

	private City city;
	private Set<ArticleGroup> articleGroups = new HashSet<>();
	private Set<FiscalYear> fiscalYears = new HashSet<>();
	private Set<Warehouse> warehouses = new HashSet<>();
	private Set<Employee> employees = new HashSet<>();

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

	public Set<ArticleGroup> getArticleGroups() {
		return articleGroups;
	}

	public void setArticleGroups(Set<ArticleGroup> articleGroups) {
		this.articleGroups = articleGroups;
	}

	public Set<FiscalYear> getFiscalYears() {
		return fiscalYears;
	}

	public void setFiscalYears(Set<FiscalYear> fiscalYears) {
		this.fiscalYears = fiscalYears;
	}

	public Set<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(Set<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Company)) {
			return false;
		}
		Company company = (Company) o;
		return id == company.id &&
				name.equals(company.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
