package com.easybank.easybankbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
}
