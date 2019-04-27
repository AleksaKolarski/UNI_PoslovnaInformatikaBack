package com.projekat.poslovna.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 17:28.
 */
@Entity
@Data
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

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "businessPartner")
    private List<DocumentOutbound> documents;
}
