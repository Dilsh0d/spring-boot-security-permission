package com.security.annotation.springbootsecuritypermission.utils;

import com.security.annotation.springbootsecuritypermission.secutiry.SecurityUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static SecurityUserDetails getUser() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof SecurityUserDetails) {
            return (SecurityUserDetails) authentication.getPrincipal();
        }
        return null;
    }

    public static Long getUserId() {
        SecurityUserDetails user = getUser();
        if (user != null) {
            return user.getId();
        }
        return null;
    }
}
