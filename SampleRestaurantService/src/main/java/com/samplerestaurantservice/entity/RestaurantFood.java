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
	private RestaurantCategory category;
	
	@OneToOne
	@JoinColumn(name="restaurant_menu_id")
	private RestaurantMenu menu;

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

	public RestaurantCategory getCategory() {
		return category;
	}

	public void setCategory(RestaurantCategory category) {
		this.category = category;
	}

	public RestaurantMenu getMenu() {
		return menu;
	}

	public void setMenu(RestaurantMenu menu) {
		this.menu = menu;
	}	
}
