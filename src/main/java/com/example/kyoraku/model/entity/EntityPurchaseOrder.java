package com.example.kyoraku.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PurchaseOrder")
public class EntityPurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @JsonProperty("order_id")
    private long orderId;

    @Column(name = "supplier_id")
    @JsonProperty("supplier_id")
    public Long supplierId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    @JsonProperty("order_date")
    private Date orderDate;

    @Column(name = "status")
    @JsonProperty("status")
    private String status;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("purchase_order_items")
    private List<EntityPurchaseOrderItem> purchaseOrderItems;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<EntityPurchaseOrderItem> getPurchaseOrderItems() {
        return purchaseOrderItems;
    }

    public void setPurchaseOrderItems(List<EntityPurchaseOrderItem> purchaseOrderItems) {
        this.purchaseOrderItems = purchaseOrderItems;
    }

    @Override
    public String toString() {
        return "EntityPurchaseOrder{" +
                "orderId=" + orderId +
                ", supplierId=" + supplierId +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", purchaseOrderItems=" + purchaseOrderItems +
                '}';
    }
}



