package com.projekat.poslovna.service.exception;

import com.projekat.poslovna.controller.exception.CustomException;

/**
 * Created by milan.miljus on 8/25/19 2:32 PM.
 */
public class NotEnoughArticlesException extends CustomException {

    public NotEnoughArticlesException(String articleName, int availableQuantity) {
        super("Not enough article: " + articleName + ", available: " + availableQuantity);
    }

}
