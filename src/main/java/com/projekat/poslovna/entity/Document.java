package com.projekat.poslovna.entity;

import com.projekat.poslovna.entity.enums.DocumentStatus;
import com.projekat.poslovna.entity.enums.DocumentType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 19:34.
 */
@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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

    @NotEmpty
    @OneToMany(mappedBy = "document", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<DocumentItem> documentItems;

}
