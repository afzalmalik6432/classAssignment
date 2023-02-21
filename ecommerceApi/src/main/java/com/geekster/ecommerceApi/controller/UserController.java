package com.geekster.ecommerceApi.controller;

import com.geekster.ecommerceApi.model.User;
import com.geekster.ecommerceApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/adduser")
    public ResponseEntity<String> addUser(@RequestBody User user){
        int userId = userService.addUser(user);
        return new ResponseEntity<>("User registered successfully with id "+userId, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getuserbyid")
    public ResponseEntity<User> getUser(@RequestParam Integer id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }
}
