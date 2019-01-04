package com.projekat.poslovna.service;

import java.util.List;

import com.projekat.poslovna.entity.BusinessPartner;
import com.projekat.poslovna.entity.Company;

public interface BusinessPartnerService {

	BusinessPartner findById(int id);
	
	List<BusinessPartner> findByCompany(Company company);
	
	List<BusinessPartner> findAll();
	
	BusinessPartner save(BusinessPartner businessPartner);
	
	BusinessPartner update(BusinessPartner businessPartner);
	
	void delete(BusinessPartner businessPartner);
}
