package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Article;
import com.projekat.poslovna.repository.ArticleRepository;
import com.projekat.poslovna.service.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by milan.miljus on 8/24/19 2:12 PM.
 */
@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article findById(int id) {
        return articleRepository.findById(id).orElseThrow(() -> new NotFoundException("article"));
    }

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

}
