package com.projekat.poslovna.service;

import com.projekat.poslovna.controller.exception.CustomException;
import com.projekat.poslovna.controller.value.DocumentCreateDTO;
import com.projekat.poslovna.controller.value.DocumentItemCreateDTO;
import com.projekat.poslovna.entity.BusinessPartner;
import com.projekat.poslovna.entity.Document;
import com.projekat.poslovna.entity.DocumentItem;
import com.projekat.poslovna.entity.Warehouse;
import com.projekat.poslovna.entity.enums.DocumentType;
import com.projekat.poslovna.repository.DocumentRepository;
import com.projekat.poslovna.service.exception.CantTransferWithinSameWarehouseException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by milan.miljus on 8/25/19 12:28 PM.
 */
@Service
@AllArgsConstructor
public class DocumentCreateService {

    private final WarehouseService warehouseService;
    private final BusinessPartnerService businessPartnerService;
    private final FiscalYearService fiscalYearService;
    private final ArticleService articleService;
    private final DocumentRepository documentRepository;
    private final ArticleCardService articleCardService;

    @Transactional(rollbackFor = Throwable.class)
    public int createDocument(DocumentCreateDTO documentDto) {
        final DocumentType documentType = Document.getDocumentType(
                documentDto.getSourceWarehouseId(),
                documentDto.getTargetWarehouseId(),
                documentDto.getBusinessPartnerId()
        );

        final Document document = createDocumentEntity(documentDto);


        return processDocument(document, documentType);
    }

    public int processDocument(Document document, DocumentType documentType) {
        switch (documentType) {
            case IMPORT:
                final int targetWarehouseId = document.getTargetWarehouse().getId();
                document.getDocumentItems().forEach(item ->
                        articleCardService.updateArticleCard(
                                targetWarehouseId, item.getArticleId(), item.getQuantity(),
                                item.getPrice(), documentType)
                );
                break;
            case EXPORT:
                final int sourceWarehouseId = document.getSourceWarehouse().getId();
                document.getDocumentItems().forEach(item ->
                        articleCardService.updateArticleCard(
                                sourceWarehouseId, item.getArticleId(), item.getQuantity(),
                                item.getPrice(), documentType)
                );
                break;
            case IN_HOUSE:
                handleInHouse(document);
                break;
            default:
                throw new CustomException("");
        }
        document.book();
        return document.getId();
    }

    private void handleInHouse(final Document document) {
        final int sourceWarehouseId = document.getSourceWarehouse().getId();
        final int targetWarehouseId = document.getTargetWarehouse().getId();

        if (sourceWarehouseId == targetWarehouseId) {
            throw new CantTransferWithinSameWarehouseException();
        }

        document.getDocumentItems().forEach(item -> {
            articleCardService.updateArticleCardInHouse(sourceWarehouseId, targetWarehouseId, item.getArticleId(), item.getQuantity());
        });
    }


    private Document createDocumentEntity(DocumentCreateDTO documentDto) {
        final Warehouse sourceWarehouse = documentDto.getSourceWarehouseId() != null ? warehouseService.getById(documentDto.getSourceWarehouseId()) : null;
        final Warehouse targetWarehouse = documentDto.getTargetWarehouseId() != null ? warehouseService.getById(documentDto.getTargetWarehouseId()) : null;
        final BusinessPartner businessPartner = documentDto.getBusinessPartnerId() != null ? businessPartnerService.getById(documentDto.getBusinessPartnerId()) : null;

        final Document document = new Document();
        document.setSourceWarehouse(sourceWarehouse);
        document.setTargetWarehouse(targetWarehouse);
        document.setBusinessPartner(businessPartner);
        document.setFiscalYear(fiscalYearService.getCurrent());
        document.setDocumentItems(getDocumentItems(document, documentDto.getDocumentItems()));
        documentRepository.save(document);
        return document;
    }

    private List<DocumentItem> getDocumentItems(Document document, List<DocumentItemCreateDTO> itemDTOs) {
        final List<DocumentItem> documentItems = itemDTOs.stream().map(itemDto -> {
            final DocumentItem documentItem = new DocumentItem();
            documentItem.setPrice(itemDto.getPrice());
            documentItem.setQuantity(itemDto.getQuantity());
            documentItem.setArticle(articleService.findById(itemDto.getArticleId()));
            documentItem.setDocument(document);
            return documentItem;
        }).collect(Collectors.toList());
        return documentItems;
    }

}
