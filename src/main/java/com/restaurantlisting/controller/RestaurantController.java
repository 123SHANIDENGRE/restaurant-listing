package com.restaurantlisting.controller;

import com.restaurantlisting.dto.RestaurantDTO;
import com.restaurantlisting.service.RestaurantService;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/fetchAllRestaurant")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurant()
    {
        List<RestaurantDTO> allRestaurant=restaurantService.findAllRestaurant();
        return new ResponseEntity<>(allRestaurant, HttpStatusCode.valueOf(HttpStatus.SC_OK));
    }


    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO restaurantAdded = restaurantService.addRestaurantInDB(restaurantDTO);
        return new ResponseEntity<>(restaurantAdded, HttpStatusCode.valueOf(HttpStatus.SC_CREATED));
    }

    @GetMapping("fetchById/{id}")
    public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Integer id) {
        return restaurantService.fetchRestaurantById(id);
    }

}
