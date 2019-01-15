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
@Table(name="add_on_items")
public class AddOnItem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="add_on_item_id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="add_on_id")
	private AddOn addOn;

	// Constructor
	public AddOnItem() {}
	public AddOnItem(long id) {		
		this.id = id;
	}
	
	// Copy Constructor
	/*public AddOnItem(AddOnItem addOnItem) {
		this(addOnItem.getId());
		this.name = addOnItem.getName();		
	}*/
	
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
	public AddOn getAddOn() {
		return addOn;
	}
	public void setAddOn(AddOn addOn) {
		this.addOn = addOn;
	}
}
