package com.samplerestaurantservice.rs.cart;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.samplerestaurantservice.entity.cart.Cart;
import com.samplerestaurantservice.entity.user.User;

@Component
public class CartCache {

	@Cacheable(value = "carts", key = "#userId")
	public Cart getCart(long userId) {
		Cart cart = new Cart();	
		cart.setUser(new User(userId));
		return cart;
	}
	
}
