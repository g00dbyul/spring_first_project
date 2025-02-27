package com.godbyul.first_project.authentication.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateUserDto {
    final String username;

    final String password;

    final String email;
}
