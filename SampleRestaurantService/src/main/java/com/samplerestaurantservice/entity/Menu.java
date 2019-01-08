package com.samplerestaurantservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menus")
public class Menu {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="menu_id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	// Constructors
	public Menu() {}
	
	public Menu(long id) {
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
}
