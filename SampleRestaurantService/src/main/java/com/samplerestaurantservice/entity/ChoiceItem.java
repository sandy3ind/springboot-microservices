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
@Table(name="choice_items")
public class ChoiceItem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="choice_item_id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="choice_id")
	private Choice choice;

	// Constructors
	public ChoiceItem() {}
	public ChoiceItem(long id) {		
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Choice getChoice() {
		return choice;
	}
	public void setChoice(Choice choice) {
		this.choice = choice;
	}
}
