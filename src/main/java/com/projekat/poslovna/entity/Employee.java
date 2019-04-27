package com.projekat.poslovna.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Employee extends BaseEntity {

	@NotNull
	@NotBlank
	private String firstName;

	@NotNull
	@NotBlank
	private String lastName;

	@NotNull
	@Email
	@Column(unique = true)
	private String email;

	@NotNull
	@NotBlank
	private String password;

	@ManyToMany
	private List<RoleEntity> roles;

	@ManyToMany(mappedBy = "employees")
	private List<Warehouse> warehouses;

}
