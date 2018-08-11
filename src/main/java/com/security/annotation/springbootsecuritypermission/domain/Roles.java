package com.security.annotation.springbootsecuritypermission.domain;

public enum Roles {
    Admin("ROLE_ADMIN"),
    Pm("ROLE_PM"),
    TemaLead("ROLE_TEAM_LEAD"),
    User("ROLE_USER");

    private String roleName;

    Roles(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
