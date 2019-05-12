package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.User;
import com.projekat.poslovna.repository.UserRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends CrudImpl<User> {

	private final UserRepo repo;

	public UserService(UserRepo repo) {
		super(repo);
		this.repo = repo;
	}

	public Optional<User> findByEmail(String email) {
		throw new RuntimeException("not implemented");
	}

}
