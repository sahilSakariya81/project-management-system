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
    public ResponseDTO registerNewUser(@Valid @RequestBody RequestRegistrationDTO user , @RequestHeader Long adminId){
        return adminService.registerNewUser(user,adminId);
    }

    @DeleteMapping("remove-user")
    public ResponseRemoveUserDTO removeUser(@Valid @RequestParam Long userId, @RequestHeader Long adminId){
        return adminService.removeUser(userId,adminId);
    }

    @GetMapping("get-all-users")
    public ResponseViewAllUsersDTO getAllUsers(@RequestHeader Long adminId){
        return adminService.viewAllUsers(adminId);
    }

    @PutMapping("update-user-role")
    public ResponseRemoveUserDTO updateUserRoel(@RequestHeader Long adminId,@RequestBody RequestUpdateUserRoleDTO dto){
        return adminService.update(adminId,dto);
    }





}
