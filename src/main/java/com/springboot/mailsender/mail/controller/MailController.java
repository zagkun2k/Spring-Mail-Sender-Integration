package com.springboot.mailsender.mail.controller;

import com.springboot.mailsender.mail.model.MailObject;
import com.springboot.mailsender.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService service;

    @RequestMapping(value = "/sender-mail/{mail}", method = RequestMethod.POST)
    public ResponseEntity<String> senderMail(@PathVariable (value = "mail") String mail, @RequestBody MailObject object) {

        this.service.sendMail(mail, object);
        return ResponseEntity.status(HttpStatus.OK).body("Mail sent successfully!!!");
    }
}
