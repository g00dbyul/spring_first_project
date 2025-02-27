package com.godbyul.first_project.authentication.service;

import com.godbyul.first_project.authentication.domains.User;
import com.godbyul.first_project.authentication.dto.CreateUserDto;

public interface AuthService {
    User createUser(CreateUserDto createUserDto);
}
