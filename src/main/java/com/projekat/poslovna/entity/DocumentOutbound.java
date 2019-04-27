package com.projekat.poslovna.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by milan.miljus on 2019-04-27 20:37.
 */
@Entity
@Data
public class DocumentOutbound extends Document {

    @ManyToOne
    @JoinColumn(nullable = false)
    private BusinessPartner businessPartner;

}
