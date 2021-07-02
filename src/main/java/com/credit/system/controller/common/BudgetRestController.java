package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.Budget;
import com.credit.system.service.BudgetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/client/Budget")
public class BudgetRestController extends BaseController<Budget, BudgetService> {
    public BudgetRestController(BudgetService service) {
        super(service);
    }
}
