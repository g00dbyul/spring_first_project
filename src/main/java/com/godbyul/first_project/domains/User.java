package com.godbyul.first_project.domains;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class User {
    private String uuid;
    private String name;
    private String socialProvider;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(String uuid, String name, String socialProvider, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.uuid = uuid;
        this.name = name;
        this.socialProvider = socialProvider;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
