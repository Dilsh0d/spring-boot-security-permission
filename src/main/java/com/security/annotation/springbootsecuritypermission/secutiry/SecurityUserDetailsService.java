package com.security.annotation.springbootsecuritypermission.secutiry;

import com.security.annotation.springbootsecuritypermission.domain.UserEntity;
import com.security.annotation.springbootsecuritypermission.jpadata.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<UserEntity> optional = userRepository.findByUsername(username);
        if (optional.isPresent()) {
            UserEntity user = optional.get();
            return new SecurityUserDetails(user.getId(),user.getUsername(),user.getPassword(),user.getRoles());
        }
        throw new UsernameNotFoundException(username);
    }
}
