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
@Table(name="option_types")
public class OptionType {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="option_type_id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany
	private
	List<Option> options;
	
	// Constructors
	public OptionType() {}
	public OptionType(long id) {
		this.id = id;
	}
	
	// Copy Constructor
	public OptionType(OptionType optionType) {
		this(optionType.getId());
		this.name = optionType.getName();
		
		if (optionType.getOptions() != null && !optionType.getOptions().isEmpty()) {
			this.options = optionType.getOptions().stream()
					.map(op -> {
						return new Option(op);
					}).collect(Collectors.toList());
		}
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

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}	
}
