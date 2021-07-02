package com.credit.system.entity;


import com.credit.system.enums.OperationType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_budget_operation")
public class BudgetOperation extends BaseEntity {
    private Double sum;

    private OperationType operationType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "budget_id")
    private Budget budget;
}
