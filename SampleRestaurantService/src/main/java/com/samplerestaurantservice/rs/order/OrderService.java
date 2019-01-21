package com.samplerestaurantservice.rs.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samplerestaurantservice.entity.cart.Cart;
import com.samplerestaurantservice.entity.cart.CartFood;
import com.samplerestaurantservice.entity.order.Order;
import com.samplerestaurantservice.entity.order.OrderFood;
import com.samplerestaurantservice.respository.cart.CartRepository;
import com.samplerestaurantservice.respository.order.OrderRepository;
import com.samplerestaurantservice.util.Constant.OrderStatus;

@RestController
@RequestMapping("/order")
public class OrderService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	/**
	 * Place Order from Cart
	 * 
	 * @return
	 */
	@PostMapping("/cart/{cartId}")
	public ResponseEntity<?> save(
			@PathVariable("cartId") long cartId) {
		
		// Get Cart detail from database;
		Optional<Cart> cartOptional = cartRepository.findById(cartId);
		
		// If cart detail not found then return with error
		if (!cartOptional.isPresent()) {
			return ResponseEntity.badRequest().body("Cart not found");
		}
		Cart cart = cartOptional.get();
		Order order = new Order();;
		
		// Check if Order already exists in DB, then update only data
		Order orderDb = orderRepository.findByUserAndRestaurantAndStatus(cart.getUser(), cart.getRestaurant(), OrderStatus.NEW);
		if (orderDb != null) {
			order.setId(orderDb.getId());
		}			
		
		// Copy Order detail from Cart
		order = order.buildOrderFromCart(cart);
		
		// TODO - delete all the existing OrderFoods
		
		// Copy all the CartFood to OrderFood
		List<CartFood> cartFoods = cart.getCartFoods();
		if (cartFoods != null && !cartFoods.isEmpty()) {
			List<OrderFood> orderFoods = new ArrayList<>(cartFoods.size()); 
			cartFoods.forEach(cartFood -> {
				OrderFood orderFood = new OrderFood();
				orderFood = orderFood.buildOrderFoodFromCartFood(cartFood);
				orderFoods.add(orderFood);
			});
			order.setOrderFoods(orderFoods);
		}
		order.setStatus(OrderStatus.NEW);
		orderRepository.save(order);
		
		return ResponseEntity.ok().build();
	}
}
