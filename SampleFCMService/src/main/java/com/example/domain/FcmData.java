package com.example.domain;

import java.util.Map;

public class FcmData {

	private String token;	
	private Map<String, String> notification;	
	private Map<String, String> data;
	
	
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
