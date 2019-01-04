package com.projekat.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekat.poslovna.entity.BusinessPartner;

@Repository
public interface BusinessPartnerRepo extends JpaRepository<BusinessPartner, Integer> {

}
