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

