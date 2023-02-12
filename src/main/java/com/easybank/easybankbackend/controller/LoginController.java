package com.easybank.easybankbackend.controller;

import com.easybank.easybankbackend.model.Customer;
import com.easybank.easybankbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer savedCustomer = null;
        ResponseEntity responseEntity = null;
        try {
            savedCustomer = customerService.save(customer);
            if (savedCustomer.getId() > 0) {
                responseEntity = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            responseEntity = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to \" + ex.getMessage()");
        }
        return responseEntity;
    }
}
