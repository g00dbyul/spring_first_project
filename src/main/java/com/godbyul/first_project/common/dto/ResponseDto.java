package com.godbyul.first_project.common.dto;

import lombok.Builder;

@Builder
public class ResponseDto<T> {
    private int statusCode;
    private String message;
    private T data;
}
