package com.projekat.poslovna.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.projekat.poslovna.entity.Company;
import com.projekat.poslovna.entity.Employee;
import com.projekat.poslovna.entity.Warehouse;
import com.projekat.poslovna.security.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
	private UUID id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Boolean isAdmin;

	public UserDTO() {}
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.firstname = user.getFirstName();
		this.lastname = user.getLastName();
		this.email = user.getEmail();
		this.isAdmin = user.getIsAdmin();
	}
	
	public static List<UserDTO> parseList(List<User> list){
		List<UserDTO> listDTO = new ArrayList<>();
		for(User user: list) {
			listDTO.add(new UserDTO(user));
		}
		return listDTO;
	}
}
