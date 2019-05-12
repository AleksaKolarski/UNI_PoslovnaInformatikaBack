package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Document;
import com.projekat.poslovna.entity.enums.DocumentStatus;
import com.projekat.poslovna.repository.DocumentRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by milan.miljus on 2019-05-09 15:47.
 */
@Service
public class DocumentService extends CrudImpl<Document> {

    private final DocumentRepo documentRepo;

    public DocumentService(DocumentRepo documentRepo) {
        super(documentRepo);
        this.documentRepo = documentRepo;
    }

    public Document form(Document document) {
        document.setStatus(DocumentStatus.FORMED);
        return this.update(document);
    }

    public Document book(Document document) {
        // TODO: 09 May 2019 15:53 milan.miljus impl
        throw new NotImplementedException();
    }
}
