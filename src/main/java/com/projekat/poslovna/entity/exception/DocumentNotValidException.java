package com.projekat.poslovna.entity.exception;

import com.projekat.poslovna.controller.exception.CustomException;

/**
 * Created by milan.miljus on 8/24/19 1:38 PM.
 */
public class DocumentNotValidException extends CustomException {

    public DocumentNotValidException() {
        super("Document is not valid!");
    }

}
