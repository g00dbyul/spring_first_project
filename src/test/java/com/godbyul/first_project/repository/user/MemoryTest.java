package com.godbyul.first_project.repository.user;

import com.godbyul.first_project.domains.User;
import com.godbyul.first_project.repositories.user.MemoryUserRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryTest {
    MemoryUserRepositoryImpl repository = new MemoryUserRepositoryImpl();
    @AfterEach
    public void afterEach() {
        repository.clear();
    }

    @Test
    public void saveAndFindTestSuccess() {
        User user = new User("1q2w3e4r!", "My Name", "test",LocalDateTime.now(), LocalDateTime.now());
        repository.save(user);
        User result = repository.findById(user.getUuid()).get();
        assertThat(user).isEqualTo(result);
    }

    @Test
    public void saveTestFail() {
        User user = new User("1q2w3e4r!", "My Name", "test",LocalDateTime.now(), LocalDateTime.now());
        repository.save(user);
        User duplicateUser = new User("1q2w3e4r!", "My Name", "test",LocalDateTime.now(), LocalDateTime.now());
        try {
            repository.save(duplicateUser);
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 유저입니다.");
        }
    }

    @Test
    public void findByIdTestNotExistUser() {
        User user = new User("1q2w3e4r!", "My Name", "test",LocalDateTime.now(), LocalDateTime.now());
        repository.save(user);
        User result = repository.findById("abcd").orElse(null);
        assertThat(result).isNull();
    }

    @Test
    public void findAllTest() {
        User user1 = new User("aaa", "My Name", "test",LocalDateTime.now(), LocalDateTime.now());
        User user2 = new User("bbb", "Your name", "test",LocalDateTime.now(), LocalDateTime.now());
        repository.save(user1);
        repository.save(user2);
        List<User> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void deleteTestSuccess() {
        User user1 = new User("aaa", "My Name", "test",LocalDateTime.now(), LocalDateTime.now());
        User user2 = new User("bbb", "Your name", "test",LocalDateTime.now(), LocalDateTime.now());
        repository.save(user1);
        repository.save(user2);
        repository.delete(user1.getUuid());
        List<User> result = repository.findAll();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.getFirst().getUuid()).isEqualTo(user2.getUuid());
    }

    @Test
    public void deleteTestFail() {
        User user1 = new User("aaa", "My Name", "test",LocalDateTime.now(), LocalDateTime.now());
        try {
            repository.delete(user1.getUuid());
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("존재하지 않는 유저입니다.");
        }
    }
}
