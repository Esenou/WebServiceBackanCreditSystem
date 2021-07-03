package com.credit.system.service.impl;

import com.credit.system.dto.PayingDto;
import com.credit.system.dto.Response;
import com.credit.system.entity.Loan;
import com.credit.system.entity.LoanPaying;
import com.credit.system.entity.User;
import com.credit.system.repo.LoanPayingRepo;
import com.credit.system.service.*;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoanPayingServiceImpl extends BaseServiceImpl<LoanPaying, LoanPayingRepo> implements LoanPayingService {
    private final LoanService loanService;
    private final UserService userService;
    private final BudgetOperationService budgetOperationService;

    public LoanPayingServiceImpl(LoanPayingRepo loanPayingRepo,
                                 LoanService loanService, UserService userService,
                                 BudgetOperationService budgetOperationService) {
        super(loanPayingRepo);
        this.loanService = loanService;
        this.userService = userService;
        this.budgetOperationService = budgetOperationService;
    }

    @Override
    public Response pay(PayingDto dto) {
        if (dto.getSum() < 0)
            return new Response(HttpStatus.BAD_REQUEST, "Не валидная сумма!");
        Loan loan = loanService.findById(dto.getLoanId());
        User user = userService.findById(dto.getUserId());

        LoanPaying loanPaying = new LoanPaying();
        loanPaying.setLoan(loan);
        loanPaying.setUser(user);
        loanPaying.setSum(dto.getSum());

        budgetOperationService.incomeOperation(BudgetServiceImpl.budgetId, dto.getSum());
        repo.saveAndFlush(loanPaying);
        return new Response(HttpStatus.OK, "Вы успешно оплатили сумму:" + dto.getSum());
    }
}
