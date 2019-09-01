package com.projekat.poslovna.controller.value;

import com.projekat.poslovna.entity.ArticleCard;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ArticleCardDTO {

    private int quantity; // trenutna kolicina
    private Long calculatedPrice; // kalkulisana cena, quantity / value
    private Long value;

    private int startStateQuantity; // pocetno stanje na pocetku fiskalne godine
    private long startStateValue;

    private int inQuantity; // ukupna ulazna kolicina
    private long inValue;

    private int outQuantity; // ukupna izlazna kolicina
    private long outValue;

    @NotNull
    private ArticleDTO article;

    public ArticleCardDTO(ArticleCard articleCard) {
        this.quantity = articleCard.getQuantity();
        this.startStateQuantity = articleCard.getStartStateQuantity();
        this.startStateValue = articleCard.getStartStateValue();
        this.inQuantity = articleCard.getInQuantity();
        this.inValue = articleCard.getInValue();
        this.outQuantity = articleCard.getOutQuantity();
        this.outValue = articleCard.getOutValue();
        this.value = articleCard.getValue();

        this.calculatedPrice = articleCard.getCalculatedPrice();

        this.article = new ArticleDTO(articleCard.getArticle());
    }

}
