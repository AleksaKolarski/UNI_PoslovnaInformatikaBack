package com.projekat.poslovna.service;

import java.util.List;

import com.projekat.poslovna.entity.Document;

public interface DocumentService {

	Document findById(int id);
	
	List<Document> findAll();
	
	Document save(Document document);
	
	Document update(Document document);
	
	void delete(Document document);
}
