package com.sampleauthserver.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sampleauthserver.domain.User;

@Component
public class UserClient {

	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Get User by phone number
	 * 
	 * @param phone
	 * @return
	 */
	public User getByPhone(String phone) {
		User user = restTemplate.getForObject("http://localhost:8090/phone/abc1111111", User.class);
		return user;
	}
}
