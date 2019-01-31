package com.sampleauthserver.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sampleauthserver.domain.User;

@FeignClient(name = "user-service")
public interface UserClient {

	@GetMapping("{userId}/fcm-token")
	String getFcmToken(@PathVariable("userId") Long userId);
	
	@GetMapping("/phone/{phone}")
	User getUserByPhone(@PathVariable("phone") String phone);
	
}
