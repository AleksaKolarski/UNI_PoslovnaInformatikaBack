package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.BusinessPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 8/24/19 6:18 PM.
 */
@Repository
public interface BusinessPartnerRepository extends JpaRepository<BusinessPartner, Integer> {
}
