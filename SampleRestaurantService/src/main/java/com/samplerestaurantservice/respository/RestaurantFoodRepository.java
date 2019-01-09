package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.RestaurantFood;

public interface RestaurantFoodRepository extends CrudRepository<RestaurantFood, Long> {

}
