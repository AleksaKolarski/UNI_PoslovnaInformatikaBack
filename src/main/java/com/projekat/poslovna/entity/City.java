package com.projekat.poslovna.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 17:29.
 */
@Entity
@Data
@NoArgsConstructor
public class City extends BaseEntity {

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String name;

    @Size(min=3, max=3)
    @NotNull
    private String code;

    @OneToMany(mappedBy = "city")
    private List<BusinessPartner> businessPartners;

    @OneToMany(mappedBy = "city")
    private List<Company> companies;

    public City(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
