package com.projekat.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekat.poslovna.entity.FiscalYear;

@Repository
public interface FiscalYearRepo extends JpaRepository<FiscalYear, Integer> {

}