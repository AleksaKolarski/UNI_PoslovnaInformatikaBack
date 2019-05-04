package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Company;
import com.projekat.poslovna.entity.User;
import com.projekat.poslovna.repository.UserRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends CrudImpl<User> implements UserService {

	private final UserRepo repo;

	public UserServiceImpl(UserRepo repo) {
		super(repo);
		this.repo = repo;
	}

	@Override
	public Optional<User> findByEmail(String email) {
		throw new RuntimeException("not implemented");
	}

	@Override
	public List<User> findByCompany(Company company) {
		throw new RuntimeException("not implemented");
	}
}
