package com.samplerestaurantservice.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.RestaurantCategory;
import com.samplerestaurantservice.entity.RestaurantFood;
import com.samplerestaurantservice.entity.RestaurantMenu;

public interface RestaurantFoodRepository extends CrudRepository<RestaurantFood, Long> {

	List<RestaurantFood> findByRestaurantMenu(RestaurantMenu restaurantMenu);

	List<RestaurantFood> findByRestaurantCategory(RestaurantCategory restaurantCategory);

}
