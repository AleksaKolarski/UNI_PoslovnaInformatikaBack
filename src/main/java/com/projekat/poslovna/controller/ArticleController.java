package com.projekat.poslovna.controller;

import com.projekat.poslovna.controller.value.ArticleCreateDTO;
import com.projekat.poslovna.controller.value.ArticleDTO;
import com.projekat.poslovna.controller.value.IdWrapper;
import com.projekat.poslovna.entity.Article;
import com.projekat.poslovna.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by milan.miljus on 8/24/19 2:11 PM.
 */
@RestController
@RequestMapping("/articles")
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAll() {
        final List<Article> articles = articleService.getAll();
        final List<ArticleDTO> articleDTOS = articles.stream().map(ArticleDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(articleDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IdWrapper> createArticle(@RequestBody @Valid ArticleCreateDTO articleCreateDTO) {
        final int articleId = articleService.createArticle(articleCreateDTO);
        return new ResponseEntity<>(IdWrapper.of(articleId), HttpStatus.CREATED);
    }

}
