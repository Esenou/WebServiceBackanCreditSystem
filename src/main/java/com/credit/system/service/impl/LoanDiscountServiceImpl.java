package com.credit.system.service.impl;

import com.credit.system.entity.LoanDiscount;
import com.credit.system.repo.LoanDiscountRepo;
import com.credit.system.service.LoanDiscountService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LoanDiscountServiceImpl extends BaseServiceImpl<LoanDiscount, LoanDiscountRepo> implements LoanDiscountService {
    public LoanDiscountServiceImpl(LoanDiscountRepo loanDiscountRepo) {
        super(loanDiscountRepo);
    }
}
