package com.example.validationUserManagement.service;

import com.example.validationUserManagement.dao.IUserDao;
import com.example.validationUserManagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserDao userDao;

    public void addUser(User user){
        userDao.save(user);
    }

    public User getUser(int id) {
        return userDao.findById(id).get();
    }

    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    public void deleteUser(Integer id){
        userDao.deleteById(id);
    }

    public void updateUser(User finalUserObject, Integer userId) {
        User user = userDao.findById(userId).get();
        user.setUserName(finalUserObject.getUserName());
        user.setNumber(finalUserObject.getNumber());
        user.setTime(finalUserObject.getTime());
        user.setDate(finalUserObject.getDate());
        user.setEmail(finalUserObject.getEmail());
        userDao.save(user);
    }
}
