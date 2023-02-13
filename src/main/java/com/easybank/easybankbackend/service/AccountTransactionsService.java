package com.easybank.easybankbackend.service;

import com.easybank.easybankbackend.model.AccountTransactions;

import java.util.List;

public interface AccountTransactionsService {

    List<AccountTransactions> findByCustomerIdOrderByTransactionsDtDesc(int id);
}
