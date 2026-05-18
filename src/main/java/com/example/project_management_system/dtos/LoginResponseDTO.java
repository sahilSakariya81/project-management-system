package com.example.project_management_system.dtos;

public class LoginResponseDTO {
    private int StatusCode;
    private String msg;
    private String jwtToken;

    public LoginResponseDTO(){}

    public LoginResponseDTO(int statusCode, String msg, String jwtToken) {
        StatusCode = statusCode;
        this.msg = msg;
        this.jwtToken = jwtToken;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
