package com.projekat.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekat.poslovna.entity.Unit;

@Repository
public interface UnitRepo extends JpaRepository<Unit, Integer> {

}
