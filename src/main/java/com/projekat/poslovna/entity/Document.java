package com.projekat.poslovna.entity;

import com.projekat.poslovna.entity.enums.DocumentStatus;
import com.projekat.poslovna.entity.enums.DocumentType;
import com.projekat.poslovna.entity.exception.DocumentNotValidException;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @Enumerated(EnumType.STRING)
    private DocumentStatus status = DocumentStatus.FORMED;

    @ManyToOne
    private Warehouse sourceWarehouse;

    @NotNull
    @ManyToOne
    private FiscalYear fiscalYear;

    @NotEmpty
    @OneToMany(mappedBy = "document", cascade = CascadeType.PERSIST)
    private List<DocumentItem> documentItems;

    @ManyToOne
    private Warehouse targetWarehouse;

    @ManyToOne
    private BusinessPartner businessPartner;

    @PrePersist
    private void check() {
        getDocumentType(
                this.sourceWarehouse != null ? this.sourceWarehouse.getId() : null,
                this.targetWarehouse != null ? this.targetWarehouse.getId() : null,
                this.businessPartner != null ? this.businessPartner.getId() : null
        );
    }

    public static DocumentType getDocumentType(Integer sourceWarehouse, Integer targetWarehouse, Integer businessPartner) {
        if (!isNullOrZero(sourceWarehouse) && !isNullOrZero(targetWarehouse) && isNullOrZero(businessPartner)) {
            return DocumentType.IN_HOUSE;
        } else if (isNullOrZero(sourceWarehouse) && !isNullOrZero(targetWarehouse) && !isNullOrZero(businessPartner)) {
            return DocumentType.IMPORT;
        } else if (!isNullOrZero(sourceWarehouse) && isNullOrZero(targetWarehouse) && !isNullOrZero(businessPartner)) {
            return DocumentType.EXPORT;
        } else {
            throw new DocumentNotValidException();
        }
    }

    private static boolean isNullOrZero(Integer integer) {
        return integer == null || integer == 0;
    }

}
