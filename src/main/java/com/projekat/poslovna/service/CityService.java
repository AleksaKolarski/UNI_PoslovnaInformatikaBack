package com.projekat.poslovna.service;

import java.util.List;

import com.projekat.poslovna.entity.City;

public interface CityService {

	City findById(int id);
	
	List<City> findAll();
	
	City save(City city);
	
	City update(City city);
	
	void delete(City city);
}
