package com.example.userManagement.service;

import com.example.userManagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    static List<User> userList = new ArrayList<>();

    public void addUser(User user){
        userList.add(user);
    }

    public List<User> getAllUsers(){
        return userList.stream().toList();
    }

    public User getUser(Integer userid) {
        for(User user : userList){
            if ( userid.equals(user.getUserId()))
                return user;
        }
        return null;
    }

    public void updateUser(Integer userId, User user) {
        for(User userInList : userList){
            if ( userId.equals(userInList.getUserId())){
                userInList.setUserName(user.getUserName());
                userInList.setAddress(user.getAddress());
                userInList.setUserName(user.getUserName());
                userInList.setPhoneNumber(user.getPhoneNumber());
            }
        }
    }

    public void deleteUser(Integer userId) {
        User userToRemove = null;
        for(User userInList : userList) {
            if (userId.equals(userInList.getUserId())) {
                userToRemove = userInList;
            }
        }
        userList.remove(userToRemove);
    }
}
