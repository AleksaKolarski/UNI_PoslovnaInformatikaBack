package com.projekat.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekat.poslovna.entity.ArticleCardAnalytics;

@Repository
public interface ArticleCardAnalysisRepo extends JpaRepository<ArticleCardAnalytics, Integer>{
	
}
