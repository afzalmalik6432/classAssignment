package com.example.validationUserManagement.dao;

import com.example.validationUserManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User,Integer> {
}
