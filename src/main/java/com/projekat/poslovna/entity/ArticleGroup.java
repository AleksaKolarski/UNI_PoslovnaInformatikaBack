package com.projekat.poslovna.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 17:26.
 */
@Entity
@Data
@NoArgsConstructor
public class ArticleGroup extends BaseEntity {

    @NotBlank
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "articleGroup")
    private List<Article> articles;

    public ArticleGroup(String name) {
        this.name = name;
    }
}
