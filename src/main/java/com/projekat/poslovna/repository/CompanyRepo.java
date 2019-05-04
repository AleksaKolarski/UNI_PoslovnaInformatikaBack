package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.Company;
import com.projekat.poslovna.repository.base.CustomSoftDeleteRepo;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 2019-05-04 20:13.
 */
@Repository
public interface CompanyRepo extends CustomSoftDeleteRepo<Company> {
}
