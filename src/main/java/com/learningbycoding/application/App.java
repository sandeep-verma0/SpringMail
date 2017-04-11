package com.learningbycoding.application;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learnbycoding.config.AppConfig;
import com.learnbycoding.service.MailService;

public class App {
	public static void main(String[] args)  {

		ApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfig.class);
	
         
        //Get the mailer instance
		MailService mailService = (MailService) ctxt.getBean("mailService");
 
        //Compose and send mail
		mailService.sendMail("abcd@gmail.com", "Test Subject", "Testing body");
 
        //Send a pre-configured mail
		mailService.sendPreConfiguredMail("Exception occurred everywhere.. where are you ????");
	}
}
