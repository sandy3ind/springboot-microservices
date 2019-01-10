package com.samplerestaurantservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="restaurant_offers")
public class RestaurantOffer {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_offer_id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="offer_type_id")
	private OfferType offerType;
	
	@Column(name="percentage")
	private float percentage;
	
	@Column(name="above_price")
	private float abovePrice;
	
	@Column(name="is_valid")
	private boolean isValid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expired_date")
	private Date expiredDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OfferType getOfferType() {
		return offerType;
	}

	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public float getAbovePrice() {
		return abovePrice;
	}

	public void setAbovePrice(float abovePrice) {
		this.abovePrice = abovePrice;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
	
}
