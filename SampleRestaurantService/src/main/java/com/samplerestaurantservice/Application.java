package com.samplerestaurantservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.samplerestaurantservice.rsclient.FCMClientSpring;
import com.samplerestaurantservice.util.FeignClientInterceptor;

import feign.RequestInterceptor;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableCaching
public class Application implements CommandLineRunner {

	@Autowired
	private FCMClientSpring fcmClient;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/**
	 * Create RestTemplate Bean
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
    public RequestInterceptor getFeignClientInterceptor() {
        return new FeignClientInterceptor();
    }

	@Override
	public void run(String... args) throws Exception {
		
	}

}

