package com.projekat.poslovna.service;

import java.util.Optional;

import com.projekat.poslovna.entity.Role;

public interface RoleService extends ICrud<Role> {

	Optional<Role> findByName(String name);
	
}
