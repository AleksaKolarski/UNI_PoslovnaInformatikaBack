package com.projekat.poslovna.service;

import java.util.List;

import com.projekat.poslovna.entity.Article;
import com.projekat.poslovna.entity.ArticleGroup;

public interface ArticleService {
	
	Article findById(int id);
	
	List<Article> findByArticleGroup(ArticleGroup articleGroup);
	
	List<Article> findAll();
	
	Article save(Article article);
	
	Article update(Article article);
	
	void delete(Article article);
}
