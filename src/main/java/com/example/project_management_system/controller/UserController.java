package com.example.project_management_system.controller;


import com.example.project_management_system.dtos.LoginRequestDTO;
import com.example.project_management_system.dtos.ResponseDTO;
import com.example.project_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("log-in")
    public ResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        return userService.logIn(loginRequestDTO);
    }
}
