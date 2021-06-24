package com.credit.system.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_client_password")
public class ClientPassword extends BaseEntity {

    @Column(name = "inn" , nullable = false)
    private String inn;

    @Column(name = "seria_no", nullable = false)
    private String seriaNo;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "issued_by_whom", nullable = false)
    private Date issuedByWhom;

    @Column(name = "address_region", nullable = false)
    private String addressRegion;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number_home", nullable = false)
    private String numberHome;

    @Column(name = "number_home_no", nullable = false)
    private String numberHomeNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client")
    private Client client;
}
