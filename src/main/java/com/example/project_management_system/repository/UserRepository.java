package com.example.project_management_system.repository;

import com.example.project_management_system.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Users,Long> {

    @Query
    Users findByUserName(String userName);

    @Query
    Users findByUserNameAndPassword(String userName,String password);

}
