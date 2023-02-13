package com.easybank.easybankbackend.service;

import com.easybank.easybankbackend.model.Customer;
import com.easybank.easybankbackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findByEmail(String name) {
        return customerRepository.findByEmail(name);
    }
}
