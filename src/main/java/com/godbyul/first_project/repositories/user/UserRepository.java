package com.godbyul.first_project.repositories.user;

import com.godbyul.first_project.domains.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(String id);
    List<User> findAll();
    void delete(String id);
}
