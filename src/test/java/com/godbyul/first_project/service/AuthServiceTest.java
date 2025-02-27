package com.godbyul.first_project.service;

import com.godbyul.first_project.authentication.domains.User;
import com.godbyul.first_project.authentication.dto.CreateUserDto;
import com.godbyul.first_project.authentication.repositories.UserRepository;
import com.godbyul.first_project.authentication.service.AuthService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class AuthServiceTest {
    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @AfterEach
    void afterAll() {
        userRepository.deleteAll();
    }

    @Test
    void CreateUserTestSuccess() {
        CreateUserDto createUserDto = new CreateUserDto("test", "test", "test-email");
        User user = authService.createUser(createUserDto);
        assertThat(user.getUsername()).isEqualTo("test");
        assertThat(user.getEmail()).isEqualTo("test-email");
        assertThat(passwordEncoder.matches("test", user.getPassword())).isTrue();
    }

    @Test
    void CreateUserTestFailByDuplicatedUsername() {
        CreateUserDto createUserDto = new CreateUserDto("test", "test", "test-email");
        authService.createUser(createUserDto);
        CreateUserDto duplicatedUser = new CreateUserDto("test", "test", "test-email");
        try {
            authService.createUser(duplicatedUser);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 사용자입니다.");
        }
    }

    @Test
    void CreateUserTestFailByDuplicatedEmail() {
        CreateUserDto createUserDto = new CreateUserDto("test", "test", "test-email");
        authService.createUser(createUserDto);
        CreateUserDto duplicatedUser = new CreateUserDto("test2", "test2", "test-email");
        try {
            authService.createUser(duplicatedUser);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 이메일입니다.");
        }
    }
}
