package com.projekat.poslovna.service;

import java.util.List;

import com.projekat.poslovna.entity.ArticleGroup;

public interface ArticleGroupService {
	
	ArticleGroup findById(int id);
	
	List<ArticleGroup> findAll();
	
	ArticleGroup save(ArticleGroup articleGroup);
	
	ArticleGroup update(ArticleGroup articleGroup);
	
	void delete(ArticleGroup articleGroup);
}
