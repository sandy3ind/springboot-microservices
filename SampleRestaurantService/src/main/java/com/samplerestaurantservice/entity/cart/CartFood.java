package com.samplerestaurantservice.entity.cart;

import java.util.List;

import com.samplerestaurantservice.entity.RestaurantFood;
import com.samplerestaurantservice.entity.RestaurantFoodAddOnItem;
import com.samplerestaurantservice.entity.RestaurantFoodChoiceItem;
import com.samplerestaurantservice.entity.RestaurantFoodOption;

public class CartFood {
	
	private long id;
	private RestaurantFood restaurantFood;
	private RestaurantFoodOption restaurantFoodOption;
	private List<RestaurantFoodAddOnItem> restaurantFoodAddOnItems;
	private RestaurantFoodChoiceItem restaurantFoodChoiceItem;
	private int quantity;
	private float price;
	private float totalPrice;
	
	private Cart cart;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RestaurantFood getRestaurantFood() {
		return restaurantFood;
	}

	public void setRestaurantFood(RestaurantFood restaurantFood) {
		this.restaurantFood = restaurantFood;
	}

	public RestaurantFoodOption getRestaurantFoodOption() {
		return restaurantFoodOption;
	}

	public void setRestaurantFoodOption(RestaurantFoodOption restaurantFoodOption) {
		this.restaurantFoodOption = restaurantFoodOption;
	}

	public List<RestaurantFoodAddOnItem> getRestaurantFoodAddOnItems() {
		return restaurantFoodAddOnItems;
	}

	public void setRestaurantFoodAddOnItems(List<RestaurantFoodAddOnItem> restaurantFoodAddOnItems) {
		this.restaurantFoodAddOnItems = restaurantFoodAddOnItems;
	}

	public RestaurantFoodChoiceItem getRestaurantFoodChoiceItem() {
		return restaurantFoodChoiceItem;
	}

	public void setRestaurantFoodChoiceItem(RestaurantFoodChoiceItem restaurantFoodChoiceItem) {
		this.restaurantFoodChoiceItem = restaurantFoodChoiceItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
