package com.example.project_management_system.service;

import com.example.project_management_system.dtos.ResponseDTO;
import com.example.project_management_system.enums.UserRoles;
import com.example.project_management_system.model.Users;
import com.example.project_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    UserRepository userRepository;

    public ResponseDTO registerNewUser(Users user,Long adminId){

        if(user.getRole() == UserRoles.Admin){
            return new ResponseDTO(HttpStatus.OK.value(), "You can not register new User as Admin");
        }

        Users u = userRepository.findByUserName(user.getUserName());
        if(u != null){
            return new ResponseDTO(HttpStatus.OK.value(), "User with the user name Already Exist");
        }

        Users admin = userRepository.findById(adminId).orElse(null);

        if(admin == null){
            return new ResponseDTO(HttpStatus.OK.value(),"Invalid Admin");
        }

        if(admin.getRole() != UserRoles.Admin){
            return new ResponseDTO(HttpStatus.OK.value(),"You Are Not Admin!!\nOnly Admin Can Register new Users");
        }

        userRepository.save(user);
        return new ResponseDTO(HttpStatus.OK.value(), "New User Registered Successfully!!");

    }
}
