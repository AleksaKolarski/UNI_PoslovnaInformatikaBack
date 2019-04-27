package com.projekat.poslovna.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by milan.miljus on 2019-04-27 17:24.
 */
@Entity
@Data
public class ArticleCardAnalytics extends BaseEntity {

    private DocumentType direction;
    private long price;
    private int quantity;
    private long value;

    @ManyToOne(optional = false)
    private Article article;

    @ManyToOne
    private ArticleCard articleCard;

}
