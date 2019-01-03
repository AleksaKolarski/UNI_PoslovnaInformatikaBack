package com.projekat.poslovna.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DocumentItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int quantity;
	@Column(nullable= false, precision=10, scale=2)
	private BigDecimal price;
	@Column(nullable= false, precision=10, scale=2)
	private BigDecimal value;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Article article;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Document document;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof DocumentItem)) {
			return false;
		}
		DocumentItem documentItem = (DocumentItem) o;
		return id == documentItem.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
