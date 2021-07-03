package com.credit.system.entity;

import com.credit.system.enums.ListStatus;
import com.credit.system.enums.Roles;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_user")
public class User extends BaseEntity {
    private String username;
    private String password;

    private String fullName;
    private ListStatus status;
    private Roles role;
}
