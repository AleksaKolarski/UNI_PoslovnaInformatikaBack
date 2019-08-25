package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.ArticleCardAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 8/25/19 2:09 PM.
 */
@Repository
public interface ArticleCardAnalyticsRepository extends JpaRepository<ArticleCardAnalytics, Integer> {
}
