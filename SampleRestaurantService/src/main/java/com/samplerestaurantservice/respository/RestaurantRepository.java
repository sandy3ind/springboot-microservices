package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}
