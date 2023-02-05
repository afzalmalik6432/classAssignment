package com.example.restaurantManagement.model;

public class Restaurant {
    private String restaurantName;
    private String getRestaurantAddress;
    private String totalStaff;
    private String number;

    public Restaurant() {
    }

    public Restaurant(String restaurantName, String getRestaurantAddress, String totalStaff, String number) {
        this.restaurantName = restaurantName;
        this.getRestaurantAddress = getRestaurantAddress;
        this.totalStaff = totalStaff;
        this.number = number;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getGetRestaurantAddress() {
        return getRestaurantAddress;
    }

    public void setGetRestaurantAddress(String getRestaurantAddress) {
        this.getRestaurantAddress = getRestaurantAddress;
    }

    public String getTotalStaff() {
        return totalStaff;
    }

    public void setTotalStaff(String totalStaff) {
        this.totalStaff = totalStaff;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantName='" + restaurantName + '\'' +
                ", getRestaurantAddress='" + getRestaurantAddress + '\'' +
                ", totalStaff='" + totalStaff + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
