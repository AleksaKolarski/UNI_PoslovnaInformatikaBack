package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Role;
import com.projekat.poslovna.repository.RoleRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService extends CrudImpl<Role> {

	private final RoleRepo repo;

	public RoleService(RoleRepo repo) {
		super(repo);
		this.repo = repo;
	}

	public Optional<Role> findByName(String name) {
		return repo.findByName(name);
	}

}
