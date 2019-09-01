package com.projekat.poslovna.controller;

import com.projekat.poslovna.controller.value.ArticleCardAnalyticsDTO;
import com.projekat.poslovna.entity.ArticleCardAnalytics;
import com.projekat.poslovna.service.ArticleCardAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by milan.miljus on 9/1/19 3:48 PM.
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
public class ArticleCardAnalyticsController {

    private final ArticleCardAnalyticsService articleCardAnalyticsService;

    @GetMapping("/article-cards/{articleCardId}/analytics")
    private ResponseEntity<List<ArticleCardAnalyticsDTO>> getAnalyticsForArticleCard(@PathVariable int articleCardId) {
        final List<ArticleCardAnalytics> analyticsForArticleCard = articleCardAnalyticsService.getAnalyticsForArticleCard(articleCardId);
        final List<ArticleCardAnalyticsDTO> articleCardAnalyticsDTOS =
                analyticsForArticleCard.stream().map(ArticleCardAnalyticsDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(articleCardAnalyticsDTOS, HttpStatus.OK);
    }


}
