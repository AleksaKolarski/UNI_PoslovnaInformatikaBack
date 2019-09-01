package com.projekat.poslovna.controller.value;

import com.projekat.poslovna.entity.Document;
import com.projekat.poslovna.entity.enums.DocumentStatus;
import com.projekat.poslovna.entity.enums.DocumentType;
import lombok.Getter;

import java.sql.Timestamp;

/**
 * Created by milan.miljus on 8/25/19 12:38 PM.
 */
@Getter
public class DocumentResponseDTO {

    private int id;
    private Timestamp formedOn;
    private Timestamp bookedOn;
    private DocumentStatus status;
    private DocumentType documentType;

    private String sourceWarehouseName;
    private String targetWarehouseName;
    private String businessPartnerName;

    public DocumentResponseDTO(Document document) {
        this.id = document.getId();
        this.formedOn = document.getFormedOn();
        this.bookedOn = document.getBookedOn();
        this.status = document.getStatus();
        this.documentType = document.getDocumentType();
        this.sourceWarehouseName = document.getSourceWarehouse() != null ? document.getSourceWarehouse().getName() : null;
        this.targetWarehouseName = document.getTargetWarehouse() != null ? document.getTargetWarehouse().getName() : null;
        this.businessPartnerName = document.getBusinessPartner() != null ? document.getBusinessPartner().getName() : null;
    }

}
