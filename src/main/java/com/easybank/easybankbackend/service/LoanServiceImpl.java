package com.easybank.easybankbackend.service;

import com.easybank.easybankbackend.model.Loans;
import com.easybank.easybankbackend.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepository loanRepository;
    @Override
    public List<Loans> findByCustomerIdOrderByStartDtDesc(int id) {
        return loanRepository.findByCustomerIdOrderByStartDtDesc(id);
    }
}
