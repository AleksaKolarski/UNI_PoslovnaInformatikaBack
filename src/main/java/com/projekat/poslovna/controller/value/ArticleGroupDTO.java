package com.projekat.poslovna.controller.value;

import com.projekat.poslovna.entity.ArticleGroup;
import lombok.Getter;

/**
 * Created by milan.miljus on 8/24/19 5:11 PM.
 */
@Getter
public class ArticleGroupDTO {

    private int id;
    private String name;

    public ArticleGroupDTO(ArticleGroup articleGroup) {
        this.id = articleGroup.getId();
        this.name = articleGroup.getName();
    }

}
