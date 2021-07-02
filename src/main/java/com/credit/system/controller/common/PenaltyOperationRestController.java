package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.PenaltyOperation;
import com.credit.system.service.PenaltyOperationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client/PenaltyOperation")
public class PenaltyOperationRestController extends BaseController<PenaltyOperation, PenaltyOperationService> {
    public PenaltyOperationRestController(PenaltyOperationService service) {
        super(service);
    }
}
