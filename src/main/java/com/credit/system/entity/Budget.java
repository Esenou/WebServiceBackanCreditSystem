package com.credit.system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tbl_budget")
public class Budget extends BaseEntity {
    private Double sum;
}
