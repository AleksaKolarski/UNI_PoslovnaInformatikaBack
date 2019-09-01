package com.projekat.poslovna.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class DocumentItem extends BaseEntity {

//    @Positive
    private int quantity;

//    @Positive
    private Long price;

    @ManyToOne
    private Article article;

    @NotNull
    @ManyToOne
    private Document document;

    public long getValue() {
        return quantity * price;
    }

    public int  getArticleId() {
        return article.getId();
    }
}
