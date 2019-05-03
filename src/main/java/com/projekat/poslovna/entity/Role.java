package com.projekat.poslovna.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Role extends BaseEntity implements GrantedAuthority{

	@NotNull
	@NotBlank
	private String name;

	@ManyToMany(mappedBy = "roles")
	private List<User> employees;

	// Spring security

	private static final long serialVersionUID = 1L;

	@Override
	public String getAuthority() {
		return name;
	}
}
