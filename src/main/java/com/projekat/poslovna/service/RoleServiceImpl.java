package com.projekat.poslovna.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.poslovna.entity.Role;
import com.projekat.poslovna.repository.RoleRepo;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepo roleRepository;

	@Override
	public Role save(Role entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Role entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Role> findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Role> findByName(String name) {
		return roleRepository.findByName(name);
	}

}
