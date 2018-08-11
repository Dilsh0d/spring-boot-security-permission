package com.security.annotation.springbootsecuritypermission.jpadata;

import com.security.annotation.springbootsecuritypermission.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
