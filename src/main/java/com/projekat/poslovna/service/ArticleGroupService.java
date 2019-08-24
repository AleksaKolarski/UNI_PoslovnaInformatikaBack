package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.ArticleGroup;
import com.projekat.poslovna.repository.ArticleGroupRepository;
import com.projekat.poslovna.service.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by milan.miljus on 8/24/19 5:29 PM.
 */
@Service
@AllArgsConstructor
public class ArticleGroupService {

    private final ArticleGroupRepository repository;

    public List<ArticleGroup> getArticleGroups() {
        return repository.findAll();
    }

    public ArticleGroup getById(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("article group"));
    }
}
