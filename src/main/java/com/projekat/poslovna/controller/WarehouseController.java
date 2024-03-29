package com.projekat.poslovna.controller;

import com.projekat.poslovna.controller.value.WarehouseDTO;
import com.projekat.poslovna.entity.Warehouse;
import com.projekat.poslovna.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/warehouses")
@AllArgsConstructor
public class WarehouseController {

    private WarehouseService warehouseService;

    @GetMapping
    public ResponseEntity<List<WarehouseDTO>> getWarehouses() {
        final List<Warehouse> warehouses = warehouseService.getAll();
        final List<WarehouseDTO> warehouseDTOs = warehouses.stream().map(WarehouseDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(warehouseDTOs, HttpStatus.OK);
    }

    @GetMapping("/{warehouseId}")
    public ResponseEntity<WarehouseDTO> getWarehouseById(@PathVariable int warehouseId) {
        final Warehouse warehouse = warehouseService.getById(warehouseId);
        return new ResponseEntity<>(new WarehouseDTO(warehouse), HttpStatus.OK);
    }

}
