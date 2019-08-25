package com.projekat.poslovna.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 17:21.
 */
@Entity
@Getter
@Setter
public class ArticleCard extends BaseEntity {

//    @Column(columnDefinition = "int default 0")
//    private int quantity;
//    @Column(columnDefinition = "bigint default null")
//    private Long price; // srednja kupovna

    @Column(columnDefinition = "int default 0")
    private int startStateQuantity;
    @Column(columnDefinition = "bigint default 0")
    private long startStatePrice;

    @Column(columnDefinition = "int default 0")
    private int inQuantity;
    @Column(columnDefinition = "bigint default 0")
    private long inPrice;

    @Column(columnDefinition = "int default 0")
    private int outQuantity;
    @Column(columnDefinition = "bigint default 0")
    private long outPrice;

    @NotNull
    @ManyToOne(optional = false)
    private Article article;

    @OneToMany(mappedBy = "articleCard")
    private List<ArticleCardAnalytics> articleCardAnalytics;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private FiscalYear fiscalYear;

    public ArticleGroup getArticleGroup() {
        return this.article.getArticleGroup();
    }

    public int getQuantity() {
        return this.startStateQuantity + this.inQuantity - this.outQuantity;
    }

    public Long getPrice() {
        long price = this.startStatePrice + this.inPrice - this.outPrice;
        return price == 0 ? null : price;
    }

}
