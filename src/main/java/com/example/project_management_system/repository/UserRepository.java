package com.example.project_management_system.repository;

import com.example.project_management_system.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Long> {

    Users findByUserName(String userName);


    Users findByUserNameAndPassword(String userName,String password);

    @Query(value = "SELECT * FROM users WHERE role != 'ADMIN'", nativeQuery = true)
    List<Users> findAllUsers();
}
