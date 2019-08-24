package com.projekat.poslovna.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 19:31.
 */
@Entity
@Data
public class Warehouse extends BaseEntity {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String address;

    @OneToMany(mappedBy = "sourceWarehouse")
    private List<Document> documents;

    @OneToMany(mappedBy = "targetWarehouse")
    private List<DocumentInHouse> documentsInHouse;

}
