package com.projekat.poslovna.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.projekat.poslovna.entity.Company;
import com.projekat.poslovna.entity.Employee;

public interface EmployeeService extends ICrud<Employee> {

	Optional<Employee> findByEmail(String email);
	
	List<Employee> findByCompany(Company company);
	
}
