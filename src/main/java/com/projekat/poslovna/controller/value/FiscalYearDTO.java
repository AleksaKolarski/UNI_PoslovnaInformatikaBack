package com.projekat.poslovna.controller.value;

import com.projekat.poslovna.entity.FiscalYear;
import lombok.Getter;

import java.sql.Timestamp;

/**
 * Created by milan.miljus on 8/25/19 12:33 PM.
 */
@Getter
public class FiscalYearDTO {

    private int id;
    private int year;
    private boolean concluded;
    private Timestamp startedOn;
    private Timestamp endedOn;

    public FiscalYearDTO(FiscalYear fiscalYear) {
        this.id = fiscalYear.getId();
        this.year = fiscalYear.getYear();
        this.concluded = fiscalYear.isConcluded();
        this.startedOn = fiscalYear.getStartedOn();
        this.endedOn = fiscalYear.getEndedOn();
    }
    
}
