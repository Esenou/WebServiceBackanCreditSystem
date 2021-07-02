package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.Loan;
import com.credit.system.service.LoanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client/Loan")
public class LoanRestController extends BaseController<Loan, LoanService> {
    public LoanRestController(LoanService service) {
        super(service);
    }
}
