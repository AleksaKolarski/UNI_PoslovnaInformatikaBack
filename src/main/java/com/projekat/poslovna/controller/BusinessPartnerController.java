package com.projekat.poslovna.controller;

import com.projekat.poslovna.controller.value.BusinessPartnerDTO;
import com.projekat.poslovna.entity.BusinessPartner;
import com.projekat.poslovna.service.BusinessPartnerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by milan.miljus on 8/24/19 6:22 PM.
 */
@RestController
@RequestMapping("/business-partners")
@AllArgsConstructor
public class BusinessPartnerController {

    private final BusinessPartnerService businessPartnerService;

    @GetMapping
    public ResponseEntity<List<BusinessPartnerDTO>> getAll() {
        final List<BusinessPartner> businessPartners = businessPartnerService.getAll();
        final List<BusinessPartnerDTO> businessPartnerDTOS = businessPartners.stream().map(BusinessPartnerDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(businessPartnerDTOS, HttpStatus.OK);
    }

}
