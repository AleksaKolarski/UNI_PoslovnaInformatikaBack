package com.projekat.poslovna.entity;

import java.sql.Timestamp;
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
public class FiscalYear {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private int year;
	@Column(columnDefinition="boolean default false")
	private boolean concluded;
	@Column
	private Timestamp startedOn;
	@Column
	private Timestamp endedOn;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Company company;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="fiscalYear")
	private Set<ArticleCard> articleCards = new HashSet<>();
	@OneToMany(fetch=FetchType.LAZY, mappedBy="fiscalYear")
	private Set<Document> documents = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isConcluded() {
		return concluded;
	}

	public void setConcluded(boolean concluded) {
		this.concluded = concluded;
	}

	public Timestamp getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(Timestamp startedOn) {
		this.startedOn = startedOn;
	}

	public Timestamp getEndedOn() {
		return endedOn;
	}

	public void setEndedOn(Timestamp endedOn) {
		this.endedOn = endedOn;
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

	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof FiscalYear)) {
			return false;
		}
		FiscalYear fiscalYear = (FiscalYear) o;
		return id == fiscalYear.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
