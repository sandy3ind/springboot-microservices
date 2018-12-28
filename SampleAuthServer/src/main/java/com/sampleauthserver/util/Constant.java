package com.sampleauthserver.util;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonValue;

public class Constant {

	public enum ErrorType {
		VALIDATION, NON_UNIQUE
	}
	
	public enum RoleType {
		CUSTOMER, RESTAURANT, DELIVERY_AGENT, DEVILERY_AGENCY;		
	}
	
}
