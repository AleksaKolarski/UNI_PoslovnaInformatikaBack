package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.BusinessPartner;
import com.projekat.poslovna.repository.BusinessPartnerRepository;
import com.projekat.poslovna.service.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by milan.miljus on 8/24/19 6:19 PM.
 */
@Service
@AllArgsConstructor
public class BusinessPartnerService {

    private final BusinessPartnerRepository businessPartnerRepository;

    public List<BusinessPartner> getAll() {
        return businessPartnerRepository.findAll();
    }

    public BusinessPartner getById(int id) {
        return businessPartnerRepository.findById(id).orElseThrow(() -> new NotFoundException("business partner"));
    }

}
