package com.samplerestaurantservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurant_foods")
public class RestaurantFood {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_food_id")
	private long id;	
	
	@Column(name="name")
	private String name;
	
	@OneToOne
	@JoinColumn(name="restaurant_category_id")
	private RestaurantCategory restaurantCategory;
	
	@OneToOne
	@JoinColumn(name="restaurant_menu_id")
	private RestaurantMenu restaurantMenu;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RestaurantCategory getRestaurantCategory() {
		return restaurantCategory;
	}

	public void setRestaurantCategory(RestaurantCategory restaurantCategory) {
		this.restaurantCategory = restaurantCategory;
	}

	public RestaurantMenu getRestaurantMenu() {
		return restaurantMenu;
	}

	public void setRestaurantMenu(RestaurantMenu restaurantMenu) {
		this.restaurantMenu = restaurantMenu;
	}
}
