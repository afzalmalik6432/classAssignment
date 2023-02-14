package com.example.userManagement.model;
import lombok.Data;

@Data
//@Entity
//@Table(name = "UserTable")
public class User {
    private Integer userId;
    private String Name;
    private String userName;
    private String address;
    private String phoneNumber;
}
