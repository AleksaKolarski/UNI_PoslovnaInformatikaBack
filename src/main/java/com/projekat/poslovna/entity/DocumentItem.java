package com.projekat.poslovna.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

/**
 * Created by milan.miljus on 2019-04-27 19:21.
 */
@Entity
@Getter
@Setter
public class DocumentItem extends BaseEntity {

    @Positive
    private int quantity;

    @Positive
    private long price;

    @ManyToOne
    private Article article;

    @ManyToOne
    private Document document;

    public long getValue() {
        return quantity * price;
    }

    public int  getArticleId() {
        return article.getId();
    }
}
