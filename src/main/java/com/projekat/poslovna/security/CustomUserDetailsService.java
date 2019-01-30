package com.projekat.poslovna.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projekat.poslovna.entity.Employee;
import com.projekat.poslovna.service.EmployeeService;


@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Override
    public UserDetails loadUserByUsername(String username) {
        Employee employee = employeeService.findByEmail(username);
        if (employee == null) {
        	return null;
        } else {
            return employee;
        }
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = currentUser.getName();
        if (authenticationManager != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
        } else {
            return false;
        }
        Employee employee = (Employee) loadUserByUsername(username);
        if(employee == null) {
        	return false;
        }
        employee.setPassword(passwordEncoder.encode(newPassword));
        employee = employeeService.save(employee);
        if(employee == null) {
        	return false;
        }
        return true;
    }
}