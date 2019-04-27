package com.projekat.poslovna.controller;

import com.projekat.poslovna.security.User;
import com.projekat.poslovna.security.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projekat.poslovna.dto.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private Util util;

	@GetMapping("/currentUser")
	public ResponseEntity<UserDTO> getCurrentEmployee(){
		User user = util.getCurrentUser();
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
	}
}
