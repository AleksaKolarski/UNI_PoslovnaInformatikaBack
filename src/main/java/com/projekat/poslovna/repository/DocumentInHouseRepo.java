package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.DocumentInHouse;
import com.projekat.poslovna.repository.base.CustomSoftDeleteRepo;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 2019-05-04 20:15.
 */
@Repository
public interface DocumentInHouseRepo extends CustomSoftDeleteRepo<DocumentInHouse> {
}
