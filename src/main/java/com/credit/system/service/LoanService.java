package com.credit.system.service;

import com.credit.system.dto.Response;
import com.credit.system.entity.Loan;
import com.credit.system.enums.LoanStatus;
import com.credit.system.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoanService extends BaseService<Loan> {
    Response updateStatus(Long userId, Long id, LoanStatus status);

    Page<Loan> findByClient_NameAndOrderByCreateDateDesc(Pageable pageable, String username);

    Page<Loan> findAllByOrderByCreateDateDesc(Pageable pageable);

}
