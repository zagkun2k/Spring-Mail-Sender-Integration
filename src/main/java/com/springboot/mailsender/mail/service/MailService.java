package com.springboot.mailsender.mail.service;

import com.springboot.mailsender.mail.model.MailObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String mailFrom;

    public void sendMail(String mail, MailObject object) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailFrom);
        message.setSubject(object.getSubject());
        message.setText(object.getMessage());
        message.setTo(mail);

        this.mailSender.send(message);
    }
}
