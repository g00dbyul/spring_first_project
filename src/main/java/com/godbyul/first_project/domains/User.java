package com.godbyul.first_project.domains;

import lombok.Getter;

import java.util.Date;

@Getter
public class User {
    private String uuid;
    private String name;
    private String socialProvider;
    private Date createdAt;
    private Date updatedAt;

    public User(String uuid, String name, String socialProvider, Date createdAt, Date updatedAt) {
        this.uuid = uuid;
        this.name = name;
        this.socialProvider = socialProvider;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
