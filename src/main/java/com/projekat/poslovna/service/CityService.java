package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.City;
import com.projekat.poslovna.repository.CityRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

/**
 * Created by milan.miljus on 2019-05-04 21:02.
 */
@Service
public class CityService extends CrudImpl<City> {

    public CityService(CityRepo repo) {
        super(repo);
    }
}
