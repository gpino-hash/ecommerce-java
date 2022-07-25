package com.application.ecommerce.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class ClientEntity {

    @Id
    private String id;

    private String name;

    private String lastname;

    private Long phone;

    private String email;

    @OneToMany(mappedBy = "client")
    private List<PurchaseEntity> purchase;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PurchaseEntity> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<PurchaseEntity> purchase) {
        this.purchase = purchase;
    }
}
