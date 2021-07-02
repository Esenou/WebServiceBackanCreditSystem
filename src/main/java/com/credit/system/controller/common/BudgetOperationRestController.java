package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.BudgetOperation;
import com.credit.system.service.BudgetOperationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client/BudgetOperation")
public class BudgetOperationRestController extends BaseController<BudgetOperation, BudgetOperationService> {
    public BudgetOperationRestController(BudgetOperationService service) {
        super(service);
    }
}
