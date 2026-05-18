package com.example.project_management_system.controller;

import com.example.project_management_system.dtos.*;
import com.example.project_management_system.model.Users;
import com.example.project_management_system.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("register-new-user")
    public ResponseDTO registerNewUser(@Valid @RequestBody RequestRegistrationDTO user){
        return adminService.registerNewUser(user);
    }

    @DeleteMapping("remove-user")
    public ResponseRemoveUserDTO removeUser(@Valid @RequestParam Long userId){
        return adminService.removeUser(userId);
    }

    @GetMapping("get-all-users")
    public ResponseViewAllUsersDTO getAllUsers(){
        return adminService.viewAllUsers();
    }

    @PutMapping("update-user-role")
    public ResponseRemoveUserDTO updateUserRoel(@RequestBody RequestUpdateUserRoleDTO dto){
        return adminService.update(dto);
    }





}
