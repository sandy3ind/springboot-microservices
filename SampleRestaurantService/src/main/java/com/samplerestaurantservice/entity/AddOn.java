package com.samplerestaurantservice.entity;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="add_ons")
public class AddOn {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="add_on_id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="addOn")
	private List<AddOnItem> addOnItems;
	
	// Constructor
	public AddOn() {}
	public AddOn(long id) {
		this.id = id;
	}
	
	// Copy Constructor
	/*public AddOn(AddOn addOn) {
		this(addOn.getId());
		this.name = addOn.getName();
		if (addOn.getAddOnItems() != null && addOn.getAddOnItems().isEmpty()) {
			this.addOnItems = addOn.getAddOnItems().stream()
					.map(aoi -> {
						return new AddOnItem(aoi);
					}).collect(Collectors.toList());
		}
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

	public List<AddOnItem> getAddOnItems() {
		return addOnItems;
	}

	public void setAddOnItems(List<AddOnItem> addOnItems) {
		this.addOnItems = addOnItems;
	}
}
