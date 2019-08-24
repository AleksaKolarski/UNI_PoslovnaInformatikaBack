package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.ArticleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 8/24/19 5:30 PM.
 */
@Repository
public interface ArticleGroupRepository extends JpaRepository<ArticleGroup, Integer> {
}
