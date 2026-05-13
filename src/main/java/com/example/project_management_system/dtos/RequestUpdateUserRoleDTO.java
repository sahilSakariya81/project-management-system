package com.example.project_management_system.dtos;

import com.example.project_management_system.enums.UserRoles;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RequestUpdateUserRoleDTO {

    @NotNull(message = "User Id is required")
    private Long userId;

    @NotNull(message = "Role is required")
    @Enumerated(EnumType.STRING)
    private UserRoles role;

    public RequestUpdateUserRoleDTO(Long userId, UserRoles role) {
        this.userId = userId;
        this.role = role;
    }

    public RequestUpdateUserRoleDTO(){}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }
}
