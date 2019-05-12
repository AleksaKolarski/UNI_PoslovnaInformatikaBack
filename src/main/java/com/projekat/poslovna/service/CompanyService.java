package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Company;
import com.projekat.poslovna.repository.CompanyRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-04 21:03.
 */
@Service
public class CompanyService extends CrudImpl<Company> {

    public CompanyService(CompanyRepo repo) {
        super(repo);
    }
}
