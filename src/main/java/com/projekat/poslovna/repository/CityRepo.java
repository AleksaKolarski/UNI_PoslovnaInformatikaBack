package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.City;
import com.projekat.poslovna.repository.base.CustomSoftDeleteRepo;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 2019-05-04 20:12.
 */
@Repository
public interface CityRepo extends CustomSoftDeleteRepo<City> {
}
