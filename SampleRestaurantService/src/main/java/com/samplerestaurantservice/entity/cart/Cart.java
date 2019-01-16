package com.samplerestaurantservice.entity.cart;

import java.util.List;

import com.samplerestaurantservice.entity.user.User;

public class Cart {
	
	private User user;
	private List<CartFood> cartFoods;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CartFood> getCartFoods() {
		return cartFoods;
	}
	public void setCartFoods(List<CartFood> cartFoods) {
		this.cartFoods = cartFoods;
	}
}
