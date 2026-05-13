package com.example.project_management_system.service;

import com.example.project_management_system.dtos.*;
import com.example.project_management_system.enums.UserRoles;
import com.example.project_management_system.model.Users;
import com.example.project_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    UserRepository userRepository;

    public ResponseDTO registerNewUser(RequestRegistrationDTO user, Long adminId){


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
        Users users = new Users(user.getUserName(), user.getEmail(), user.getPassword(), user.getContactNumber(), user.getRole());
        userRepository.save(users);
        return new ResponseDTO(HttpStatus.OK.value(), "New User Registered Successfully!!");

    }

    public ResponseRemoveUserDTO removeUser(Long userId, Long adminId) {
        Users users = userRepository.findById(userId).orElse(null);
        if(users == null){
            return new ResponseRemoveUserDTO(HttpStatus.OK.value(), "No User Found",null);
        }
        if(users.getRole() == UserRoles.Admin){
            return new ResponseRemoveUserDTO(HttpStatus.OK.value(), "You Can Not Delete Admin",null);
        }

        Users admin = userRepository.findById(adminId).orElse(null);

        if(admin == null){
            return new ResponseRemoveUserDTO(HttpStatus.OK.value(),"Invalid Admin",null);
        }

        if(admin.getRole() != UserRoles.Admin){
            return new ResponseRemoveUserDTO(HttpStatus.OK.value(),"You Are Not Admin!!\nOnly Admin Can delete Users",null);
        }
        userRepository.deleteById(userId);
        return new ResponseRemoveUserDTO(HttpStatus.OK.value(), "User Deleted Successfully",users);
    }

    public ResponseViewAllUsersDTO viewAllUsers(Long adminId){

        Users admin = userRepository.findById(adminId).orElse(null);

        if(admin == null){
            return new ResponseViewAllUsersDTO(HttpStatus.OK.value(),"Invalid Admin",null);
        }

        if(admin.getRole() != UserRoles.Admin){
            return new ResponseViewAllUsersDTO(HttpStatus.OK.value(),"You Are Not Admin!! Only Admin Can View Users",null);
        }
        List<Users> users = userRepository.findAllUsers();
        if(users == null || users.isEmpty()){
            return new ResponseViewAllUsersDTO(HttpStatus.OK.value(), "No Users Found",null);
        }
        return new ResponseViewAllUsersDTO(HttpStatus.OK.value(), "Users Are :- ",users);
    }

    public ResponseRemoveUserDTO update(Long adminId, RequestUpdateUserRoleDTO requestUpdateUserRoleDTO){

        if(requestUpdateUserRoleDTO.getRole() == UserRoles.Admin){
            return new ResponseRemoveUserDTO(HttpStatus.OK.value(),"You Can Not Make Any Users Role As Admin",null);
        }


        Users admin = userRepository.findById(adminId).orElse(null);

        if(admin == null){
            return new ResponseRemoveUserDTO(HttpStatus.OK.value(),"Invalid Admin",null);
        }

        if(admin.getRole() != UserRoles.Admin){
            return new ResponseRemoveUserDTO(HttpStatus.OK.value(),"You Are Not Admin!! Only Admin Can delete Users",null);
        }

        Users users = userRepository.findById(requestUpdateUserRoleDTO.getUserId()).orElse(null);
        if(users == null){
            return new ResponseRemoveUserDTO(HttpStatus.OK.value(), "No User Found",null);
        }

        if(users.getRole() == UserRoles.Admin){
            return new ResponseRemoveUserDTO(HttpStatus.OK.value(), "You Are Admin You can not change Your role",users);
        }

        if(users.getRole() == requestUpdateUserRoleDTO.getRole()){
            return new ResponseRemoveUserDTO(HttpStatus.OK.value(), users.getUserName()+" is Already "+users.getRole(),users);
        }
        users.setRole(requestUpdateUserRoleDTO.getRole());
        userRepository.save(users);
        return new ResponseRemoveUserDTO(HttpStatus.OK.value(), "User Role Updated Successfully!!",users);


    }
}
