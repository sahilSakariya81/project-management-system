package com.example.project_management_system.service;

import com.example.project_management_system.dtos.LoginRequestDTO;
import com.example.project_management_system.dtos.ResponseDTO;
import com.example.project_management_system.model.Users;
import com.example.project_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseDTO logIn(LoginRequestDTO loginRequestDTO) {
        Users user = userRepository.findByUserNameAndPassword(loginRequestDTO.getUserName(), loginRequestDTO.getPassword());
        if(user == null){
            return new ResponseDTO(HttpStatus.OK.value(),"Invalid username or password");
        }
        return new ResponseDTO(HttpStatus.OK.value(), "Login Successfully");
    }
}
