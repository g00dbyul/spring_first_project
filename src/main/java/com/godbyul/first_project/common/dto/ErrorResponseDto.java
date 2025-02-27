package com.godbyul.first_project.common.dto;

import lombok.Builder;

@Builder
public class ErrorResponseDto {
    private int code;
    private String status;
    private String reason;
}
