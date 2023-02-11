package com.easybank.easybankbackend.repository;

import com.easybank.easybankbackend.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByEmail(String email);
}
