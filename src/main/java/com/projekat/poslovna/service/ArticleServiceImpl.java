package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Article;
import com.projekat.poslovna.repository.ArticleRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-04 20:28.
 */
@Service
public class ArticleServiceImpl extends CrudImpl<Article> implements ArticleService {

    public ArticleServiceImpl(ArticleRepo repo) {
        super(repo);
    }

}
