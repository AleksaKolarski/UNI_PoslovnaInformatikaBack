package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.User;
import com.projekat.poslovna.service.base.ICrud;

import java.util.Optional;

public interface UserService extends ICrud<User> {

	Optional<User> findByEmail(String email);

}
