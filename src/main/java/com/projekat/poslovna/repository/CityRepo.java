package com.projekat.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekat.poslovna.entity.City;

@Repository
public interface CityRepo extends JpaRepository<City, Integer> {

}
