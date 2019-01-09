package com.samplerestaurantservice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="option_types")
public class OptionType {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="option_type_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany
	private
	List<Option> options;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}	
}
