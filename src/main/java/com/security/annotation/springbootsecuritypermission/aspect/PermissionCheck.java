package com.security.annotation.springbootsecuritypermission.aspect;

import com.security.annotation.springbootsecuritypermission.domain.Roles;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionCheck {

    String[] workspace() default {};

    boolean read() default false;

    boolean write() default false;

    boolean delete() default false;
}
