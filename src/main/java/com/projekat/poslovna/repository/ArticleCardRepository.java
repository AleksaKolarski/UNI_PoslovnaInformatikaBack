package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.ArticleCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 8/24/19 5:36 PM.
 */
@Repository
public interface ArticleCardRepository extends JpaRepository<ArticleCard, Integer> {


}
