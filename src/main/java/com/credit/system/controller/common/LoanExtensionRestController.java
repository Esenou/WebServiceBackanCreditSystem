package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.LoanExtension;
import com.credit.system.service.LoanExtensionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client/LoanExtension")
public class LoanExtensionRestController extends BaseController<LoanExtension, LoanExtensionService> {
    public LoanExtensionRestController(LoanExtensionService service) {
        super(service);
    }
}
