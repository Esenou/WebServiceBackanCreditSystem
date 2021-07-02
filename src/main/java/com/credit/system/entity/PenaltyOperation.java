package com.credit.system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_penalty_operation")
public class PenaltyOperation extends BaseEntity {
    private Double sum;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "penalty_id")
    private Penalty penalty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loan_id")
    private Loan loan;
}
