package com.projekat.poslovna.controller.value;

import com.projekat.poslovna.entity.ArticleCard;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ArticleCardDTO {

    private int quantity;
    private Long price;

    private long startStatePrice;
    private int startStateQuantity;

    private int inQuantity;
    private long inPrice;

    private int outQuantity;
    private long outPrice;

    @NotNull
    private ArticleDTO article;

    public ArticleCardDTO(ArticleCard articleCard) {
        this.quantity = articleCard.getQuantity();
        this.price = articleCard.getPrice();
        this.startStatePrice = articleCard.getStartStatePrice();
        this.startStateQuantity = articleCard.getStartStateQuantity();
        this.inQuantity = articleCard.getInQuantity();
        this.inPrice = articleCard.getInPrice();
        this.outQuantity = articleCard.getOutQuantity();
        this.outPrice = articleCard.getOutPrice();
        this.article = new ArticleDTO(articleCard.getArticle());
    }

}
