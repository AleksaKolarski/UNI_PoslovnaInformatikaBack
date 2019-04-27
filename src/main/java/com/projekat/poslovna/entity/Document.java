package com.projekat.poslovna.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by milan.miljus on 2019-04-27 19:34.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class Document extends BaseEntity {

    private DocumentType type;
    @CreationTimestamp
    private Timestamp formedOn;
    private Timestamp bookedOn;
    private DocumentStatus status = DocumentStatus.FORMED;

    @ManyToOne(optional=false)
    private Warehouse sourceWarehouse;

    @ManyToOne(optional=false)
    private FiscalYear fiscalYear;

    // TODO ova vezå je nejasna
    @OneToMany
    private List<DocumentItem> documentItems;

}
