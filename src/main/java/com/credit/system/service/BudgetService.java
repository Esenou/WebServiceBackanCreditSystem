package com.credit.system.service;

import com.credit.system.entity.Budget;
import com.credit.system.service.base.BaseService;

public interface BudgetService extends BaseService<Budget> {
    boolean decreaseBudget(Long id,Double sum);

    void increaseBudget(Long id, Double sum);
}
