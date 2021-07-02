package com.credit.system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tbl_penalty")
public class Penalty extends BaseEntity {
    private Double value;
    private Integer days;
}
