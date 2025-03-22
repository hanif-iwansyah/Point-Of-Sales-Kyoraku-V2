package com.example.kyoraku.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class EntityProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id")
    @JsonProperty("product_id")
    public long productId;

    @Column(name = "product_name")
    @JsonProperty("product_name")
    public String productName;

    @Column(name = "description")
    @JsonProperty("description")
    public String description;

    @Column(name = "price")
    @JsonProperty("price")
    public BigDecimal price;

    @Column(name = "quantity_in_stock")
    @JsonProperty("quantity_in_stock")
    public BigDecimal quantityInStock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonManagedReference
    public EntityCategory category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    @JsonManagedReference
    public EntitySupplier supplier;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(BigDecimal quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public EntityCategory getCategory() {
        return category;
    }

    public void setCategory(EntityCategory category) {
        this.category = category;
    }

    public EntitySupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(EntitySupplier supplier) {
        this.supplier = supplier;
    }

}
