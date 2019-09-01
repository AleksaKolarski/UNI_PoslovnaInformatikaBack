package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.ArticleCardAnalytics;
import com.projekat.poslovna.repository.ArticleCardAnalyticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by milan.miljus on 9/1/19 3:48 PM.
 */
@Service
@RequiredArgsConstructor
public class ArticleCardAnalyticsService {

    private final ArticleCardAnalyticsRepository articleCardAnalyticsRepository;

    @Transactional(rollbackFor = Throwable.class, readOnly = true)
    public List<ArticleCardAnalytics> getAnalyticsForArticleCard(int articleCardId) {
        return articleCardAnalyticsRepository.findByArticleCardId(articleCardId);
    }

}
