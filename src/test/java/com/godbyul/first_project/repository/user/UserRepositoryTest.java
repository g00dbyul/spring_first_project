package com.godbyul.first_project.repository.user;

import com.godbyul.first_project.domains.User;
import com.godbyul.first_project.repositories.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;


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
                .name("test")
                .socialProvider("provider")
                .build();
        userRepository.save(user);
        List<User> users = userRepository.findAll();
        assertThat(users.size()).isEqualTo(1);
        assertThat(users.get(0).getName()).isEqualTo("test");
    }

    @Test
    void findById() {
        User user = User.builder()
                .name("test")
                .socialProvider("provider")
                .build();
        userRepository.save(user);

        User foundUser = userRepository.findById(user.getUuid()).orElse(null);
        assertThat(foundUser.getName()).isEqualTo("test");
    }

    @Test
    void updateUser() {
        User user = User.builder()
                .name("test")
                .socialProvider("provider")
                .build();
        userRepository.save(user);

        User updatedUser = User.builder()
                .uuid(user.getUuid())
                .name("updated")
                .socialProvider("provider")
                .build();
        userRepository.save(updatedUser);

        List<User> users = userRepository.findAll();
        assertThat(users.size()).isEqualTo(1);
    }

    @Test
    void findByNameSuccess() {
        User user = User.builder()
                .name("test")
                .socialProvider("provider")
                .build();
        userRepository.save(user);

        User foundUser = userRepository.findByName("test").orElse(null);
        assertThat(foundUser.getName()).isEqualTo("test");
    }

    @Test
    void findByNameFail() {
        User user = User.builder()
                .name("test")
                .socialProvider("provider")
                .build();
        userRepository.save(user);

        User foundUser = userRepository.findByName("test2").orElse(null);
        assertThat(foundUser).isNull();
    }

    @Test
    void deleteById() {
        User user = User.builder()
                .name("test")
                .socialProvider("provider")
                .build();
        userRepository.save(user);

        userRepository.deleteById(user.getUuid());
        List<User> users = userRepository.findAll();
        assertThat(users.size()).isEqualTo(0);
    }
}
