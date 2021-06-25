package com.credit.system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_client_additional_info")
public class ClientPersonalInfo extends BaseEntity {

    @Column(name = "income")
    String income;

    @Column(name = "expenses")
    String expenses;

    @Column(name = "place_of_work")
    String placeOfWork;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client")
    Client client;
}