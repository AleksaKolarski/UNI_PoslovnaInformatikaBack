package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.DocumentInHouse;
import com.projekat.poslovna.repository.DocumentInHouseRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-04 21:05.
 */
@Service
public class DocumentInHouseServiceImpl extends CrudImpl<DocumentInHouse> implements DocumentInHouseService {

    public DocumentInHouseServiceImpl(DocumentInHouseRepo repo) {
        super(repo);
    }
}
