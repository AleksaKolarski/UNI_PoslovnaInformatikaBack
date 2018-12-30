package com.projekat.poslovna.entity;
/**
 * Klasa predstavlja jednu promenu stanja robne kartice (ArticleCard)
 * @author alowishusad
 *
 */

import java.math.BigDecimal;
import java.util.Objects;

public class ArticleCardAnalytics {
	private int id;
	private int serialNumber; // da li je ovo potrebno uopste????
	private char type; // TODO type neka stoji char za sad, ovo bi trebali menjat;
	private char direction; // TODO mozda da stavimo boolean??? directionIn, pa ako je true onda je ulazna
	private int quantity;
	private BigDecimal price;
	private BigDecimal value;

	private ArticleCard articleCard;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
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

	public ArticleCard getArticleCard() {
		return articleCard;
	}

	public void setArticleCard(ArticleCard articleCard) {
		this.articleCard = articleCard;
	}
	
	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof ArticleCardAnalytics)) {
            return false;
        }
        ArticleCardAnalytics articleCardAnalytics = (ArticleCardAnalytics) o;
        return id == articleCardAnalytics.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
