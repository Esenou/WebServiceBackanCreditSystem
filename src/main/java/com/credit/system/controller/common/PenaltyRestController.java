package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.entity.Penalty;
import com.credit.system.service.PenaltyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client/Penalty")
public class PenaltyRestController extends BaseController<Penalty, PenaltyService> {
    public PenaltyRestController(PenaltyService service) {
        super(service);
    }
}
