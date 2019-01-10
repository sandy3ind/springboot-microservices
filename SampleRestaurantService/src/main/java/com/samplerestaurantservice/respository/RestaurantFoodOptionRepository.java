package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.RestaurantFood;
import com.samplerestaurantservice.entity.RestaurantFoodOption;

public interface RestaurantFoodOptionRepository extends CrudRepository<RestaurantFoodOption, Long> {

}
