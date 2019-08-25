package com.projekat.poslovna.controller;

import com.projekat.poslovna.controller.value.FiscalYearDTO;
import com.projekat.poslovna.entity.FiscalYear;
import com.projekat.poslovna.service.FiscalYearService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by milan.miljus on 8/25/19 4:12 PM.
 */
@RestController
@RequestMapping("/fiscal-years")
@AllArgsConstructor
public class FiscalYearController {

    private final FiscalYearService fiscalYearService;

    @GetMapping("/current")
    public ResponseEntity<FiscalYearDTO> getCurrent() {
        final FiscalYear currentFiscalYear = fiscalYearService.getCurrent();
        return new ResponseEntity<>(new FiscalYearDTO(currentFiscalYear), HttpStatus.OK);
    }

    @PostMapping("/conclude")
    public ResponseEntity<Void> conclude() {
        fiscalYearService.conclude();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
