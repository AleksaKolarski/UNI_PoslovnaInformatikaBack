package com.projekat.poslovna.service.exception;

import com.projekat.poslovna.controller.exception.CustomException;

/**
 * Created by milan.miljus on 8/24/19 2:24 PM.
 */
public class NotFoundException extends CustomException {

    public NotFoundException(String entityName) {
        super("Entity not found: " + entityName);
    }

}
