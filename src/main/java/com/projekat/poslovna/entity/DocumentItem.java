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

    private long price;

    @ManyToOne
    private Article article;

    @ManyToOne
    private Document document;

    public long getValue() {
        return quantity * price;
    }
}
