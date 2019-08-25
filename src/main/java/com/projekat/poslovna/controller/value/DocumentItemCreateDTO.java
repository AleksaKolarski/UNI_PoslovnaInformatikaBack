package com.projekat.poslovna.controller.value;

import lombok.Getter;

import javax.validation.constraints.Positive;

/**
 * Created by milan.miljus on 8/25/19 12:38 PM.
 */
@Getter
public class DocumentItemCreateDTO {

    @Positive
    private int quantity;

    @Positive
    private long price;

    @Positive
    private int articleId;

}
