package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.FiscalYear;
import com.projekat.poslovna.repository.FiscalYearRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-04 21:09.
 */
@Service
public class FiscalYearService extends CrudImpl<FiscalYear> {

    private final FiscalYearRepo repo;

    public FiscalYearService(FiscalYearRepo repo) {
        super(repo);
        this.repo = repo;
    }

    public FiscalYear getCurrentFiscalYear() {
        return this.repo.findByConcludedEqualsFalse(); // TODO: milan.miljus nemam pojma radi li ovo
    }

    public void conclude(FiscalYear fiscalYear) {
        fiscalYear.setConcluded(true);
        this.update(fiscalYear);
    }

}
