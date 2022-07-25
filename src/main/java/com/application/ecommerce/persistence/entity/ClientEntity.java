package com.application.ecommerce.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String lastname;

    private Integer phone;

    private String email;

    @OneToMany(mappedBy = "client")
    private List<PurchaseEntity> purchase;
}
