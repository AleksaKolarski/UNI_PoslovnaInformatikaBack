package com.projekat.poslovna.controller;

import com.projekat.poslovna.controller.value.ArticleCardDTO;
import com.projekat.poslovna.entity.ArticleCard;
import com.projekat.poslovna.service.ArticleCardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by milan.miljus on 8/24/19 5:43 PM.
 */
@RestController
@RequestMapping
@AllArgsConstructor
public class ArticleCardController {

    private final ArticleCardService articleCardService;

    @GetMapping("/warehouses/{warehouseId}/article-cards")
    public ResponseEntity<List<ArticleCardDTO>> getArticleCardsForWarehouse(@PathVariable int warehouseId) {
        final List<ArticleCard> articleCards = articleCardService.getArticleCardsForWarehouse(warehouseId);
        final List<ArticleCardDTO> articleCardDTOs = articleCards.stream().map(ArticleCardDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(articleCardDTOs, HttpStatus.OK);
    }

    @GetMapping("/warehouses/{warehouseId}/article-groups/{articleGroupId}/article-cards")
    public ResponseEntity<List<ArticleCardDTO>> getArticleCardsForArticleGroupId(@PathVariable int warehouseId, @PathVariable int articleGroupId) {
        final List<ArticleCard> articleCards = articleCardService.getArticleCardsByArticleGroup(warehouseId, articleGroupId);
        final List<ArticleCardDTO> articleCardDTOs = articleCards.stream().map(ArticleCardDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(articleCardDTOs, HttpStatus.OK);
    }

    @GetMapping("/article-cards/{articleCardId}")
    public ResponseEntity<ArticleCardDTO> getArticleCardById(@PathVariable int articleCardId) {
        final ArticleCard articleCard = articleCardService.getById(articleCardId);
        return new ResponseEntity<>(new ArticleCardDTO(articleCard), HttpStatus.OK);
    }



}
