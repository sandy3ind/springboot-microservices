package com.samplerestaurantservice.entity;

import java.util.Date;

public class RestaurantOffer {

	private long id;
	private OfferType type;
	private float percentage;
	private float abovePrice;
	private boolean isValid;
	private Date createdDate;
	private Date expiredDate;
}
