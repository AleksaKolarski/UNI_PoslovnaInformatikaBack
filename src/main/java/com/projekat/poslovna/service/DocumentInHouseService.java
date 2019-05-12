package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.DocumentInHouse;
import com.projekat.poslovna.repository.DocumentInHouseRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-04 21:05.
 */
@Service
public class DocumentInHouseService extends CrudImpl<DocumentInHouse> {

    public DocumentInHouseService(DocumentInHouseRepo repo) {
        super(repo);
    }
}
