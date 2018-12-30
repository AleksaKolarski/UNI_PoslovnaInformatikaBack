package com.projekat.poslovna.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class DocumentItem {
	private int id;
	private int quantity;
	private BigDecimal price;
	private BigDecimal value;

	private Article article;
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
