package com.example.rs;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmailSender;
import com.example.domain.Mail;

@RestController
public class EmailService {

	@Autowired
	private EmailSender emailSender;
	
	@Value("${subject.user-verification-code}")
	private String subjectVerificationCode;
	
	/**
	 * Send User Verification Email
	 * 
	 * @param mail
	 * @param errors
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> userVerificationCode(@Valid @RequestBody Mail mail, Errors errors) {
		// Validate input values
		if (errors.hasErrors()) {			
			// Build all errors
            Map<String, String> msg = errors.getAllErrors()
				.stream()
				.map(err -> (FieldError) err)
				.collect(Collectors.toMap(FieldError::getField, err -> err.getDefaultMessage()));            
		}
				
		try {
			mail.setSubject(subjectVerificationCode);
			emailSender.sendMail(mail, "email-verification-code");
		} catch (MessagingException | IOException e) {			
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().build();
	}
	
}
