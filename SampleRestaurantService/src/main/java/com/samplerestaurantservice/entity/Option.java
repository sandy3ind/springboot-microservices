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
@Table(name="options")
public class Option {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="option_id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="option_type")
	private OptionType optionType;
	
	// Constructors
	public Option() {}
	public Option(long id) {
		this.id = id;
	}
	
	// Copy Constructors
	public Option(Option option) {
		this(option.getId());
		this.name = option.getName();
		this.optionType = new OptionType(option.getOptionType());
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

	public OptionType getOptionType() {
		return optionType;
	}

	public void setOptionType(OptionType optionType) {
		this.optionType = optionType;
	}
}
