package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.BusinessPartner;
import com.projekat.poslovna.repository.BusinessPartnerRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-04 21:01.
 */
@Service
public class BusinessPartnerService extends CrudImpl<BusinessPartner> {

    public BusinessPartnerService(BusinessPartnerRepo repo) {
        super(repo);
    }
}
