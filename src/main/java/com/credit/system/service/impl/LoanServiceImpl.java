package com.credit.system.service.impl;

import com.credit.system.entity.Loan;
import com.credit.system.repo.LoanRepo;
import com.credit.system.service.LoanService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl extends BaseServiceImpl<Loan, LoanRepo> implements LoanService{
    public LoanServiceImpl(LoanRepo loanRepo) {
        super(loanRepo);
    }
}
