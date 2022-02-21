package com.hoangbuix.bicycle;

import com.hoangbuix.bicycle.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class BicycleApplication {

    @Autowired
    private EmailSenderService emailSenderService;

    public static void main(String[] args) {
        SpringApplication.run(BicycleApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMain() throws MessagingException {

//        emailSenderService.sendMailWithAttachment("buihoang9b8@gmail.com",
//                "This is email body",
//                "This is email subject","C:/Users/HSVINA/Pictures/1.png");

    }

}
