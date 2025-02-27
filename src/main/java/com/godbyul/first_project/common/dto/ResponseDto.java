package com.godbyul.first_project.common.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class ResponseDto<T> {
    private final int statusCode;
    private final String message;
    private final T data;
}
