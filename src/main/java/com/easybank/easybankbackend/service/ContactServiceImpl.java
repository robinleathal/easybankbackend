package com.easybank.easybankbackend.service;

import com.easybank.easybankbackend.model.Contact;
import com.easybank.easybankbackend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }
}
