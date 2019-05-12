package com.projekat.poslovna.entity;

import lombok.Builder;
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
@Builder
public class ArticleCard extends BaseEntity {

    private long price;
    private long startStateValue;
    private long inValue;
    private long outValue;

    @ManyToOne(optional = false)
    private Article article;

    @OneToMany(mappedBy = "articleCard")
    private List<ArticleCardAnalytics> articleCardAnalytics;

    @ManyToOne
    private FiscalYear fiscalYear;

    public long getSumValue(){
        return -420; // TODO: 09 May 2019 15:30 milan.miljus nisam siguran sta je ovo
    }
}
