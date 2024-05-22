package com.mls.database.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthenticationSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auth -> auth
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Allow pre-flight requests
                        .antMatchers(HttpMethod.GET, "/players/**").permitAll() // Allow GET requests to /players
                        .antMatchers(HttpMethod.DELETE, "/players/**").permitAll() // Allow DELETE requests to /players
                        .antMatchers(HttpMethod.POST, "/players/**").permitAll() // Allow POST requests to /players
                        .antMatchers(HttpMethod.PUT, "/players/**").permitAll() // Allow PUT requests to /players
                        .anyRequest().authenticated() // Authenticate all other requests

                )
                .httpBasic(Customizer.withDefaults()) // Use basic authentication
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session management
                .csrf().disable(); // Disable CSRF protection for simplicity in API

        return http.build();
    }
}
