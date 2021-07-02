package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.LoanDiscount;
import com.credit.system.service.LoanDiscountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client/LoanDiscount")
public class LoanDiscountRestController extends BaseController<LoanDiscount, LoanDiscountService> {
    public LoanDiscountRestController(LoanDiscountService service) {
        super(service);
    }
}
