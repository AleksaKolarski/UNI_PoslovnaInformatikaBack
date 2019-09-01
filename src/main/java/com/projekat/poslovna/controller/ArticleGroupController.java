package com.projekat.poslovna.controller;

import com.projekat.poslovna.controller.value.ArticleGroupDTO;
import com.projekat.poslovna.entity.ArticleGroup;
import com.projekat.poslovna.service.ArticleGroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by milan.miljus on 8/24/19 5:29 PM.
 */
@RestController
@RequestMapping("/article-groups")
@AllArgsConstructor
public class ArticleGroupController {

    private final ArticleGroupService articleGroupService;

    @GetMapping
    public ResponseEntity<List<ArticleGroupDTO>> getArticleGroups() {
        final List<ArticleGroup> articleGroups = articleGroupService.getArticleGroups();
        final List<ArticleGroupDTO> articleGroupDTOS = articleGroups.stream().map(ArticleGroupDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(articleGroupDTOS, HttpStatus.OK);
    }

}
