package com.credit.system.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_client_password")
public class ClientPasswordInfo extends BaseEntity {

    @Column(name = "inn" , nullable = false)
    private String inn;

    @Column(name = "seria_no", nullable = false)
    private String seriaNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "issued_authority", nullable = false)
    private String issuedAuthority;


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
