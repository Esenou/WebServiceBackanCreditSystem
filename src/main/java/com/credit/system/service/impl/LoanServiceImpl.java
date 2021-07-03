package com.credit.system.service.impl;

import com.credit.system.dto.Response;
import com.credit.system.entity.Loan;
import com.credit.system.entity.User;
import com.credit.system.enums.LoanStatus;
import com.credit.system.repo.LoanRepo;
import com.credit.system.service.BudgetOperationService;
import com.credit.system.service.LoanService;
import com.credit.system.service.UserService;
import com.credit.system.service.base.BaseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl extends BaseServiceImpl<Loan, LoanRepo> implements LoanService {
    private final BudgetOperationService budgetOperationService;
    private final UserService userService;

    public LoanServiceImpl(LoanRepo loanRepo, BudgetOperationService budgetOperationService,
                           UserService userService) {
        super(loanRepo);
        this.budgetOperationService = budgetOperationService;
        this.userService = userService;
    }

    @Override
    public Response updateStatus(Long userId, Long id, LoanStatus status) {
        User user = userService.findById(userId);
        Loan loan = findById(id);
        loan.setUser(user);
        if (LoanStatus.ACCEPTED.equals(status)) {
            boolean isEnoughBudget = budgetOperationService
                    .outcomeOperation(BudgetServiceImpl.budgetId, loan.getSumToGet());
            if (isEnoughBudget) {
                loan.setStatus(status);
                repo.saveAndFlush(loan);
                return new Response(HttpStatus.OK, "Заявка удачно принят");
            } else
                return new Response(HttpStatus.BAD_REQUEST, "Не достаточно средств в бюджете");
        }
        loan.setStatus(status);
        repo.saveAndFlush(loan);
        return new Response(HttpStatus.OK, "Статус обновлен!");
    }
}
