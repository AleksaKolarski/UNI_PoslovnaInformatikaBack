package com.projekat.poslovna.controller;

import com.projekat.poslovna.controller.value.DocumentCreateDTO;
import com.projekat.poslovna.controller.value.DocumentItemResponseDTO;
import com.projekat.poslovna.controller.value.DocumentResponseDTO;
import com.projekat.poslovna.controller.value.IdWrapper;
import com.projekat.poslovna.entity.Document;
import com.projekat.poslovna.entity.DocumentItem;
import com.projekat.poslovna.service.DocumentCreateService;
import com.projekat.poslovna.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@AllArgsConstructor
public class DocumentController {

    private final DocumentService documentService;
    private final DocumentCreateService documentCreateService;

    @GetMapping("/fiscal-years/{fiscalYearId}/documents")
    public ResponseEntity<List<DocumentResponseDTO>> getDocumentsForFiscalYear(@PathVariable int fiscalYearId) {
        final List<Document> documents = documentService.getAllForFiscalYear(fiscalYearId);
        final List<DocumentResponseDTO> documentResponseDTOS =
                documents.stream().map(DocumentResponseDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(documentResponseDTOS, HttpStatus.OK);
    }

    @GetMapping("/documents/{documentId}/document-items")
    public ResponseEntity<List<DocumentItemResponseDTO>> getDocumentItems(@PathVariable int documentId) {
        final List<DocumentItem> documentItems = documentService.getDocumentItemsForDocumentId(documentId);
        final List<DocumentItemResponseDTO> documentItemResponseDTOS =
                documentItems.stream().map(DocumentItemResponseDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(documentItemResponseDTOS, HttpStatus.OK);
    }

    @PostMapping("/documents")
    public ResponseEntity<IdWrapper> createDocument(@RequestBody @Valid DocumentCreateDTO document) {
        final int documentId = documentCreateService.createDocument(document);
        return new ResponseEntity<>(IdWrapper.of(documentId), HttpStatus.CREATED);
    }

    @PostMapping("/documents/{documentId}/storno")
    public ResponseEntity<Void> stornDocument(@PathVariable int documentId) {
        documentService.storn(documentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
