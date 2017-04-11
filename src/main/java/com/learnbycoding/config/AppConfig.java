package com.learnbycoding.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(basePackages="com.learnbycoding.*")
public class AppConfig {
	
	@Bean 
	public MailSender mailsender(){
		
		JavaMailSenderImpl  javaMailSenderImpl= new JavaMailSenderImpl();
		javaMailSenderImpl.setHost("smtp.gmail.com");
		javaMailSenderImpl.setPort(25);
		javaMailSenderImpl.setUsername("abcd@gmail.com");
		javaMailSenderImpl.setPassword("password");
		
		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.transport.protocol", "smtp");
		javaMailProperties.setProperty("mail.smtp.auth", "true");
		javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
		javaMailProperties.setProperty("mail.debug", "true");
		
		javaMailSenderImpl.setJavaMailProperties(javaMailProperties);
		
		return javaMailSenderImpl;
	}
	
	@Bean
	public SimpleMailMessage simpleMailMessage(){
		SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
		simpleMailMessage.setTo("abcd@gmail.com");
		simpleMailMessage.setFrom("defg@gmail.com");
		simpleMailMessage.setSubject("Error occured , now run for your life");
		
		return simpleMailMessage;
		
	}
}
