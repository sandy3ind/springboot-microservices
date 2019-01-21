package com.samplerestaurantservice.respository.order;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.order.OrderFood;

public interface OrderFoodRepository extends CrudRepository<OrderFood, Long> {

	
}
