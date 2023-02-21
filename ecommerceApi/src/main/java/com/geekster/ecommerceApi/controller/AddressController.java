package com.geekster.ecommerceApi.controller;

import com.geekster.ecommerceApi.model.Address;
import com.geekster.ecommerceApi.service.AddressService;
import com.geekster.ecommerceApi.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @Autowired
    UserService userService;

    @PostMapping(value = "/addaddress")
    public ResponseEntity<String> addAddress(@RequestBody String requestAddress){
        Address address = setAddress(requestAddress);
        addressService.addAddress(address);
        return new ResponseEntity<>("Address is added successfully", HttpStatus.CREATED);
    }

    private Address setAddress(String requestAddress) {
        Address address = new Address();
        JSONObject jsonObject = new JSONObject(requestAddress);
        address.setAddressName(jsonObject.getString("addressName"));
        address.setLandmark(jsonObject.getString("landmark"));
        address.setPhoneNumber(jsonObject.getString("phoneNumber"));
        address.setZipCode(jsonObject.getString("zipCode"));
        address.setState(jsonObject.getString("state"));
        Integer userId = jsonObject.getInt("userId");
        address.setUsedId(userService.getUserById(userId));
        return address;
    }
}
