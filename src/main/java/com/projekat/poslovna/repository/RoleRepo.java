package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.Role;
import com.projekat.poslovna.repository.base.CustomSoftDeleteRepo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends CustomSoftDeleteRepo<Role> {

	Optional<Role> findByName(String name);
	
}
