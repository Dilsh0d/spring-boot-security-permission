package com.security.annotation.springbootsecuritypermission;

import com.security.annotation.springbootsecuritypermission.secutiry.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringBootPermissionSecurity extends WebSecurityConfigurerAdapter {

    private static final String[] noFilterPages = new String[]
            {"/", "/login.html*","/css/**", "/js/**", "/img/**","/fonts/**"};

    @Bean
    public UserDetailsService createUserDetailsBean() {
        return new SecurityUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(createUserDetailsBean()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public LoginUrlAuthenticationEntryPoint createDelegateAuthEntryPoint(){
        return new LoginUrlAuthenticationEntryPoint("/login.html");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(noFilterPages).permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(createDelegateAuthEntryPoint())
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .failureUrl("/login.html?error")
                .defaultSuccessUrl("/main.html")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .rememberMe()
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .invalidSessionUrl("/login.html");
    }

}
