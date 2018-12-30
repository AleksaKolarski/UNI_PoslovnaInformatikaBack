package com.projekat.poslovna.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Unit {
	private int id;
	private String name;
	
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

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	
	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Unit)) {
			return false;
		}
		Unit unit = (Unit) o;
		return id == unit.id &&
				name.equals(unit.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
