package com.projekat.poslovna.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 19:31.
 */
@Entity
@Data
public class Warehouse extends BaseEntity {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @OneToMany(mappedBy = "sourceWarehouse")
    private List<DocumentInHouse> documentsExport;

    @OneToMany(mappedBy = "targetWarehouse")
    private List<DocumentInHouse> documentImport;

    @OneToMany(mappedBy = "sourceWarehouse")
    private List<DocumentOutbound> outboundDocuments;

    @ManyToMany
    private List<Employee> employees;

}
