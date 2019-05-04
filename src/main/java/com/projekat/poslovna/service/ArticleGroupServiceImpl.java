package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.ArticleGroup;
import com.projekat.poslovna.repository.ArticleGroupRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-04 20:59.
 */
@Service
public class ArticleGroupServiceImpl extends CrudImpl<ArticleGroup> implements ArticleGroupService {

    public ArticleGroupServiceImpl(ArticleGroupRepo repo) {
        super(repo);
    }
}
