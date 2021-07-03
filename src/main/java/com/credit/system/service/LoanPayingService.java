package com.credit.system.service;

import com.credit.system.dto.PayingDto;
import com.credit.system.dto.Response;
import com.credit.system.entity.LoanPaying;
import com.credit.system.service.base.BaseService;

public interface LoanPayingService extends BaseService<LoanPaying> {
    Response pay(PayingDto dto);
}
