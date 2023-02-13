package com.easybank.easybankbackend.service;

import com.easybank.easybankbackend.model.Accounts;
import com.easybank.easybankbackend.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImpl implements AccountsService{
    @Autowired
    AccountsRepository accountsRepository;

    @Override
    public Accounts findByCustomerId(int id) {

        return accountsRepository.findByCustomerId(id);
    }
}
