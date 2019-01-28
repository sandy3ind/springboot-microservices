package com.samplerestaurantservice.respository.order;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.Restaurant;
import com.samplerestaurantservice.entity.order.Order;
import com.samplerestaurantservice.entity.order.OrderRejectionReason;
import com.samplerestaurantservice.entity.user.User;
import com.samplerestaurantservice.util.Constant.OrderStatus;

public interface OrderRejectionReasonRepository extends CrudRepository<OrderRejectionReason, Long> {


}
