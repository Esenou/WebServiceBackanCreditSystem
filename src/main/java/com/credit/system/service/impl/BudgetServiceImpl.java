package com.credit.system.service.impl;

import com.credit.system.entity.Budget;
import com.credit.system.repo.BudgetRepo;
import com.credit.system.service.BudgetService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl extends BaseServiceImpl<Budget, BudgetRepo> implements BudgetService {
    public static final Long budgetId = 1L;
    public BudgetServiceImpl(BudgetRepo budgetRepo) {
        super(budgetRepo);
    }


    @Override
    public synchronized boolean decreaseBudget(Long id, Double sum) {
        Budget budget = findById(id);
        if (budget.getSum() >= sum) {
            budget.setSum(budget.getSum() - sum);
            repo.saveAndFlush(budget);
            return true;
        }
        return false;
    }

    @Override
    public synchronized void increaseBudget(Long id, Double sum) {
        Budget budget = findById(id);
        budget.setSum(budget.getSum() + sum);
        repo.saveAndFlush(budget);
    }
}
