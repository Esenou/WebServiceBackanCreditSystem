package com.credit.system.service;

import com.credit.system.entity.BudgetOperation;
import com.credit.system.service.base.BaseService;

public interface BudgetOperationService extends BaseService<BudgetOperation> {

    void incomeOperation(Long id, Double sum);

    boolean outcomeOperation(Long id, Double sum);
}
