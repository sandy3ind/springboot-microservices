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
@Table(name="restaurant_menus")
public class RestaurantMenu {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_menu_id")
	private long id;
	
	@OneToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
	
	@OneToOne
	@JoinColumn(name="menu_id")
	private Menu menu;
	
	public RestaurantMenu() {}
	
	public RestaurantMenu(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
