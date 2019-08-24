package com.projekat.poslovna.controller.value;

import com.projekat.poslovna.entity.Article;
import com.projekat.poslovna.entity.enums.UnitEnum;
import lombok.Getter;

/**
 * Created by milan.miljus on 8/24/19 2:15 PM.
 */
@Getter
public class ArticleDTO {

    private int id;

    private String name;

    private UnitEnum unit;

    private String articleGroupName;

    public ArticleDTO(Article article) {
        this.id = article.getId();
        this.name = article.getName();
        this.unit = article.getUnit();
        this.articleGroupName = article.getArticleGroup().getName();
    }
}
