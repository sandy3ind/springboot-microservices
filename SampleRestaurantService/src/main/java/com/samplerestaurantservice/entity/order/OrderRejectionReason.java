package com.samplerestaurantservice.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_rejection_reasons")
public class OrderRejectionReason {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_rejection_reason_id")
	private long id;
	
	@Column(name="reason")
	private String reason;
	
	// Constructors
	public OrderRejectionReason() {
	}
	public OrderRejectionReason(long id) {		
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
