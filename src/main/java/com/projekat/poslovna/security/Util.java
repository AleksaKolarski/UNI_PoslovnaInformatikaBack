package com.projekat.poslovna.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.projekat.poslovna.entity.Employee;
import com.projekat.poslovna.service.EmployeeService;

@Component
public class Util {
	
	@Autowired
	private EmployeeService employeeService;
	
	public Employee getCurrentUser() {
		String userEmail;
		Authentication currentUserAuth;
		currentUserAuth = SecurityContextHolder.getContext().getAuthentication();
		if(currentUserAuth != null) {
			userEmail = currentUserAuth.getName();
			if(userEmail != null) {
				if(employeeService != null) {
					return employeeService.findByEmail(userEmail);
				}
				System.out.println("USER SERVICE = NULL");
			}
			return null;
		}
		return null;
	}
}
