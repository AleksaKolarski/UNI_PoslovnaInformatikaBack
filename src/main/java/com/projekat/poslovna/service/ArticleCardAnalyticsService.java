package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.ArticleCardAnalytics;
import com.projekat.poslovna.repository.ArticleCardAnalyticsRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-04 20:57.
 */
@Service
public class ArticleCardAnalyticsService extends CrudImpl<ArticleCardAnalytics> {

    public ArticleCardAnalyticsService(ArticleCardAnalyticsRepo repo) {
        super(repo);
    }

}
