package com.samplerestaurantservice.rsclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "fcm-service")
public interface FCMClient {

	@PostMapping
	String sendOrderStatus(FcmData fcmData);
	
}
