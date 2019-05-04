package com.projekat.poslovna.controller;

import com.projekat.poslovna.entity.Role;
import com.projekat.poslovna.entity.User;
import com.projekat.poslovna.security.Util;
import com.projekat.poslovna.service.RoleServiceImpl;
import com.projekat.poslovna.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projekat.poslovna.dto.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private Util util;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private RoleServiceImpl roleService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	

	@GetMapping("/currentUser")
	public ResponseEntity<UserDTO> getCurrentEmployee(){
		User user = util.getCurrentUser();
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
		
		if(userDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		String firstname = userDTO.getFirstname();
		String lastname = userDTO.getLastname();
		String email = userDTO.getEmail();
		String password = userDTO.getPassword();
		
		if(firstname == null || firstname.length() == 0 || firstname.length() > 255) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(lastname == null || lastname.length() == 0 || lastname.length() > 255) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(email == null || email.length() == 0 || email.length() > 255) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(password == null || password.length() < 3) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(userService.findByEmail(email).isPresent()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		
		User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setEmail(email);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleService.findByName("ROLE_ADMIN").orElse(null));
		
		user.setRoles(roles);
		
		user = userService.save(user);
		
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
	}
}
