package com.projekat.poslovna.service;

import java.util.List;

import com.projekat.poslovna.entity.Company;

public interface FiscalYear {
	
	FiscalYear findById(int id);
	
	List<FiscalYear> findByCompany(Company company);
	
	List<FiscalYear> findAll();
	
	FiscalYear save(FiscalYear fiscalYear);
	
	FiscalYear update(FiscalYear fiscalYear);
	
	void delete(FiscalYear fiscalYear);
}
