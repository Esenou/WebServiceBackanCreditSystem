package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.LoanPaying;
import com.credit.system.service.LoanPayingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client/LoanPaying")
public class LoanPayingRestController extends BaseController<LoanPaying, LoanPayingService> {
    public LoanPayingRestController(LoanPayingService service) {
        super(service);
    }
}
