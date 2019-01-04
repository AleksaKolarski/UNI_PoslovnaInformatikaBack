package com.projekat.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekat.poslovna.entity.ArticleGroup;

@Repository
public interface ArticleGroupRepo extends JpaRepository<ArticleGroup, Integer> {

}
