package com.credit.system.controller.common;

import com.credit.system.controller.base.BaseController;
import com.credit.system.dto.Response;
import com.credit.system.entity.Loan;
import com.credit.system.enums.LoanStatus;
import com.credit.system.service.LoanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/client/Loan")
public class LoanRestController extends BaseController<Loan, LoanService> {
    public LoanRestController(LoanService service) {
        super(service);
    }

    @PostMapping("/update_status")
    public Response updateStatus(@RequestParam Long userId, @RequestParam Long id, @RequestParam String status) {
        return baseService.updateStatus(userId, id, LoanStatus.valueOf(status));
    }
}
