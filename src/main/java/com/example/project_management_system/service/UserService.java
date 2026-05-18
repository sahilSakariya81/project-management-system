package com.example.project_management_system.service;

import com.example.project_management_system.dtos.LoginRequestDTO;
import com.example.project_management_system.dtos.LoginResponseDTO;
import com.example.project_management_system.dtos.ResponseDTO;
import com.example.project_management_system.model.Users;
import com.example.project_management_system.repository.UserRepository;
import com.example.project_management_system.security.TokenBlacklist;
import com.example.project_management_system.utility.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    TokenBlacklist blacklist;

    public LoginResponseDTO logIn(LoginRequestDTO loginRequestDTO) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequestDTO.getUserName(),loginRequestDTO.getPassword()
            ));

        }catch (Exception e){
                return new LoginResponseDTO(401,"User Not Found",null);
        }

        Users users = userRepository.findByUserName(loginRequestDTO.getUserName());

        String token = jwtUtil.generateToken(users);

        return new LoginResponseDTO(200,"LoggedIn Successfully",token);
    }

    public ResponseDTO logOut(String authToken) {

        if(authToken != null && authToken.startsWith("Bearer ")){
            String token = authToken.substring(7);
            blacklist.add(token);
        }

        return new ResponseDTO(HttpStatus.OK.value(), "Log-Out Successfully");
    }
}
