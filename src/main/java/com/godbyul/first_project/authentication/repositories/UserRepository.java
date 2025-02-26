package com.godbyul.first_project.authentication.repositories;

import com.godbyul.first_project.authentication.domains.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(String uuid);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    void deleteById(String id);
    void deleteAll();
}
