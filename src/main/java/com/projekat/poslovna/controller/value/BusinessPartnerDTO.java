package com.projekat.poslovna.controller.value;

import com.projekat.poslovna.entity.BusinessPartner;
import lombok.Getter;

/**
 * Created by milan.miljus on 8/24/19 6:20 PM.
 */
@Getter
public class BusinessPartnerDTO {

    private int id;
    private String name;
    private String PIB;
    private String address;
    private String city;

    public BusinessPartnerDTO(final BusinessPartner businessPartner) {
        this.id = businessPartner.getId();
        this.name = businessPartner.getName();
        this.PIB = businessPartner.getPIB();
        this.address = businessPartner.getAddress();
        this.city = businessPartner.getCity();
    }
}
