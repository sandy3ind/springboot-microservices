package com.samplerestaurantservice.rsclient;

import java.util.HashMap;
import java.util.Map;

public class FcmData {

	private String token;	
	private Map<String, String> notification = new HashMap<>();	
	private Map<String, String> data = new HashMap<>();
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Map<String, String> getNotification() {
		return notification;
	}
	public void setNotification(Map<String, String> notification) {
		this.notification = notification;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
}
