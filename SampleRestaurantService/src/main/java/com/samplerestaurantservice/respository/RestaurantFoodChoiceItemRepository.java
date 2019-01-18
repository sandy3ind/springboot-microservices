package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.RestaurantFoodAddOnItem;
import com.samplerestaurantservice.entity.RestaurantFoodChoiceItem;

public interface RestaurantFoodChoiceItemRepository extends CrudRepository<RestaurantFoodChoiceItem, Long> {

	

}
