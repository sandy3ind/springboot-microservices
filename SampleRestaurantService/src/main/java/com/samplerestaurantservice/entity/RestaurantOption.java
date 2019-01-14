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
@Table(name="restaurant_options")
public class RestaurantOption {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_option_id")
	private long id;	
	
	@OneToOne
	@JoinColumn(name="option_id")
	private Option option;
	
	@OneToOne
	@JoinColumn(name="restaurant_option_type_id")
	private RestaurantOptionType restaurantOptionType;
	
	// Constructors
	public RestaurantOption() {}
	public RestaurantOption(long id) {		
		this.id = id;
	}
	
	// Copy Constructor
	public RestaurantOption(RestaurantOption restaurantOption) {
		this(restaurantOption.getId());		
		this.option = new Option(restaurantOption.getOption());
		this.restaurantOptionType = new RestaurantOptionType(restaurantOption.getRestaurantOptionType());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public RestaurantOptionType getRestaurantOptionType() {
		return restaurantOptionType;
	}

	public void setRestaurantOptionType(RestaurantOptionType restaurantOptionType) {
		this.restaurantOptionType = restaurantOptionType;
	}
}
