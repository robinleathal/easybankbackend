package com.easybank.easybankbackend.controller;

import com.easybank.easybankbackend.model.Contact;
import com.easybank.easybankbackend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Random;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
        contact.setContactId(getServiceRequestNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return contactService.save(contact);
    }

    private String getServiceRequestNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR"+ranNum;
    }
}
