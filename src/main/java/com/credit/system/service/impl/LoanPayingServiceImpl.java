package com.credit.system.service.impl;

import com.credit.system.entity.LoanPaying;
import com.credit.system.repo.LoanPayingRepo;
import com.credit.system.service.LoanPayingService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LoanPayingServiceImpl extends BaseServiceImpl<LoanPaying, LoanPayingRepo> implements LoanPayingService {
    public LoanPayingServiceImpl(LoanPayingRepo loanPayingRepo) {
        super(loanPayingRepo);
    }
}
