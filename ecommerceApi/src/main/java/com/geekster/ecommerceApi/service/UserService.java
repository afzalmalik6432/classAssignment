package com.geekster.ecommerceApi.service;

import com.geekster.ecommerceApi.dao.IUserDao;
import com.geekster.ecommerceApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserDao userDao;

    public int addUser(User user){
        User savedUser = userDao.save(user);
        return savedUser.getUserId();
    }

    public User getUserById(Integer id){
        return userDao.findById(id).get();
    }

}
