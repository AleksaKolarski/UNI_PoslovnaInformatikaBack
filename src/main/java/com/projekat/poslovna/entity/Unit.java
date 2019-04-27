package com.projekat.poslovna.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 19:28.
 */
@Entity
@Data
public class Unit extends BaseEntity {

    @NotNull
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "unit")
    private List<Article> articles;

}
