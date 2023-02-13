package com.easybank.easybankbackend.service;

import com.easybank.easybankbackend.model.Loans;

import java.util.List;

public interface LoanService {
    List<Loans> findByCustomerIdOrderByStartDtDesc(int id);
}
