package com.projekat.poslovna.controller.value;

import com.projekat.poslovna.entity.enums.UnitEnum;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Created by milan.miljus on 9/1/19 4:21 PM.
 */
@Getter
public class ArticleCreateDTO {

    @NotBlank
    private String name;

    @NotNull
    private UnitEnum unit;

    @Positive
    private int articleGroupId;

}
