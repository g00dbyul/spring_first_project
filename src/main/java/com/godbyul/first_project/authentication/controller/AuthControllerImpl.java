package com.godbyul.first_project.authentication.controller;

import com.godbyul.first_project.authentication.domains.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthControllerImpl implements AuthController {
    @GetMapping("/{id}")
    @ResponseBody
    @Override
    public User findUserById(@PathVariable("id") String id) {
        return null;
    }



}

// https://accounts.kakao.com/login/?continue=https%3A%2F%2Fkauth.kakao.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26client_id%3D515d0925baf46f9220a8b0f434cb9da2%26scope%3Dprofile_nickname%2520account_email%26state%3DIURQ-X6GFa_g_9ep10-xfdt79LuXDyiNPJ_oRwyzANw%253D%26redirect_uri%3Dhttp%253A%252F%252Flocalhost%253A8080%252Flogin%252Foauth2%252Fcode%252Fkakao%26through_account%3Dtrue#login
