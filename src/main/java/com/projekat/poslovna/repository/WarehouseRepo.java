package com.projekat.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekat.poslovna.entity.Warehouse;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse, Integer> {

}
