package com.projekat.poslovna.service;

import java.util.List;

import com.projekat.poslovna.entity.Company;
import com.projekat.poslovna.entity.Employee;

public interface EmployeeService {

	Employee findById(int id);
	
	Employee findByEmail(String email);
	
	List<Employee> findByCompany(Company company);
	
	List<Employee> findAll();
	
	Employee save(Employee documentItem);
	
	Employee update(Employee documentItem);
	
	void delete(Employee documentItem);
}
