package com.credit.system.entity;

import com.credit.system.enums.LoanStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tbl_loan")
public class Loan extends BaseEntity {
    private Double sumToGet;
    private LocalDateTime dueDate;
    private Double sumToPay;
    private Boolean isFirstTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loan_percent_id")
    private LoanPercent loanPercent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loan_discount_id")
    private LoanDiscount loanDiscount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private LoanStatus status;
}
