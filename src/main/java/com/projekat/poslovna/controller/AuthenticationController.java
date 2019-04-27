package com.projekat.poslovna.controller;

import com.projekat.poslovna.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projekat.poslovna.security.CustomUserDetailsService;
import com.projekat.poslovna.security.TokenHelper;


@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	TokenHelper tokenHelper;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@PostMapping(value = "/login", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> createAuthenticationToken(@RequestParam("email") String email, @RequestParam("password") String password) {
		Authentication authentication;
		try {
			authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
			System.out.println("/auth/login | User " + email + " successfully logged in");
		} catch (AuthenticationException e) {
			System.out.println("/auth/login | Someone tried to log in with wrong credentials");
			return new ResponseEntity<String>("Wrong email/password.", HttpStatus.FORBIDDEN);
		}
		// Ubaci username + password u kontext
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token
		User user = (User) authentication.getPrincipal();
		String jws = tokenHelper.generateToken(user.getEmail());

		// Vrati token kao odgovor na uspesno autentifikaciju
		return new ResponseEntity<String>(jws, HttpStatus.OK);
	}

	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	@PreAuthorize("hasRole('Magacioner')")
	public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
		userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	static class PasswordChanger {
		public String oldPassword;
		public String newPassword;
	}
}