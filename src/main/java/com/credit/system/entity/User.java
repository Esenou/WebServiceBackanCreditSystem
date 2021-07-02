package com.credit.system.entity;

import com.credit.system.enums.ListStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tbl_user")
public class User extends BaseEntity {
    private String username;
    private String password;

    private String fullName;
    private ListStatus status;
}
