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
    private String placeOfWork;

    @Column(name = "position")
    private String position;

    @Column(name = "income")
    private String income;

    @Column(name = "expenses")
    private String expenses;

    @Column(name = "address")
    private String address;

    @Column(name = "physical_address")
    private String physicalAddress;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "marital_status")
    private MaritalStatus maritalStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client")
    private Client client;
}
