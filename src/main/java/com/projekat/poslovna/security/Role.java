package com.projekat.poslovna.security;

import com.projekat.poslovna.entity.RoleEntity;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by milan.miljus on 2019-04-28 00:57.
 */
public class Role extends RoleEntity implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Override
    public String getAuthority() {
        return this.getName();
    }
}
