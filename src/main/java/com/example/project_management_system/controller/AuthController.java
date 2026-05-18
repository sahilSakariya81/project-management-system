package com.example.project_management_system.controller;

import com.example.project_management_system.dtos.LoginRequestDTO;
import com.example.project_management_system.dtos.LoginResponseDTO;
import com.example.project_management_system.dtos.ResponseDTO;
import com.example.project_management_system.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("log-in")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO loginRequestDTO){
        return userService.logIn(loginRequestDTO);
    }

    @PostMapping("log-out")
    public ResponseDTO logOut(@RequestHeader("Authorization") String authToken){
        return userService.logOut(authToken);
    }
}
