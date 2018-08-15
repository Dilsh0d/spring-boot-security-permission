# spring-boot-security-permission
Spring Boot create custom permission check for each request

## Used technology
* [SpringBoot](https://spring.io/projects/spring-boot)
* [SpringSecurity](https://spring.io/projects/spring-security)
* [SpringMVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)
* [SpringData](https://spring.io/projects/spring-data)
* [Hibernate](http://hibernate.org/orm/documentation/5.3/)
* [Spring Thymeleaf](https://www.thymeleaf.org/documentation.html)
* [Spring AOP](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#aop)
* [Postgresql 10](https://www.postgresql.org/docs/10/static/)

After run application at the resources/sqlpatch folder have two sql falies. Applay these files to databases.

* [permission.sql](https://github.com/Dilsh0d/spring-boot-security-permission/blob/master/src/main/resources/sqlpatch/permission.sql)
* [users.sql](https://github.com/Dilsh0d/spring-boot-security-permission/blob/master/src/main/resources/sqlpatch/users.sql)

Permission table contains these are data.

| Roles  | Workspace | Read | Write | Delete |
| ------ | --------- |------|-------|--------|
| Admin  | Dashboard | true | true | true |
| Admin  | Employee | true | true | true |
| Admin  | Project | true | true | true |
| Admin  | Task | true | true | true |
| Admin  | Team | true | true | true |
| Pm  | Dashboard | true | false | false |
| Pm  | Employee | true | false | false |
| Pm  | Project | true | true | true |
| Pm  | Task | true | true | true |
| Pm  | Team | true | false | false |
| TeamLead | Dashboard | true | false | false |
| TeamLead | Employee | true | true | true |
| TeamLead | Project | true | false | false |
| TeamLead | Task | true | false | false |
| TeamLead | Team | true | true | true |
| User | Dashboard | false | false | false |
| User | Employee | true | false | false |
| User | Project | true | false | false |
| User | Task | true | true | false |
| User | Team | true | false | false |

Create custom annotation check user permission to workspace.
1. PermissionCheck.class
```
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionCheck {

    String[] workspace() default {};

    boolean read() default false;

    boolean write() default false;

    boolean delete() default false;
}
```
2. PermissionAspect.class
```
@Aspect
@Component
public class PermissionAspect {

    @Autowired
    private PermissionRepository permissionRepository;

    @Around("execution(@com.security.annotation.springbootsecuritypermission.aspect.PermissionCheck * *(..)) && @annotation(permissionCheck)")
    public Object doSomething(ProceedingJoinPoint pjp, PermissionCheck permissionCheck) throws Throwable {
        if(permissionCheck.workspace().length>0
                && SecurityUtil.getUser()!=null){
           List<PermissionEntity> permissionList = permissionRepository.findByRolesAndWorkspaceIn(
                    SecurityUtil.getUser().getRoles(),permissionCheck.workspace());


           Function<PermissionEntity,Boolean> permissionFunction = new Function<PermissionEntity, Boolean>() {
               @Override
               public Boolean apply(PermissionEntity permissionEntity) {
                   if(permissionCheck.read() && permissionEntity.getRead()) {
                       return true;
                   }
                   if(permissionCheck.write() && permissionEntity.getWrite()) {
                       return true;
                   }
                   if(permissionCheck.delete() && permissionEntity.getDelete()) {
                       return true;
                   }
                   return false;
               }
           };

           final boolean[] hasPermission = {false};
           permissionList.forEach(permissionEntity -> {
               hasPermission[0] = permissionFunction.apply(permissionEntity);
               if(hasPermission[0]){
                   return;
               }
           });

            if(!hasPermission[0]){
                throw new AccessDeniedException("Do not has permission");
            }

        }
        return pjp.proceed();
    }
}
```
This is PermissionCheck.class annotation to use in Controllers.

```
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
```
If AccesDeniedException then SpringBootPermissionSecurity.class written logic redirect to **/accessDenied** url.
```
.accessDeniedPage("/accessDenied")
```
 
