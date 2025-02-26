package com.godbyul.first_project.repository;

import com.godbyul.first_project.authentication.domains.User;
import com.godbyul.first_project.authentication.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void afterAll() {
        userRepository.deleteAll();
    }

    @Test
    void saveAndFindUser() {
        User user = User.builder()
                .username("test")
                .password("test")
                .email("test-email")
                .build();

        userRepository.save(user);
        List<User> users = userRepository.findAll();
        assertThat(users.size()).isEqualTo(1);
        assertThat(users.get(0).getUsername()).isEqualTo("test");
    }

    @Test
    void findByUserName() {
        User user = User.builder()
                .username("test")
                .password("test")
                .email("test-email")
                .build();
        userRepository.save(user);
        Optional<User> findUser = userRepository.findByUsername("test");
        assertThat(findUser.isPresent()).isTrue();
        assertThat(findUser.get().getUsername()).isEqualTo("test");
    }

    @Test
    void findByEmail() {
        User user = User.builder()
                .username("test")
                .password("test")
                .email("test-email")
                .build();
        userRepository.save(user);
        Optional<User> findUser = userRepository.findByEmail("test-email");
        assertThat(findUser.isPresent()).isTrue();
        assertThat(findUser.get().getEmail()).isEqualTo("test-email");
    }
}
