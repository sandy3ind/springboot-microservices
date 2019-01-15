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
@Table(name="choices")
public class Choice {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="choice_id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="choice")
	private List<ChoiceItem> choiceItems;
	
	// Constructors
	public Choice() {}
	public Choice(long id) {	
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

	public List<ChoiceItem> getChoiceItems() {
		return choiceItems;
	}

	public void setChoiceItems(List<ChoiceItem> choiceItems) {
		this.choiceItems = choiceItems;
	}
}
