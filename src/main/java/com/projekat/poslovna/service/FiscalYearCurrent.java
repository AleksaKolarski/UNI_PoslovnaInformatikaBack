package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.FiscalYear;
import com.projekat.poslovna.repository.FiscalYearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by milan.miljus on 9/1/19 1:53 PM.
 */
@Service
@RequiredArgsConstructor
public class FiscalYearCurrent {

    private FiscalYear currentFiscalYear;

    private final FiscalYearRepository fiscalYearRepository;

    @PostConstruct
    public void setCurrentFiscalYear() {
        this.currentFiscalYear = fiscalYearRepository.getByConcludedFalse();
    }

    public void setCurrentFiscalYear(FiscalYear fiscalYear) {
        this.currentFiscalYear = fiscalYear;
    }

    public FiscalYear get() {
        return this.currentFiscalYear;
    }


}
