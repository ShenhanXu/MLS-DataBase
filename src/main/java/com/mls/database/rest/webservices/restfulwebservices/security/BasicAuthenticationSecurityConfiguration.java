package com.mls.database.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthenticationSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and() // Enable CORS and apply the custom CORS configuration
                .authorizeRequests(auth -> auth
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Allow pre-flight requests
                        .antMatchers(HttpMethod.GET, "/**").permitAll() // Allow GET requests to /players
                        .antMatchers(HttpMethod.DELETE, "/**").permitAll() // Allow DELETE requests to /players
                        .antMatchers(HttpMethod.POST, "/**").permitAll() // Allow POST requests to /players
                        .antMatchers(HttpMethod.PUT, "/**").permitAll() // Allow PUT requests to /players
                        .anyRequest().authenticated() // Authenticate all other requests
                )
                .httpBasic()
                .and()
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session management
                .csrf().disable(); // Disable CSRF protection for simplicity in API

        return http.build();
    }
}
