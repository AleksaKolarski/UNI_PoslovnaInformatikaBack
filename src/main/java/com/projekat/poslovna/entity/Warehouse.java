package com.projekat.poslovna.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Warehouse extends BaseEntity {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String address;

    @OneToMany(mappedBy = "warehouse")
    private List<ArticleCard> articleCards;

    public List<Article> getArticles() {
        return articleCards.stream().map(ArticleCard::getArticle).collect(Collectors.toList());
    }

}
