package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.DocumentOutbound;
import com.projekat.poslovna.repository.DocumentOutboundRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-04 21:08.
 */
@Service
public class DocumentOutboundServiceImpl extends CrudImpl<DocumentOutbound> implements DocumentOutboundService {

    public DocumentOutboundServiceImpl(DocumentOutboundRepo repo) {
        super(repo);
    }
}
