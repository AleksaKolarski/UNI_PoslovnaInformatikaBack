package com.projekat.poslovna.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by milan.miljus on 2019-04-27 17:28.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessPartner extends BaseEntity {

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String name;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String PIB;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

}
