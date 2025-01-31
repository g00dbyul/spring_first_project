package com.godbyul.first_project.repositories.user;

import com.godbyul.first_project.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, String>, UserRepository {
    void deleteAll();
}
