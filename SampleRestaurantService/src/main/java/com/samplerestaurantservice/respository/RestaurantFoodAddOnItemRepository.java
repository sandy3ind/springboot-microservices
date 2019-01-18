package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.RestaurantFoodAddOnItem;

public interface RestaurantFoodAddOnItemRepository extends CrudRepository<RestaurantFoodAddOnItem, Long> {

	

}
