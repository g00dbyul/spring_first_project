package com.godbyul.first_project.authentication.dto;

import com.godbyul.first_project.authentication.domains.User;

import java.time.LocalDateTime;

public class UserResponseDto {
    private String username;
    private String email;
    private LocalDateTime createdAt;

    public UserResponseDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
    }
}
