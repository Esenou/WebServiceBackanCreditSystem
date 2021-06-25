package com.credit.system.entity;

import com.credit.system.enums.MaritalStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_client_additional_info")
public class ClientAdditionalInfo extends BaseEntity {

    @Column(name = "place_of_work")
    String placeOfWork;

    @Column(name = "position")
    String position;

    @Column(name = "income")
    String income;

    @Column(name = "expenses")
    String expenses;

    @Column(name = "address")
    String address;

    @Column(name = "physical_address")
    String physicalAddress;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "marital_status")
    MaritalStatus maritalStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client")
    Client client;
}
