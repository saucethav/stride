package com.stride.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //Marks as configuration class

public class SecurityConfig {

    @Bean //registers the return value of method
    public SecurityFilterChain filterCHain(HttpSecurity http) throws Exception{
        http
                //disable protection
                .csrf(csrf -> csrf.disable())
                //Override login
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

            return http.build();
    }

}
