package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Company;
import com.projekat.poslovna.entity.FiscalYear;
import com.projekat.poslovna.repository.FiscalYearRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by milan.miljus on 2019-05-04 21:09.
 */
@Service
public class FiscalYearServiceImpl extends CrudImpl<FiscalYear> implements FiscalYearService {


    public FiscalYearServiceImpl(FiscalYearRepo repo) {
        super(repo);
    }

    @Override
    public List<FiscalYearService> findByCompany(Company company) {
        throw new RuntimeException("not implemented");
    }
}
