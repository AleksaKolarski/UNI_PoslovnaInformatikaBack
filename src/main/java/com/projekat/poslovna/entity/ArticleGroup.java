package com.projekat.poslovna.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ArticleGroup {
	private int id;
	private String name;

	private Company company;
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
