package com.easybank.easybankbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //httpSecurity.authorizeRequests().anyRequest().authenticated();
        //httpSecurity.authorizeHttpRequests()  -- this also works as below
        httpSecurity.authorizeRequests()
                .antMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                .antMatchers("/notices","/contact").permitAll()
                        .and().formLogin()
                        .and().httpBasic();

        //httpSecurity.authorizeHttpRequests()
        //httpSecurity.formLogin();
        //httpSecurity.httpBasic();
        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        //Approach 1 - Not recommended - use deprecated withDefaultPasswordEncoder() while creating user details
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("test1")
                .authorities("admin")
                .build();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("test2")
                .authorities("user")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }
}
