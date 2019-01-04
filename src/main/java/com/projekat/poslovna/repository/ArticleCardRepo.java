package com.projekat.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekat.poslovna.entity.ArticleCard;

@Repository
public interface ArticleCardRepo extends JpaRepository<ArticleCard, Integer> {

}
