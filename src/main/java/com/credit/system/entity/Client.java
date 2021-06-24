package com.credit.system.entity;

import com.credit.system.enums.ListStatus;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "tbl_client")
public class Client extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_no", nullable = false)
    private String phoneNo;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "status")
    private ListStatus status = ListStatus.ACTIVE;
}