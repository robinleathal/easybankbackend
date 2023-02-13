package com.easybank.easybankbackend.service;

import com.easybank.easybankbackend.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> findByEmail(String name);
}
