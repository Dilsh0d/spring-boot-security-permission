package com.security.annotation.springbootsecuritypermission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = "com.security.annotation.springbootsecuritypermission.jpadata")
public class SpringBootSecurityPermissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityPermissionApplication.class, args);
		System.out.println("Our project run with http://localhost:8080");
	}
}
