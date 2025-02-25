package com.godbyul.first_project.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize ->
                authorize.requestMatchers("/api/v1/sign/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .oauth2Login(oAuth -> oAuth
                        .loginPage("/api/v1/sign/in")
//                        .successHandler()
//                        .failureHandler()
//                        .userInfoEndpoint()
                        // 로그인 로직 처리
                )
//                .formLogin(login -> login.loginPage("/api/v1/sign/in"))
                .logout(LogoutConfigurer::permitAll)
                .csrf(Customizer.withDefaults());
        return http.build();
    }
}
