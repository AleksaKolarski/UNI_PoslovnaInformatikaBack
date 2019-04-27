package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Employee;
import com.projekat.poslovna.security.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by milan.miljus on 2019-04-28 00:44.
 */
@Service
public class UserService  {

    private final EmployeeService employeeService;

    public UserService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Optional<User> findByEmail(String email) {
        Optional<Employee> employee = employeeService.findByEmail(email);
        if (employee.isPresent()){
            User user = (User) employee.get();
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

    public User save(User user) {
        return (User) employeeService.save(user);
    }
}
