package com.example.restaurantManagement.services;

import com.example.restaurantManagement.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    private static final List<Restaurant> restaurantList=new ArrayList<>();

    public void addRestaurant(Restaurant restaurant){
        restaurantList.add(restaurant);
    }
    public List<Restaurant> getAllRestaurant(){
        return restaurantList;
    }
    public Restaurant findByName(String name) {
        Restaurant resultantRestaurant = null;
        for(int i=0; i<restaurantList.size(); i++){
            Restaurant restaurant = restaurantList.get(i);
            if(restaurant.getRestaurantName().equals(name)) resultantRestaurant=restaurant;
        }
        return resultantRestaurant;
    }
}
