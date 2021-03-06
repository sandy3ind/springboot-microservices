package com.samplerestaurantservice.util;

public class Constant {
	
	public enum ErrorType {
		VALIDATION, NON_UNIQUE
	}
	
	public enum UpdateQuantityType {
		PLUS, MINUS
	}
	
	public enum OrderStatus {
		NEW, ACCEPTED, REJECTED, PREPARING, ON_WAY, DELIVERED
	}
	
	public enum AddressType {
		HOME, OFFICE, OTHER
	}
}
