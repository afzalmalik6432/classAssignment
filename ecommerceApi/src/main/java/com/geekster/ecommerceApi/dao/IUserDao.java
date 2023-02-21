package com.geekster.ecommerceApi.dao;

import com.geekster.ecommerceApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User,Integer> {
}
