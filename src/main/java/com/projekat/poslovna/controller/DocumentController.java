package com.projekat.poslovna.controller;

import com.projekat.poslovna.controller.value.DocumentCreateDTO;
import com.projekat.poslovna.controller.value.IdWrapper;
import com.projekat.poslovna.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by milan.miljus on 8/25/19 12:44 PM.
 */
@RestController
@RequestMapping("/documents")
@AllArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    public ResponseEntity<IdWrapper> createDocument(@RequestBody @Valid DocumentCreateDTO document) {
        final int documentId = documentService.createDocument(document);
        return new ResponseEntity<>(IdWrapper.of(documentId), HttpStatus.CREATED);
    }
}
