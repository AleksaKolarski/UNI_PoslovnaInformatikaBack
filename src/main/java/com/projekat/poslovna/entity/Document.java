package com.projekat.poslovna.entity;

import com.projekat.poslovna.entity.enums.DocumentStatus;
import com.projekat.poslovna.entity.enums.DocumentType;
import com.projekat.poslovna.entity.exception.DocumentNotValidException;
import com.projekat.poslovna.utils.Utils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Getter
@Setter
public class Document extends BaseEntity {

    @NotNull
    private Timestamp formedOn;

    private Timestamp bookedOn;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DocumentStatus status = DocumentStatus.FORMED;

    @ManyToOne
    private Warehouse sourceWarehouse;

    @NotNull
    @ManyToOne
    private FiscalYear fiscalYear;

    @NotEmpty
    @OneToMany(mappedBy = "document", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<DocumentItem> documentItems;

    @ManyToOne
    private Warehouse targetWarehouse;

    @ManyToOne
    private BusinessPartner businessPartner;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    public void form() {
        this.status = DocumentStatus.FORMED;
        this.formedOn = Utils.getCurrentTimestamp();
    }

    public void book() {
        this.status = DocumentStatus.BOOKED;
        this.bookedOn = Utils.getCurrentTimestamp();
    }

    public Document() {
        this.form();
    }

    @PrePersist
    private void setDocumentType() {
        this.documentType = getDocumentType();
    }

    public DocumentType getDocumentType() {
        return this.documentType != null
                ? this.documentType
                : getDocumentType(
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
