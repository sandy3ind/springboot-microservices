package com.sampleuserservice.util;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonValue;

public class Constant {

	public enum ErrorType {
		VALIDATION, NON_UNIQUE
	}
	
	public enum RoleType {
		CUSTOMER, RESTAURANT, DELIVERY_AGENT, DEVILERY_AGENCY;
		
		/*
		private String value;
		
		private RoleType(String value) {
			this.value = value;
		}
		
		@JsonValue
	    public String getValue() {
	        return value;
	    }
		
		public static RoleType fromValue(String value) {
			for (RoleType name : values()) {
				if (name.value.equalsIgnoreCase(value)) {
					return name;
				}
			}
			throw new IllegalArgumentException(
					"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
		}*/
	}
	
}
