package com.example.project_management_system.exceptions;

public class JWTAuthenticationException extends RuntimeException{
    public JWTAuthenticationException(String message) {
        super(message);
    }

    public JWTAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
