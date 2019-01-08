package com.samplerestaurantservice.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.Restaurant;
import com.samplerestaurantservice.entity.RestaurantMenu;

public interface RestaurantMenuRepository extends CrudRepository<RestaurantMenu, Long> {

	List<RestaurantMenu> findByRestaurant(Restaurant restaurant);

}
