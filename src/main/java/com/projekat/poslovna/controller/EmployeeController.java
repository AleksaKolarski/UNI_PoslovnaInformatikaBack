package com.projekat.poslovna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projekat.poslovna.dto.EmployeeDTO;
import com.projekat.poslovna.entity.Employee;
import com.projekat.poslovna.security.Util;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private Util util;
	
	@GetMapping("/currentEmployee")
	public ResponseEntity<EmployeeDTO> getCurrentEmployee(){
		Employee employee = util.getCurrentUser();
		if(employee == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new EmployeeDTO(employee), HttpStatus.OK);
	}
}
