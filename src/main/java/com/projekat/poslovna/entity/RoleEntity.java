package com.projekat.poslovna.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class RoleEntity extends BaseEntity {

	@NotNull
	@NotBlank
	private String name;

	@ManyToMany(mappedBy = "roles")
	private List<Employee> employees;

}
