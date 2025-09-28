package com.restaurantlisting.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


public class RestaurantDTO {
    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;

    public RestaurantDTO(int id, String name, String address, String city, String restaurantDescription) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.restaurantDescription = restaurantDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRestaurantDescription() {
        return restaurantDescription;
    }

    public void setRestaurantDescription(String restaurantDescription) {
        this.restaurantDescription = restaurantDescription;
    }

    public RestaurantDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RestaurantDTO that)) return false;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(restaurantDescription, that.restaurantDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, city, restaurantDescription);
    }
}
