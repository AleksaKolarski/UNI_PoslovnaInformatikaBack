package com.projekat.poslovna.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.projekat.poslovna.entity.User;
import com.projekat.poslovna.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.poslovna.entity.Company;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public Optional<User> findById(UUID id) {
		Optional<User> optional = userRepo.findById(id);
		return optional;
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public List<User> findByCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User save(User user) {
		return userRepo.save(user);
	}
	@Override
	public void delete(User documentItem) {
		// TODO Auto-generated method stub
		
	}

}
