package com.godbyul.first_project.repository.user;

import com.godbyul.first_project.domains.User;
import com.godbyul.first_project.exceptions.UserException;
import com.godbyul.first_project.repositories.user.MemoryUserRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemoryTest {
    MemoryUserRepositoryImpl repository = new MemoryUserRepositoryImpl();
    @AfterEach
    public void afterEach() {
        repository.clear();
    }

    @Test
    public void saveAndFindTestSuccess() {
        User user = User.builder()
                .uuid("1q2w3e4r!")
                .name("My Name")
                .socialProvider("test")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        repository.save(user);
        User result = repository.findById(user.getUuid()).get();
        assertThat(user).isEqualTo(result);
    }

    @Test
    public void findByIdTestNotExistUser() {
        User user = User.builder()
                .uuid("1q2w3e4r!")
                .name("My Name")
                .socialProvider("test")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        repository.save(user);
        User result = repository.findById("abcd").orElse(null);
        assertThat(result).isNull();
    }

    @Test
    public void findAllTest() {
        User user1 = User.builder()
                .uuid("1q2w3e4r!")
                .name("My Name")
                .socialProvider("test")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        User user2 = User.builder()
                .uuid("abcd")
                .name("Your Name")
                .socialProvider("test")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        repository.save(user1);
        repository.save(user2);
        List<User> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void deleteTestSuccess() {
        User user1 = User.builder()
                .uuid("1q2w3e4r!")
                .name("My Name")
                .socialProvider("test")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        User user2 = User.builder()
                .uuid("abcd")
                .name("Your Name")
                .socialProvider("test")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        repository.save(user1);
        repository.save(user2);
        repository.delete(user1.getUuid());
        List<User> result = repository.findAll();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.getFirst().getUuid()).isEqualTo(user2.getUuid());
    }

    @Test
    public void deleteTestFail() {
        User user1 = User.builder()
                .uuid("1q2w3e4r!")
                .name("My Name")
                .socialProvider("test")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        repository.save(user1);
        UserException exception = assertThrows(UserException.class, () -> {
            repository.delete("abcd");
        });
        assertThat(exception.getMessage()).isEqualTo(UserException.USER_NOT_FOUND_MESSAGE);
    }
}
