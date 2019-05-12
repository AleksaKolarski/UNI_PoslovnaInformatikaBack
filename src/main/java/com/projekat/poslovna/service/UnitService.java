package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Unit;
import com.projekat.poslovna.repository.UnitRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-09 15:40.
 */
@Service
public class UnitService extends CrudImpl<Unit> {

    private final UnitRepo unitRepo;

    public UnitService(UnitRepo unitRepo) {
        super(unitRepo);
        this.unitRepo = unitRepo;
    }
}
