package com.godbyul.first_project.authentication.repositories;

import com.godbyul.first_project.authentication.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, String>, UserRepository {}
