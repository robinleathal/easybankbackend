package com.easybank.easybankbackend.service;

import com.easybank.easybankbackend.model.AccountTransactions;
import com.easybank.easybankbackend.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTransactionsServiceImpl implements AccountTransactionsService {
    @Autowired
    AccountTransactionsRepository accountTransactionsRepository;
    @Override
    public List<AccountTransactions> findByCustomerIdOrderByTransactionsDtDesc(int id) {
        return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
    }
}
