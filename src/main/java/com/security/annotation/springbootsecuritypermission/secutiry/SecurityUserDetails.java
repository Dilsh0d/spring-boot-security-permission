package com.security.annotation.springbootsecuritypermission.secutiry;

import com.security.annotation.springbootsecuritypermission.domain.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecurityUserDetails extends org.springframework.security.core.userdetails.User {

    private Long id;
    private Roles roles;

    public SecurityUserDetails(Long id,String userName,String password,Roles roles) {
        super(userName,password, AuthorityUtils.createAuthorityList(roles.getRoleName()));
        this.id = id;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public Roles getRoles() {
        return roles;
    }
}
