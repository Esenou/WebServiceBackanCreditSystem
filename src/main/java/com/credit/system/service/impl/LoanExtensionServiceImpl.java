package com.credit.system.service.impl;

import com.credit.system.entity.LoanExtension;
import com.credit.system.repo.LoanExtensionRepo;
import com.credit.system.service.LoanExtensionService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LoanExtensionServiceImpl extends BaseServiceImpl<LoanExtension, LoanExtensionRepo> implements LoanExtensionService {
    public LoanExtensionServiceImpl(LoanExtensionRepo loanExtensionRepo) {
        super(loanExtensionRepo);
    }
}
