package com.example.userManagement.controller;

import com.example.userManagement.model.User;
import com.example.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "addUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping(value = "/getUsers")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "getUser/{userid}")
    public User getUser(@PathVariable Integer userid){
        return userService.getUser(userid);
    }

    @PutMapping(value = "/updateUser")
    public void updateUser(@RequestParam Integer userId, @RequestBody User user){
        userService.updateUser(userId, user);
    }

    @DeleteMapping(value = "/deleteUser")
    public void deleteUser(@RequestParam Integer userId){
        userService.deleteUser(userId);
    }
}
