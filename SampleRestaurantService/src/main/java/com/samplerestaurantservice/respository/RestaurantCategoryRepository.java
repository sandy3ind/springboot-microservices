package com.samplerestaurantservice.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.RestaurantCategory;
import com.samplerestaurantservice.entity.RestaurantMenu;

public interface RestaurantCategoryRepository extends CrudRepository<RestaurantCategory, Long> {

	List<RestaurantCategory> findByRestaurantMenu(RestaurantMenu restaurantMenu);


}
