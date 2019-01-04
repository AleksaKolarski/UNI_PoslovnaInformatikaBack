package com.projekat.poslovna.service;

import java.util.List;

import com.projekat.poslovna.entity.Role;

public interface RoleService {

	Role findById(int id);
	
	List<Role> findAll();
	
	Role save(Role role);
	
	Role update(Role role);
	
	void delete(Role role);
}
