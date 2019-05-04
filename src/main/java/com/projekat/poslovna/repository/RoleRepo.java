package com.projekat.poslovna.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekat.poslovna.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, UUID> {

	Optional<Role> findByName(String name);
	
}
