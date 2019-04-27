package com.projekat.poslovna.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 17:21.
 */
@Entity
@Data
public class ArticleCard extends BaseEntity {

    private long price;
    private long startStateValue;
    private long inValue;
    private long outValue;
    private long sumValue;

    @ManyToOne(optional = false)
    private Article article;

    @OneToMany(mappedBy = "articleCard")
    private List<ArticleCardAnalytics> articleCardAnalytics;

    @ManyToOne
    private FiscalYear fiscalYear;
}
