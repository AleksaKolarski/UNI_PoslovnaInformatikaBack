package com.projekat.poslovna.entity;

import com.projekat.poslovna.entity.enums.DocumentStatus;
import com.projekat.poslovna.entity.exception.DocumentNotValidException;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 19:34.
 */
@Entity
@Getter
@Setter
public class Document extends BaseEntity {

    @CreationTimestamp
    private Timestamp formedOn;
    private Timestamp bookedOn;
    private DocumentStatus status = DocumentStatus.FORMED;

    @ManyToOne
    private Warehouse sourceWarehouse;

    @ManyToOne(optional=false)
    private FiscalYear fiscalYear;

    @NotEmpty
    @OneToMany(mappedBy = "document")
    private List<DocumentItem> documentItems;

    @ManyToOne
    private Warehouse targetWarehouse;

    @ManyToOne
    private BusinessPartner businessPartner;

    @PrePersist
    private void checkValidity() {
        int nullsNumber = 0;
        if (sourceWarehouse == null) {
            nullsNumber += 1;
        }
        if (targetWarehouse == null) {
            nullsNumber += 1;
        }
        if (businessPartner == null) {
            nullsNumber += 1;
        }
        if (nullsNumber != 1) {
            throw new DocumentNotValidException();
        }
    }


}
