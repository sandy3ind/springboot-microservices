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
@Table(name="restaurant_option_types")
public class RestaurantOptionType {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_option_type_id")
	private int id;	
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
	
	@OneToOne
	@JoinColumn(name="option_type_id")
	private OptionType optionType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public OptionType getOptionType() {
		return optionType;
	}

	public void setOptionType(OptionType optionType) {
		this.optionType = optionType;
	}
}
