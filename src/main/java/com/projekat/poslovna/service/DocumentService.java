package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Document;
import com.projekat.poslovna.entity.DocumentItem;
import com.projekat.poslovna.entity.enums.DocumentType;
import com.projekat.poslovna.repository.DocumentRepository;
import com.projekat.poslovna.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentCreateService documentCreateService;
    private final DocumentRepository documentRepository;

    @Transactional(rollbackFor = Throwable.class, readOnly = true)
    public List<Document> getAllForFiscalYear(int fiscalYearId) {
        final List<Document> documents = documentRepository.getByFiscalYearId(fiscalYearId);
        return documents;
    }

    @Transactional(readOnly = true)
    public List<DocumentItem> getDocumentItemsForDocumentId(int documentId) {
        final Document document = this.getById(documentId);
        return document.getDocumentItems();
    }

    @Transactional(rollbackFor = Throwable.class, readOnly = true)
    public Document getById(int documentId) {
        return documentRepository.findById(documentId).orElseThrow(() -> new NotFoundException("document"));
    }

    @Transactional(rollbackFor = Throwable.class, readOnly = false)
    public int storn(int documentId) {
        final Document sourceDocument = this.getById(documentId);
        final DocumentType sourceDocumentType = sourceDocument.getDocumentType();

        final Document document = new Document();
        document.setDocumentType(DocumentType.STORNO);
        document.setFiscalYear(sourceDocument.getFiscalYear());
        document.setTargetWarehouse(sourceDocument.getTargetWarehouse());
        document.setSourceWarehouse(sourceDocument.getSourceWarehouse());
        document.setBusinessPartner(sourceDocument.getBusinessPartner());
        document.setDocumentItems(flipDocumentItems(document, sourceDocument.getDocumentItems()));
        documentRepository.save(document);

        final int stornDocumentId = documentCreateService.processDocument(document, sourceDocumentType);
        return stornDocumentId;
    }

    public List<DocumentItem> flipDocumentItems(Document document, List<DocumentItem> documentItems) {
        return documentItems.stream().map(documentItem -> {
            final DocumentItem newDocumentItem = new DocumentItem();
            newDocumentItem.setArticle(documentItem.getArticle());
            newDocumentItem.setQuantity(-documentItem.getQuantity());
            newDocumentItem.setPrice(documentItem.getPrice());
            newDocumentItem.setDocument(document);
            return newDocumentItem;
        }).collect(Collectors.toList());
    }
}
