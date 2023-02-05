package com.example.restaurantManagement.controller;

import com.example.restaurantManagement.model.Restaurant;
import com.example.restaurantManagement.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant-app")
public class RestaurantController {

    @Autowired
    public RestaurantService restaurantService;

    //    http://localhost:8080/api/v1/restaurant-app/add-restaurant
    @PostMapping("add-restaurant")
    public String addRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.addRestaurant(restaurant);
        return "Restaurant Added";
    }
    //    http://localhost:8080/api/v1/restaurant-app/all-restaurant
    @GetMapping("all-restaurant")
    public List<Restaurant> listAllRestaurant(){
        return restaurantService.getAllRestaurant();
    }
    //    http://localhost:8080/api/v1/restaurant-app/name/Punjabi-Tadka
    @GetMapping("/name/{name}")
    public Restaurant findByName(@PathVariable String name){
        return restaurantService.findByName(name);
    }
}
