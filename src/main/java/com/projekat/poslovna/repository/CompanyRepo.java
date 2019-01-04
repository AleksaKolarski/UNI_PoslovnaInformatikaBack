package com.projekat.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekat.poslovna.entity.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {

}
