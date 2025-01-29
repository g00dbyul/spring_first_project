package com.godbyul.first_project.domains;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Builder
@EqualsAndHashCode
public class User {
    private String uuid;
    private String name;
    private String socialProvider;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
