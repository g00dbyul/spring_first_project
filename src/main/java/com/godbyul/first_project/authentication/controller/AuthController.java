package com.godbyul.first_project.authentication.controller;

import com.godbyul.first_project.authentication.domains.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "User API", description = "사용자 관련 API")
public interface AuthController {
    @Operation(summary = "사용자 조회", description = "아이디로 사용자를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "성공")
    User findUserById(@Parameter(description = "User ID", required = true) @PathVariable("id") String id);
}
