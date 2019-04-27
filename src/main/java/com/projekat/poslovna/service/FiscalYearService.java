package com.projekat.poslovna.service;

import java.util.List;

import com.projekat.poslovna.entity.Company;
import com.projekat.poslovna.entity.FiscalYear;

public interface FiscalYearService extends ICrud<FiscalYear> {

	List<FiscalYearService> findByCompany(Company company);

}
