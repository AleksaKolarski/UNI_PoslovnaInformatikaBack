package com.projekat.poslovna.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by milan.miljus on 2019-04-27 20:37.
 */
@Entity
@Data
public class DocumentOutbound extends Document {

    @ManyToOne
    @NotNull
    private BusinessPartner businessPartner;

}
