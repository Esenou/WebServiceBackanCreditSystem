package com.credit.system.service.impl;

import com.credit.system.entity.BudgetOperation;
import com.credit.system.repo.BudgetOperationRepo;
import com.credit.system.service.BudgetOperationService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BudgetOperationServiceImpl extends BaseServiceImpl<BudgetOperation, BudgetOperationRepo> implements BudgetOperationService {
    public BudgetOperationServiceImpl(BudgetOperationRepo budgetOperationRepo) {
        super(budgetOperationRepo);
    }
}
