package com.projekat.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekat.poslovna.entity.Article;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Integer> {

}
