package com.projekat.poslovna.service;

import java.util.List;

import com.projekat.poslovna.entity.Warehouse;

public interface WarehouseService {

	Warehouse findById(int id);
	
	List<Warehouse> findAll();
	
	Warehouse save(Warehouse warehouse);
	
	Warehouse update(Warehouse warehouse);
	
	void delete(Warehouse warehouse);
}
