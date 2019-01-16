package com.samplerestaurantservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurant_food_add_on_items")
public class RestaurantFoodAddOnItem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_food_add_on_item_id")
	private long id;
	
	@Column(name="price")
	private float price;
	
	@ManyToOne
	@JoinColumn(name="restaurant_food_id")
	private RestaurantFood restaurantFood;
	
	@ManyToOne
	@JoinColumn(name="restaurant_add_on_item_id")
	private RestaurantAddOnItem restaurantAddOnItem;

	// Constructors
	public RestaurantFoodAddOnItem() {}
	public RestaurantFoodAddOnItem(long id) {
		this.id = id;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public RestaurantFood getRestaurantFood() {
		return restaurantFood;
	}
	public void setRestaurantFood(RestaurantFood restaurantFood) {
		this.restaurantFood = restaurantFood;
	}
	public RestaurantAddOnItem getRestaurantAddOnItem() {
		return restaurantAddOnItem;
	}
	public void setRestaurantAddOnItem(RestaurantAddOnItem restaurantAddOnItem) {
		this.restaurantAddOnItem = restaurantAddOnItem;
	}
}
