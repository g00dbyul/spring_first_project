package com.godbyul.first_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/v1")
public class AuthController {
    @GetMapping("sign/in")
    @ResponseBody
    public String signIn() {
        return "index";
    }
}
