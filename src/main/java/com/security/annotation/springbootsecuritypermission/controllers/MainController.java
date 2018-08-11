package com.security.annotation.springbootsecuritypermission.controllers;

import com.security.annotation.springbootsecuritypermission.aspect.PermissionCheck;
import com.security.annotation.springbootsecuritypermission.utils.Workspace;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/","/login"})
    public String login() {
        return "login";
    }

    @GetMapping("dashboard")
    @PermissionCheck(workspace = {Workspace.DASHBOARD},read = true)
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("projects")
    @PermissionCheck(workspace = {Workspace.PROJECT},read = true)
    public String projects() {
        return "projects";
    }

    @GetMapping("tasks")
    @PermissionCheck(workspace = {Workspace.TASK},read = true)
    public String tasks() {
        return "tasks";
    }

    @GetMapping("teams")
    @PermissionCheck(workspace = {Workspace.TEAM},read = true)
    public String teams() {
        return "teams";
    }

    @GetMapping("employees")
    @PermissionCheck(workspace = {Workspace.EMPLOYEE},read = true)
    public String employees() {
        return "employees";
    }

    @GetMapping("accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
}
