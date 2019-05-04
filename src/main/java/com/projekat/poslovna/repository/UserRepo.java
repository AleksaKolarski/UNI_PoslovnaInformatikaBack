package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.User;
import com.projekat.poslovna.repository.base.CustomSoftDeleteRepo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by milan.miljus on 2019-04-27 19:38.
 */
@Repository
public interface UserRepo extends CustomSoftDeleteRepo<User> {

    Optional<User> findByEmail(String email);
}
