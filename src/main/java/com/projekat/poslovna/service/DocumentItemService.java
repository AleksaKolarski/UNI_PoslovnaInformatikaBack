package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.DocumentItem;
import com.projekat.poslovna.repository.DocumentItemRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-04 21:07.
 */
@Service
public class DocumentItemService extends CrudImpl<DocumentItem> {

    public DocumentItemService(DocumentItemRepo repo) {
        super(repo);
    }
}
