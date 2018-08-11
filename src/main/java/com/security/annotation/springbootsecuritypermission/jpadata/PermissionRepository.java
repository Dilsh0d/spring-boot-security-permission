package com.security.annotation.springbootsecuritypermission.jpadata;

import com.security.annotation.springbootsecuritypermission.domain.PermissionEntity;
import com.security.annotation.springbootsecuritypermission.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
    List<PermissionEntity> findByRolesAndWorkspaceIn(Roles roles,String... workspace);
}
