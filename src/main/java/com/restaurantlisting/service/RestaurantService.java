package com.restaurantlisting.service;

import com.restaurantlisting.dto.RestaurantDTO;
import com.restaurantlisting.entity.Restaurant;
import com.restaurantlisting.mapper.RestaurantMapper;
import com.restaurantlisting.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> findAllRestaurant() {
       List<Restaurant> restaurants=restaurantRepo.findAll();
        //map it to list of DTO
        List<RestaurantDTO>  restaurantsListDTO= restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestauranttoRestaurantDTO(restaurant)).collect(Collectors.toList());
       return restaurantsListDTO;
    }



    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
        Restaurant savedRestaurant =  restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOtoRestaurant(restaurantDTO));
        return RestaurantMapper.INSTANCE.mapRestauranttoRestaurantDTO(savedRestaurant);
    }

    public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer id) {
        Optional<Restaurant> restaurant =  restaurantRepo.findById(id);
        if(restaurant.isPresent()){
            return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestauranttoRestaurantDTO(restaurant.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
