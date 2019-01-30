package com.projekat.poslovna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.poslovna.entity.Company;
import com.projekat.poslovna.entity.Employee;
import com.projekat.poslovna.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee findById(int id) {
		Optional<Employee> optional = employeeRepo.findById(id);
		if(optional.isPresent() == false) {
			return null;
		}
		return optional.get();
	}

	@Override
	public Employee findByEmail(String email) {
		return employeeRepo.findByEmail(email);
	}

	@Override
	public List<Employee> findByCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee save(Employee documentItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee update(Employee documentItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Employee documentItem) {
		// TODO Auto-generated method stub
		
	}
}
