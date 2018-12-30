package com.projekat.poslovna.entity;
/**
 * Magacin
 * @author alowishusad
 *
 */

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Warehouse {
	private int id;
	private String name;
	private String address;

	private Company company;
	private Set<ArticleCard> articleCards = new HashSet<>();
	private Set<Document> documents = new HashSet<>();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<ArticleCard> getArticleCards() {
		return articleCards;
	}

	public void setArticleCards(Set<ArticleCard> articleCards) {
		this.articleCards = articleCards;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
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
		if (!(o instanceof Warehouse)) {
			return false;
		}
		Warehouse warehouse = (Warehouse) o;
		return id == warehouse.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
