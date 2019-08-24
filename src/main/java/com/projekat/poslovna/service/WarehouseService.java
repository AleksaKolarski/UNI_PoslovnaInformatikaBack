package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Warehouse;
import com.projekat.poslovna.repository.WarehouseRepository;
import com.projekat.poslovna.service.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by milan.miljus on 8/24/19 2:17 PM.
 */
@Service
@AllArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public Warehouse getById(int id) {
        return warehouseRepository.findById(id).orElseThrow(() -> new NotFoundException("warehouse"));
    }

    public List<Warehouse> getAll() {
        return warehouseRepository.findAll();
    }

}
