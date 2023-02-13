package com.easybank.easybankbackend.controller;

import com.easybank.easybankbackend.model.Customer;
import com.easybank.easybankbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer savedCustomer = null;
        ResponseEntity responseEntity = null;
        try {
            //implement BcryptHashing for password
            String hashedPassword = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashedPassword);
            customer.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
            System.out.println("Hashed"+customer.getPwd());
            savedCustomer = customerService.save(customer);
            if (savedCustomer.getId() > 0) {
                responseEntity = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            responseEntity = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred due to " + ex.getMessage());
        }
        return responseEntity;
    }
    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        List<Customer> customers = customerService.findByEmail(authentication.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;
        }
    }
}
