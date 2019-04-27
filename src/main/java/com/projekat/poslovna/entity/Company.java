package com.projekat.poslovna.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by milan.miljus on 2019-04-27 17:30.
 */
@Entity
@Data
public class Company extends BaseEntity {

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String name;

    @NotNull
    @Size(min = 9, max = 9)
    @Column(unique = true, length = 9, columnDefinition = "CHAR(9)")
    private String PIB;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @ManyToOne
    private City city;
}
