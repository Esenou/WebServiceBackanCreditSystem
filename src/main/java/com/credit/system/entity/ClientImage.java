package com.credit.system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_client_image")
public class ClientImage extends BaseEntity{
    @Column(name = "first_image")
    private String firstImage;

    @Column(name = "second_image")
    private String secondImage;

    @Column(name = "third_image")
    private String thirdImage;

    @Column(name = "fourth_image")
    private String fourthImage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client")
    private Client client;
}
