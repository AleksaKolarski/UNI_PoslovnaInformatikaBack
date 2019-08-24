package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 8/24/19 2:17 PM.
 */
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

}
