package com.credit.system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tbl_loan_discount")
public class LoanDiscount extends BaseEntity {
    private Double value;
}
