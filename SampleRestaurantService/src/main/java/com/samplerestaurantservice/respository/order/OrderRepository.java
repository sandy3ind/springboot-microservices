package com.samplerestaurantservice.respository.order;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.Restaurant;
import com.samplerestaurantservice.entity.order.Order;
import com.samplerestaurantservice.entity.user.User;
import com.samplerestaurantservice.util.Constant.OrderStatus;

public interface OrderRepository extends CrudRepository<Order, Long> {

	Order findByUserAndRestaurantAndStatus(User user, Restaurant restaurant, OrderStatus status);

}
