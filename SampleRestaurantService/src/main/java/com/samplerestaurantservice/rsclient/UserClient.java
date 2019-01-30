package com.samplerestaurantservice.rsclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

	@GetMapping("{userId}/fcm-token")
	String getFcmToken(@PathVariable("userId") Long userId);
	
}
