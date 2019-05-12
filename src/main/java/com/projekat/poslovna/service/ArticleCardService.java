package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Article;
import com.projekat.poslovna.repository.ArticleCardRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-04 20:56.
 */
@Service
public class ArticleCardService extends CrudImpl<Article> {

    public ArticleCardService(ArticleCardRepo repo) {
        super(repo);
    }
}
