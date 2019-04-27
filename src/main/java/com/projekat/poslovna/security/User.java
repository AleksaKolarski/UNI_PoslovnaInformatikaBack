package com.projekat.poslovna.security;

import com.projekat.poslovna.entity.Employee;
import com.projekat.poslovna.entity.RoleEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by milan.miljus on 2019-04-28 00:41.
 */
public class User extends Employee implements UserDetails {

    private static final long serialVersionUID = 1L;

    public boolean getIsAdmin() {
        for(RoleEntity role: this.getRoles()) {
            if(role.getName().equals("ROLE_Admin")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles();
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
