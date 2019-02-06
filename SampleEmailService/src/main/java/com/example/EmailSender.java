package com.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.example.domain.Mail;

@Component
public class EmailSender {

	@Autowired
    private JavaMailSender emailSender;	
	
	@Value("${from}")
	private String from;

    @Autowired
    //private SpringTemplateEngine templateEngine;
    private SpringTemplateEngine springTemplateEngine;
    
    
    public void sendMail(Mail mail, String template) throws MessagingException, IOException {
        MimeMessage message = emailSender.createMimeMessage();
        
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        //final MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");

        Context context = new Context();
        context.setVariables(mail.getData());
        String html = springTemplateEngine.process(template, context);

        helper.setTo(mail.getTo());
        helper.setText(html, true);
        helper.setSubject(mail.getSubject());
        helper.setFrom(from);

        emailSender.send(message);
    }
}
