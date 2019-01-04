package com.projekat.poslovna.service;

import java.util.List;

import com.projekat.poslovna.entity.Company;

public interface CompanyService {

	Company findById(int id);
	
	List<Company> findAll();
	
	Company save(Company company);
	
	Company update(Company company);
	
	void delete(Company company);
}
