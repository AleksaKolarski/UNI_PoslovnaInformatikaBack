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
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false, length=255)
	private String name;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Unit unit;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private ArticleGroup articleGroup;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="article")
	private Set<ArticleCard> articleCards = new HashSet<>();
	@OneToMany(fetch=FetchType.LAZY, mappedBy="article")
	private Set<DocumentItem> documentItems = new HashSet<>();
	
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

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Article)) {
            return false;
        }
        Article article = (Article) o;
        return id == article.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
