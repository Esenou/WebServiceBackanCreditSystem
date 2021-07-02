package com.credit.system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tbl_loan_percent")
public class LoanPercent extends BaseEntity {
    private Double value;
    private Integer termInDays;
}
