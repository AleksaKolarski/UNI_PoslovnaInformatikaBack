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
public class ArticleGroup {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=255, unique=true, nullable=false)
	private String name;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Company company;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="articleGroup")
	private Set<Article> articles = new HashSet<>();

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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Article> getArticle() {
		return articles;
	}

	public void setArticle(Set<Article> articles) {
		this.articles = articles;
	}

	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof ArticleGroup)) {
            return false;
        }
        ArticleGroup articleGroup = (ArticleGroup) o;
        return id == articleGroup.id &&
        		name.equals(articleGroup.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
