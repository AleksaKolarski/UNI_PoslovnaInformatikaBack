package com.projekat.poslovna.service;

import java.util.List;

import com.projekat.poslovna.entity.Unit;

public interface UnitService {

	Unit findById(int id);
	
	List<Unit> findAll();
	
	Unit save(Unit unit);
	
	Unit update(Unit unit);
	
	void delete(Unit unit);
}
