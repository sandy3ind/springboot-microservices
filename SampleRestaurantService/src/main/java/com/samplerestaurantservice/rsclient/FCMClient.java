package com.samplerestaurantservice.rsclient;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.samplerestaurantservice.util.HeaderRequestInterceptor;

@Component
public class FCMClient {

	@Value("${FCM.service.url}")
	private String fcmServiceUrl;

	@Autowired
	private RestTemplate restTemplate;

	public void testClient() {
		try {
			JSONObject body = new JSONObject();
			body.put("token", "fdfdfdfrer");

			JSONObject notification = new JSONObject();
			notification.put("title", "Hello");
			notification.put("body", "First Notification");

			JSONObject data = new JSONObject();
			data.put("orderId", "123");
			
			body.put("notification", notification);
			body.put("data", data);
			
			// Send request
			HttpEntity<String> request = new HttpEntity<>(body.toString());	
			
			List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();			
			interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
			restTemplate.setInterceptors(interceptors);
			
			String fcmResponse = restTemplate.postForObject(fcmServiceUrl, request, String.class);	
			System.out.println(fcmResponse);

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

}
