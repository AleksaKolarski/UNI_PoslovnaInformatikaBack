package com.projekat.poslovna.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

/**
 * Created by milan.miljus on 2019-04-27 19:21.
 */
@Entity
@Data
public class DocumentItem extends BaseEntity {

    @Size(min = 1)
    private int quantity;

    private int price;

    private int value;

    @ManyToOne
    private Article article;

//    nema vezu ka dokumentu, vec dobija po tabelu za svakog naslednika Document-a
//    create table document_in_house (id binary(255) not null, created_ti........
//    create table document_in_house_document_items (document_in_house_id......
//    create table document_outbound (id binary(255) not null, created_ti....
//    create table document_outbound_document_items (document_outbound_id..
}
