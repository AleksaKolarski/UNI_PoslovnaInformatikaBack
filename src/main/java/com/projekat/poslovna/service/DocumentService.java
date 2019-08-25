package com.projekat.poslovna.service;

import com.projekat.poslovna.controller.exception.CustomException;
import com.projekat.poslovna.controller.value.DocumentCreateDTO;
import com.projekat.poslovna.controller.value.DocumentItemCreateDTO;
import com.projekat.poslovna.entity.*;
import com.projekat.poslovna.entity.enums.DocumentType;
import com.projekat.poslovna.repository.DocumentRepository;
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
public class DocumentService {

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

        switch (documentType) {
            case IMPORT:
                final int targetWarehouseId = document.getTargetWarehouse().getId();
                document.getDocumentItems().forEach(item -> {
                    articleCardService.updateArticleCard(targetWarehouseId, item.getArticleId(), item.getQuantity(), item.getPrice(), documentType);
                });
                break;
            case EXPORT:
                final int sourceWarehouseId = document.getSourceWarehouse().getId();
                document.getDocumentItems().forEach(item -> {
                    articleCardService.updateArticleCard(sourceWarehouseId, item.getArticleId(), item.getQuantity(), item.getPrice(), documentType);
                });
                break;
            case IN_HOUSE:
                // TODO: milan.miljus 8/25/19 2:16 PM
                throw new CustomException("");
        }
        return document.getId();
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
        document.setDocumentItems(getDocumentItems(documentDto.getDocumentItems()));
        documentRepository.save(document);
        return document;
    }

    private List<DocumentItem> getDocumentItems(List<DocumentItemCreateDTO> itemDTOs) {
        final List<DocumentItem> documentItems = itemDTOs.stream().map(itemDto -> {
            final DocumentItem documentItem = new DocumentItem();
            documentItem.setPrice(itemDto.getPrice());
            documentItem.setQuantity(itemDto.getQuantity());
            documentItem.setArticle(articleService.findById(itemDto.getArticleId()));
            return documentItem;
        }).collect(Collectors.toList());
        return documentItems;
    }

}
