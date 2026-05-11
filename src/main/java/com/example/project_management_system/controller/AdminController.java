package com.example.project_management_system.controller;

import com.example.project_management_system.dtos.ResponseDTO;
import com.example.project_management_system.model.Users;
import com.example.project_management_system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("register-new-user")
    public ResponseDTO registerNewUser(@RequestBody Users user , @RequestHeader Long adminId){
        return adminService.registerNewUser(user,adminId);
    }
}
