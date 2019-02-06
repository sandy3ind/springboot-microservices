package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class SampleEmailServiceApplication {

	private JavaMailSender mailSender;
	
	public static void main(String[] args) {
		SpringApplication.run(SampleEmailServiceApplication.class, args);
	}

}

