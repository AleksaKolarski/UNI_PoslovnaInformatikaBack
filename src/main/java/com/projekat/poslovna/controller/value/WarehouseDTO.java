package com.projekat.poslovna.controller.value;

import com.projekat.poslovna.entity.Warehouse;
import lombok.Getter;

/**
 * Created by milan.miljus on 8/24/19 2:18 PM.
 */
@Getter
public class WarehouseDTO {

    private int id;

    private String name;

    private String address;

    public WarehouseDTO(Warehouse warehouse) {
        this.id = warehouse.getId();
        this.name = warehouse.getName();
        this.address = warehouse.getAddress();
    }
}
