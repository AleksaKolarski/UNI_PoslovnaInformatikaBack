package com.projekat.poslovna.service;

import java.util.List;

import com.projekat.poslovna.entity.DocumentItem;

public interface DocumentItemService {

	DocumentItem findById(int id);
	
	List<DocumentItem> findByDocument();
	
	List<DocumentItem> findAll();
	
	DocumentItem save(DocumentItem documentItem);
	
	DocumentItem update(DocumentItem documentItem);
	
	void delete(DocumentItem documentItem);
}
