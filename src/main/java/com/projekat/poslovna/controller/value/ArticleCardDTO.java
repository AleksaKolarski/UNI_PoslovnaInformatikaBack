package com.projekat.poslovna.controller.value;

import com.projekat.poslovna.entity.ArticleCard;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ArticleCardDTO {

    private int quantity; // trenutna kolicina
    private Long price; // prosecna kupovna cena
    private Long value;

    private int startStateQuantity; // pocetno stanje na pocetku fiskalne godine
    private long startStatePrice; // pocetna prosecna kupovna cena na pocetku fiskalne godine
    private long startStateValue;

    private int inQuantity; // ukupna ulazna kolicina
    private long inPrice; // ukupna ulazna cena
    private long inValue;

    private int outQuantity; // ukupna izlazna kolicina
    private long outPrice; // ukupna izlazna cena
    private long outValue;

    @NotNull
    private ArticleDTO article;

    public ArticleCardDTO(ArticleCard articleCard) {
        this.quantity = articleCard.getQuantity();
        this.price = articleCard.getPrice();
        this.value = price != null ? quantity * price : null;

        this.startStatePrice = articleCard.getStartStatePrice();
        this.startStateQuantity = articleCard.getStartStateQuantity();
        this.inQuantity = articleCard.getInQuantity();
        this.inPrice = articleCard.getInPrice();
        this.outQuantity = articleCard.getOutQuantity();
        this.outPrice = articleCard.getOutPrice();
        this.article = new ArticleDTO(articleCard.getArticle());

        this.startStateValue = startStateQuantity * startStatePrice;
        this.inValue = inQuantity * inPrice;
        this.outValue = outQuantity * outPrice;
    }

}
