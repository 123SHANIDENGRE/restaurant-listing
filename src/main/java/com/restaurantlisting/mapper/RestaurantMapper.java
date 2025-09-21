package com.restaurantlisting.mapper;

import com.restaurantlisting.dto.RestaurantDTO;
import com.restaurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE= Mappers.getMapper(RestaurantMapper.class);


    Restaurant mapRestaurantDTOtoRestaurant(RestaurantDTO restaurantDTO);
    RestaurantDTO mapRestauranttoRestaurantDTO(Restaurant restaurant);

}
