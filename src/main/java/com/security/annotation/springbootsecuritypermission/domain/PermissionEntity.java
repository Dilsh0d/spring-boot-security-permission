package com.security.annotation.springbootsecuritypermission.domain;

import javax.persistence.*;

@Entity
@Table(name = "permission")
public class PermissionEntity extends BaseEntity{

    @Column(name = "roles")
    @Enumerated(EnumType.STRING)
    private Roles roles;

    @Basic
    private String workspace;

    @Basic
    private Boolean read = Boolean.FALSE;

    @Basic
    private Boolean write = Boolean.FALSE;

    @Basic
    private Boolean delete = Boolean.FALSE;


    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Boolean getWrite() {
        return write;
    }

    public void setWrite(Boolean write) {
        this.write = write;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}
