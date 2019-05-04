package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Role;
import com.projekat.poslovna.service.base.ICrud;

import java.util.Optional;

public interface RoleService extends ICrud<Role> {

	Optional<Role> findByName(String name);
	
}
