package com.samplerestaurantservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurant_food_options")
public class RestaurantFoodOption {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_food_option_id")
	private long id;
	
	@Column(name="price")
	private float price;
	
	@Column(name="discount")
	private float discount;
	
	
	@ManyToOne
	@JoinColumn(name="restaurant_food_id")	
	private RestaurantFood restaurantFood;
	
	@OneToOne
	@JoinColumn(name="restaurant_option_id")	
	private RestaurantOption restaurantOption;

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

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public RestaurantFood getRestaurantFood() {
		return restaurantFood;
	}

	public void setRestaurantFood(RestaurantFood restaurantFood) {
		this.restaurantFood = restaurantFood;
	}

	public RestaurantOption getRestaurantOption() {
		return restaurantOption;
	}

	public void setRestaurantOption(RestaurantOption restaurantOption) {
		this.restaurantOption = restaurantOption;
	}
}
