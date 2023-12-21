package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    public static class OAuth2SecurityConfig {

        @Bean
        @Primary
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            http
                    .csrf().disable()
                    .cors().and()
                    .authorizeHttpRequests()
                    .anyRequest().authenticated()
                    .and().oauth2ResourceServer().jwt();

            return http.build();
        }
    }
}
