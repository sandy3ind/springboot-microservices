package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.Restaurant;
import com.samplerestaurantservice.entity.RestaurantAddress;

public interface RestaurantAddressRepository extends CrudRepository<RestaurantAddress, Long> {

	RestaurantAddress findByRestaurant(Restaurant restaurant);


}
