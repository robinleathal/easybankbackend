package com.easybank.easybankbackend.service;

import com.easybank.easybankbackend.model.Accounts;

public interface AccountsService {
    Accounts findByCustomerId(int id);
}
