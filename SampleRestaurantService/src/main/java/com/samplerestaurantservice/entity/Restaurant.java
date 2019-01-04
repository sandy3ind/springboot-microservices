package com.samplerestaurantservice.entity;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

public class Restaurant {

	private long id;
	private String name;	
	private String description;
	private DateTime createdDate;
	private float rating;
	private float priceForTwo;
	private String address;
	private double latitude;
	private double longitude;
	
	
	private List<Cuisine> cuisines;
	
	
	
}
