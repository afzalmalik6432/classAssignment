package com.example.validationUserManagement.controller;

import com.example.validationUserManagement.model.User;
import com.example.validationUserManagement.service.UserService;
import com.example.validationUserManagement.utility.UserValidator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user/")
public class UserController {

    List<String> list ;

    @Autowired
    UserService userService;

    @PostMapping(value = "adduser")
    public ResponseEntity<String> addUser(@RequestBody String user){
        JSONObject userObject = new JSONObject(user);
        User finalUserObject = setUser(userObject);
        if (list.isEmpty()){
            userService.addUser(finalUserObject);
            return new ResponseEntity<String>("User saved",HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Please provide valid "+list.toString(),HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/getUser/{userid}")
    public ResponseEntity<User> getUserById(@PathVariable int userid){
        User user = userService.getUser(userid);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping(value = "/getAllUser")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted with id - "+userId,HttpStatus.OK);
    }

    @PutMapping(value = "/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody String user, @RequestParam Integer userId){
        JSONObject userObject = new JSONObject(user);
        User finalUserObject = setUser(userObject);
        if (list.isEmpty()){
            userService.updateUser(finalUserObject,userId);
            return new ResponseEntity<String>("User Updated Successfully",HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Please provide valid "+list.toString(),HttpStatus.BAD_REQUEST);
    }

    public User  setUser(JSONObject userObject){
        list = new ArrayList<>();
        User finalUser = new User();
        if(userObject.has("userName")){
            String userName = userObject.getString("userName");
            if(UserValidator.validateName(userName)) finalUser.setUserName(userName);
            else list.add("userName");
        }
        else list.add("userName");
        if(userObject.has("dateOfBirth")){
             String dateOfBirth = userObject.getString("dateOfBirth");
             if(UserValidator.validateDateOfBirth(dateOfBirth)) finalUser.setDateOfBirth(dateOfBirth);
             else list.add("dateOfBirth");
        }
        else list.add("dateOfBirth");
        if(userObject.has("email")){
             String email = userObject.getString("email");
             if(UserValidator.validateEmail(email)) finalUser.setEmail(email);
                 else list.add("email");
        }
        else list.add("email");
        if(userObject.has("phoneNumber")){
             String phoneNumber = userObject.getString("phoneNumber");
             if(UserValidator.validatePhoneNumber(phoneNumber)) finalUser.setNumber(phoneNumber);
             else list.add("phoneNumber");
         }
        else list.add("phoneNumber");
        if(userObject.has("date")) finalUser.setDate(userObject.getString("date"));
        else finalUser.setDate("yyyy-mm-dd");
        if(userObject.has("time")) finalUser.setTime(userObject.getString("time"));
        else finalUser.setTime("hh:mm:ss");
        return finalUser;
    }
}
