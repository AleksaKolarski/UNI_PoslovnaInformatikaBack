package com.projekat.poslovna.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 19:25.
 */
@Entity
@Data
public class FiscalYear extends BaseEntity {

    @Column
    private int year;

    private boolean concluded;

    private Timestamp startedOn;

    private Timestamp endedOn;

    @OneToMany(mappedBy = "fiscalYear")
    private List<DocumentInHouse> inHouseDocuments;

    @OneToMany(mappedBy = "fiscalYear")
    private List<DocumentOutbound> outBoundDocuments;

    @OneToMany(mappedBy = "fiscalYear")
    private List<ArticleCard> articleCards;
}
