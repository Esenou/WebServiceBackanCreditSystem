package com.credit.system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tbl_loan_extension")
public class LoanExtension extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loan_id")
    private Loan loan;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "penalty_id")
    private Penalty penalty;
    private LocalDateTime dueDate;
}
