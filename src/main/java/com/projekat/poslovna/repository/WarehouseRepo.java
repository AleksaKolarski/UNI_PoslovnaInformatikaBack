package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.Warehouse;
import com.projekat.poslovna.repository.base.CustomSoftDeleteRepo;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 2019-05-04 20:17.
 */
@Repository
public interface WarehouseRepo extends CustomSoftDeleteRepo<Warehouse> {
}
