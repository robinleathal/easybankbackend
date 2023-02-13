package com.easybank.easybankbackend.controller;

import com.easybank.easybankbackend.model.AccountTransactions;
import com.easybank.easybankbackend.service.AccountTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {
    @Autowired
    AccountTransactionsService accountTransactionsService;
    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
        List<AccountTransactions> accountTransactions = accountTransactionsService.findByCustomerIdOrderByTransactionsDtDesc(id);
        if (accountTransactions != null) {
            return accountTransactions;
        } else {
            return null;
        }
    }
}
