package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 8/24/19 2:13 PM.
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
