package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.FiscalYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 8/25/19 1:06 PM.
 */
@Repository
public interface FiscalYearRepository extends JpaRepository<FiscalYear, Integer> {

    FiscalYear getByConcludedFalse();

}
