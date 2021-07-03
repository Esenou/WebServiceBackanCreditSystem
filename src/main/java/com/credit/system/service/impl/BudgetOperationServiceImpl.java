package com.credit.system.service.impl;

import com.credit.system.entity.Budget;
import com.credit.system.entity.BudgetOperation;
import com.credit.system.enums.OperationType;
import com.credit.system.repo.BudgetOperationRepo;
import com.credit.system.service.BudgetOperationService;
import com.credit.system.service.BudgetService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BudgetOperationServiceImpl extends BaseServiceImpl<BudgetOperation, BudgetOperationRepo>
        implements BudgetOperationService {
    private final BudgetService budgetService;

    public BudgetOperationServiceImpl(BudgetOperationRepo budgetOperationRepo,
                                      BudgetService budgetService) {
        super(budgetOperationRepo);
        this.budgetService = budgetService;
    }

    @Override
    public void incomeOperation(Long id, Double sum) {
        createOperation(id, sum);
        budgetService.increaseBudget(id, sum);
    }

    @Override
    public boolean outcomeOperation(Long id, Double sum) {
        boolean isEnoughBudget = budgetService.decreaseBudget(id, sum);
        if (!isEnoughBudget) {
            return false;
        }
        createOperation(id, sum);
        return true;
    }

    private void createOperation(Long id, Double sum) {
        Budget budget = budgetService.findById(id);
        BudgetOperation budgetOperation = new BudgetOperation();
        budgetOperation.setBudget(budget);
        budgetOperation.setOperationType(OperationType.INCOME);
        budgetOperation.setSum(sum);
        repo.saveAndFlush(budgetOperation);
    }
}
