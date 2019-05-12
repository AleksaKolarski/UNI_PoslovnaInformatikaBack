package com.projekat.poslovna.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 16:09.
 */
@Entity
@Data
@NoArgsConstructor
public class Article extends BaseEntity {

    @NotBlank
    @Column(unique = true)
    private String name;

    @ManyToOne
    private Unit unit;

    @ManyToOne(optional = false)
    @JoinColumn
    private ArticleGroup articleGroup;

    @OneToMany(mappedBy = "article")
    private List<ArticleCard> articleCards;

    @OneToMany(mappedBy = "article")
    private List<DocumentItem> documentItems;

    public Article(String name, Unit unit, ArticleGroup articleGroup) {
        this.name = name;
        this.unit = unit;
        this.articleGroup = articleGroup;
    }
}
