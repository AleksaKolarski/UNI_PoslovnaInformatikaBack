package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Role;
import com.projekat.poslovna.repository.RoleRepo;
import com.projekat.poslovna.service.base.CrudImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl extends CrudImpl<Role> implements RoleService {

	private final RoleRepo repo;

	public RoleServiceImpl(RoleRepo repo) {
		super(repo);
		this.repo = repo;
	}

	@Override
	public Optional<Role> findByName(String name) {
		return repo.findByName(name);
	}

}
