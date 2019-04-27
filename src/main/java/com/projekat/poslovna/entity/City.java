package com.projekat.poslovna.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 17:29.
 */
@Entity
@Data
public class City extends BaseEntity {

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "city")
    private List<BusinessPartner> businessPartners;

    @OneToMany(mappedBy = "city")
    private List<Company> companies;
}
