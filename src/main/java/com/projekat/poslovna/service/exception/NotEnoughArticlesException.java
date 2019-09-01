package com.projekat.poslovna.service.exception;

import com.projekat.poslovna.controller.exception.CustomException;
import com.projekat.poslovna.entity.ArticleCard;

/**
 * Created by milan.miljus on 8/25/19 2:32 PM.
 */
public class NotEnoughArticlesException extends CustomException {

//    public NotEnoughArticlesException(String articleName, int availableQuantity) {
//        super("Not enough article: " + articleName + ", available: " + availableQuantity);
//    }

    public NotEnoughArticlesException(ArticleCard articleCard) {
        super("Not enough article: " + articleCard.getArticle().getName() + ", available: " + articleCard.getQuantity());
    }
}
