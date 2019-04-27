package com.projekat.poslovna.security;

import com.projekat.poslovna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Util {
	
	@Autowired
	private UserService userService;
	
	public User getCurrentUser() {
		String userEmail;
		Authentication currentUserAuth;
		currentUserAuth = SecurityContextHolder.getContext().getAuthentication();
		if(currentUserAuth != null) {
			userEmail = currentUserAuth.getName();
			if(userEmail != null) {
				if(userService != null) {
					Optional<User> user = userService.findByEmail(userEmail);
					if (user.isPresent()) {
						return user.get();
					} else {
						return null;
					}
				}
				System.out.println("USER SERVICE = NULL");
			}
			return null;
		}
		return null;
	}
}
