package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Warehouse;
import com.projekat.poslovna.repository.WarehouseRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-04 21:17.
 */
@Service
public class WarehouseServiceImpl extends CrudImpl<Warehouse> implements WarehouseService {

    public WarehouseServiceImpl(WarehouseRepo repo) {
        super(repo);
    }
}