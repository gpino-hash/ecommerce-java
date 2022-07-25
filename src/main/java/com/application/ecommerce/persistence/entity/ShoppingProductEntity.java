package com.application.ecommerce.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "shopping_products")
public class ShoppingProductEntity {

    @EmbeddedId
    private ShoppingProductPK id;

    private Integer amount;

    private BigDecimal total;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "purchase_id", insertable = false, updatable = false)
    private PurchaseEntity purchase;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    public ShoppingProductPK getId() {
        return id;
    }

    public void setId(ShoppingProductPK id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public PurchaseEntity getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseEntity purchase) {
        this.purchase = purchase;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
