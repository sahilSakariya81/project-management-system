package com.example.project_management_system.dtos;

import com.example.project_management_system.model.Users;

public class ResponseRemoveUserDTO {
    private int statusCode;
    private String msg;
    private Users user;

    public ResponseRemoveUserDTO(int statusCode, String msg, Users user) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.user = user;
    }

    public ResponseRemoveUserDTO(){}

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
