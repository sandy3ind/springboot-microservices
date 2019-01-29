package com.samplerestaurantservice.rs.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samplerestaurantservice.entity.cart.Cart;
import com.samplerestaurantservice.entity.cart.CartFood;
import com.samplerestaurantservice.entity.order.Order;
import com.samplerestaurantservice.entity.order.OrderFood;
import com.samplerestaurantservice.entity.order.OrderRejectionReason;
import com.samplerestaurantservice.respository.cart.CartRepository;
import com.samplerestaurantservice.respository.order.OrderFoodRepository;
import com.samplerestaurantservice.respository.order.OrderRejectionReasonRepository;
import com.samplerestaurantservice.respository.order.OrderRepository;
import com.samplerestaurantservice.rsclient.FCMClient;
import com.samplerestaurantservice.rsclient.FcmData;
import com.samplerestaurantservice.util.Constant.OrderStatus;

@RestController
@RequestMapping("/order")
public class OrderService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderFoodRepository orderFoodRepository;
	
	@Autowired
	private OrderRejectionReasonRepository orderRejectionReasonRepository;
	
	@Autowired
	private FCMClient fcmClient;
	

	/**
	 * Place Order from Cart
	 * 
	 * @return
	 */
	@PostMapping("/cart/{cartId}")
	@Transactional
	public ResponseEntity<?> save(@PathVariable("cartId") long cartId) {

		// Get Cart detail from database;
		Optional<Cart> cartOptional = cartRepository.findById(cartId);

		// If cart detail not found then return with error
		if (!cartOptional.isPresent()) {
			return ResponseEntity.badRequest().body("Cart not found");
		}
		Cart cart = cartOptional.get();
		final Order order = new Order();
		;

		// Check if Order already exists in DB, then update only data
		Order orderDb = orderRepository.findByUserAndRestaurantAndStatus(cart.getUser(), cart.getRestaurant(),
				OrderStatus.NEW);
		if (orderDb != null) {
			order.setId(orderDb.getId());
			// delete all the existing OrderFoods
			deleteOrderFoods(orderDb.getOrderFoods());
		}
		else {
			// TODO - Generate Ref no
			order.setRef("ewew33223ewe");
		}

		// Copy Order detail from Cart
		order.buildOrderFromCart(cart);

		// Copy all the CartFood to OrderFood
		List<CartFood> cartFoods = cart.getCartFoods();
		if (cartFoods != null && !cartFoods.isEmpty()) {
			List<OrderFood> orderFoods = new ArrayList<>(cartFoods.size());
			cartFoods.forEach(cartFood -> {
				OrderFood orderFood = new OrderFood();
				orderFood = orderFood.buildOrderFoodFromCartFood(cartFood);
				orderFood.setOrder(order);
				orderFoods.add(orderFood);
			});
			order.setOrderFoods(orderFoods);
		}
		order.setStatus(OrderStatus.NEW);
		orderRepository.save(order);

		return ResponseEntity.ok().build();
	}

	/**
	 * Update status of Order - in case of Rejection, also enter Reason
	 * 
	 * @param orderId
	 * @param status
	 * @param rejectionId
	 * @return
	 */
	@PostMapping("/{orderId}/update-status/{status}")
	@Transactional
	public ResponseEntity<?> updateStatus(
			@PathVariable("orderId") long orderId, 
			@PathVariable("status") String status,
			@RequestParam(name = "rejectionId", required = false) Long rejectionId) {

		Optional<Order> orderOptional = orderRepository.findById(orderId);

		if (orderOptional == null || !orderOptional.isPresent()) {
			return ResponseEntity.badRequest().body("Order not found");
		}

		Order order = orderOptional.get();
		OrderStatus statusForUpdate = OrderStatus.valueOf(status);
		// Check if status is for Rejection - then also get reason
		if (statusForUpdate.equals(OrderStatus.REJECTED)) {
			if (rejectionId == null) {
				return ResponseEntity.badRequest().body("Rejection Reason not provided");
			}
			OrderRejectionReason orderRejectionReason = new OrderRejectionReason(rejectionId);
			orderRejectionReasonRepository.save(orderRejectionReason);
			order.setOrderRejectionReason(orderRejectionReason);
		}

		order.setStatus(OrderStatus.valueOf(status));

		orderRepository.save(order);

		// TODO - Send order status notification to Customer
		FcmData fcmData = new FcmData();
		fcmData.setToken("dfdfd");
		fcmData.getNotification().put("title", "dsdsdsd");
		fcmData.getData().put("title", "data title");
		fcmClient.sendOrderStatus(fcmData);
		
		
		return ResponseEntity.ok().build();
	}

	/**
	 * Delete all the OrderFoods of Order
	 * 
	 * @param orderFoods
	 */
	private void deleteOrderFoods(List<OrderFood> orderFoods) {
		if (orderFoods != null && !orderFoods.isEmpty()) {
			orderFoods.forEach(orderFood -> {
				orderFood.setRestaurantFoodAddOnItems(null);
				orderFoodRepository.delete(orderFood);
			});
		}
	}

}
