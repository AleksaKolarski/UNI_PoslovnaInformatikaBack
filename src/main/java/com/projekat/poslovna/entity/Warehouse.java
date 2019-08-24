package com.projekat.poslovna.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by milan.miljus on 2019-04-27 19:31.
 */
@Entity
@Getter
@Setter
public class Warehouse extends BaseEntity {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String address;

}
