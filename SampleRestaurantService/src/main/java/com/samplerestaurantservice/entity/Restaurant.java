package com.samplerestaurantservice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="restaurants")
public class Restaurant {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_id")
	private long id;
	
	@NotNull(message="Name must not be empty")
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="rating")
	private float rating;
	
	@Column(name="price_for_two")
	private float priceForTwo;
	
	@NotNull(message="Address must not be empty")
	@Column(name="address")
	private String address;
		
	@Column(name="latitude")
	private double latitude;	
	
	@Column(name="longitude")
	private double longitude;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "restaurants_cuisines", 
        joinColumns = { @JoinColumn(name = "restaurant_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "cuisine_id") }
    )
	private List<Cuisine> cuisines;
	
	
	// Constructors
	public Restaurant() {}
	
	public Restaurant(long id) {
		this.id = id;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getPriceForTwo() {
		return priceForTwo;
	}

	public void setPriceForTwo(float priceForTwo) {
		this.priceForTwo = priceForTwo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public List<Cuisine> getCuisines() {
		return cuisines;
	}

	public void setCuisines(List<Cuisine> cuisines) {
		this.cuisines = cuisines;
	}
	
}
