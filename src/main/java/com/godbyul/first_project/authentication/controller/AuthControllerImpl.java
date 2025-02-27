package com.godbyul.first_project.authentication.controller;

import com.godbyul.first_project.authentication.domains.User;
import com.godbyul.first_project.authentication.dto.CreateUserDto;
import com.godbyul.first_project.authentication.dto.UserResponseDto;
import com.godbyul.first_project.authentication.service.AuthService;
import com.godbyul.first_project.common.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final AuthService authService;

    @GetMapping("/{id}")
    @ResponseBody
    @Override
    public ResponseEntity<ResponseDto<UserResponseDto>> findUserById(@PathVariable("id") String id) {
        System.out.println("id : " + id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user")
    @ResponseBody
    @Override
    public ResponseEntity<ResponseDto<UserResponseDto>> createUser(CreateUserDto userDto) {
        User user = authService.createUser(userDto);
        return ResponseEntity.ok(
                new ResponseDto<>(
                        HttpStatus.CREATED.value(),
                        "회원가입 성공",
                        new UserResponseDto(user)
                )
        );
    }
}

// https://accounts.kakao.com/login/?continue=https%3A%2F%2Fkauth.kakao.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26client_id%3D515d0925baf46f9220a8b0f434cb9da2%26scope%3Dprofile_nickname%2520account_email%26state%3DIURQ-X6GFa_g_9ep10-xfdt79LuXDyiNPJ_oRwyzANw%253D%26redirect_uri%3Dhttp%253A%252F%252Flocalhost%253A8080%252Flogin%252Foauth2%252Fcode%252Fkakao%26through_account%3Dtrue#login
