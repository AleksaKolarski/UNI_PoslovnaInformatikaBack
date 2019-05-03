package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by milan.miljus on 2019-04-27 19:38.
 */
@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);
}
