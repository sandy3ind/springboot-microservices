package com.example.rs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.domain.FcmData;
import com.example.utility.HeaderRequestInterceptor;


@RestController
public class PushService {

	@Value("${FCM.url}")
	private String fcmUrl;

	@Value("${FCM.server.key}")
	private String fcmServerKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Push notification Android device
	 * 
	 * @param fcmData
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> push(
			@RequestBody FcmData fcmData) {
		
		if (fcmData == null) {
			return ResponseEntity.badRequest().body("Incorrect Data");
		}
		
		if (fcmData.getToken() == null) {
			return ResponseEntity.badRequest().body("FCM token not found");
		}		
		
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + fcmServerKey));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
		restTemplate.setInterceptors(interceptors);
			
			try {
				JSONObject body = new JSONObject();
				body.put("to", fcmData.getToken());
				body.put("priority", "high");
				
				// Notification
				Map<String, String> notificationMap = fcmData.getNotification();				
				JSONObject notification = new JSONObject();
				notification.put("title", notificationMap.get("title"));
				notification.put("body", notificationMap.get("body"));				
				notification.put("sound", "default");
				notification.put("icon", "fcm_push_icon");
				
				// Data
				Map<String, String> dataMap = fcmData.getData();
				JSONObject data = new JSONObject();
				dataMap.forEach((k,v) -> {
					try {
						data.put(k, v);
					} catch (JSONException e) {						
						e.printStackTrace();
					}
				});
		 		
				body.put("notification", notification);
				body.put("data", data);
				
				HttpEntity<String> request = new HttpEntity<>(body.toString());
				System.out.println(body);
				
				String fcmResponse = restTemplate.postForObject(fcmUrl, request, String.class);	
				return ResponseEntity.ok(fcmResponse);
				
			}
			catch (JSONException ex) {
				ex.printStackTrace();
			}
		return ResponseEntity.ok().build();
	}
}
