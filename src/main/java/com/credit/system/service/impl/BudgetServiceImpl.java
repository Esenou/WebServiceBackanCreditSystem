package com.credit.system.service.impl;

import com.credit.system.entity.Budget;
import com.credit.system.repo.BudgetRepo;
import com.credit.system.service.BudgetService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl extends BaseServiceImpl<Budget, BudgetRepo> implements BudgetService {
    public BudgetServiceImpl(BudgetRepo budgetRepo) {
        super(budgetRepo);
    }
}
