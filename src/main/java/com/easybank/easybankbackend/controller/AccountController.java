package com.easybank.easybankbackend.controller;

import com.easybank.easybankbackend.model.Accounts;
import com.easybank.easybankbackend.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    AccountsService accountsService;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id) {
        Accounts accounts = accountsService.findByCustomerId(id);
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }

    }
}
