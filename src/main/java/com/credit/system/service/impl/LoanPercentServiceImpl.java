package com.credit.system.service.impl;

import com.credit.system.entity.LoanPercent;
import com.credit.system.repo.LoanPercentRepo;
import com.credit.system.service.LoanPercentService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LoanPercentServiceImpl extends BaseServiceImpl<LoanPercent, LoanPercentRepo> implements LoanPercentService {
    public LoanPercentServiceImpl(LoanPercentRepo loanPercentRepo) {
        super(loanPercentRepo);
    }
}
