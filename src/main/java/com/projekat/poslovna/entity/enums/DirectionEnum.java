package com.projekat.poslovna.entity.enums;

import com.projekat.poslovna.controller.exception.CustomException;

/**
 * Created by milan.miljus on 8/24/19 2:08 PM.
 */
public enum DirectionEnum {
    IN, OUT;

    public static DirectionEnum from(DocumentType documentType) {
        switch (documentType) {
            case IMPORT:
                return IN;
            case EXPORT:
                return OUT;
            default:
                throw new CustomException("direction enum cast failed");
        }
    }
}
