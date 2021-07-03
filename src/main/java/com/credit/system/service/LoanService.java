package com.credit.system.service;

import com.credit.system.dto.Response;
import com.credit.system.entity.Loan;
import com.credit.system.enums.LoanStatus;
import com.credit.system.service.base.BaseService;

public interface LoanService extends BaseService<Loan> {
    Response updateStatus(Long userId, Long id, LoanStatus status);
}
