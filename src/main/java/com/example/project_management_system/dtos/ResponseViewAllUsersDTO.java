package com.example.project_management_system.dtos;

import com.example.project_management_system.model.Users;

import java.util.List;

public class ResponseViewAllUsersDTO {
    private int statusCode;
    private String msg;
    private List<Users> users;

    public ResponseViewAllUsersDTO(int statusCode, String msg, List<Users> users) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.users = users;
    }

    public ResponseViewAllUsersDTO(){}

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

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
