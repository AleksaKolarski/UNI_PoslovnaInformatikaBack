package com.projekat.poslovna.service;

import java.util.List;
import java.util.Optional;

import com.projekat.poslovna.entity.Company;
import com.projekat.poslovna.entity.User;

public interface UserService extends ICrud<User> {

	Optional<User> findByEmail(String email);
	
	List<User> findByCompany(Company company);
	
}
