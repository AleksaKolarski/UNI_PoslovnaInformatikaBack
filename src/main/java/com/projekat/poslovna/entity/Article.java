package com.projekat.poslovna.entity;

import com.projekat.poslovna.entity.enums.UnitEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 16:09.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article extends BaseEntity {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UnitEnum unit;

    @NotNull
    @ManyToOne
    @JoinColumn
    private ArticleGroup articleGroup;

    @OneToMany(mappedBy = "article")
    private List<ArticleCard> articleCards;

    @OneToMany(mappedBy = "article")
    private List<DocumentItem> documentItems;

    public Article(String name, UnitEnum unit, ArticleGroup articleGroup) {
        this.name = name;
        this.unit = unit;
        this.articleGroup = articleGroup;
    }
}
