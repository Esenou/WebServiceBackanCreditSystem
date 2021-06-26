package com.credit.system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_passport_info")
public class ClientPassportInfo extends BaseEntity{

    @Column(name = "passport_id", nullable = false)
    private String passportId;

    @Column(name = "personal_number", nullable = false)
    private String personalNumber;

    @Column(name = "Authority", nullable = false)
    private String authority;

    @Column(name = "issued_date", nullable = false)
    private Date issuedDate;

    @Column(name = "expire_date", nullable = false)
    private Date epireDate;

}
