package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.LoanPercent;
import com.credit.system.service.LoanPercentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client/LoanPercent")
public class LoanPercentRestController extends BaseController<LoanPercent, LoanPercentService> {
    public LoanPercentRestController(LoanPercentService service) {
        super(service);
    }
}
