package com.credit.system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_client_card_info")
public class ClientCardInfo extends BaseEntity {

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "electronic_account")
    private String electronicAccount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client")
    private Client client;
}
