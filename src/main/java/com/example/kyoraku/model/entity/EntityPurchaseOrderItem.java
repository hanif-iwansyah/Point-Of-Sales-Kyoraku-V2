package com.example.kyoraku.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "purchase_order_item")
public class EntityPurchaseOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oder_item_id")
    private long orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private EntityPurchaseOrder purchaseOrder;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity_ordered")
    private BigDecimal quantityOrdered;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    public EntityPurchaseOrderItem() {
    }

    public EntityPurchaseOrderItem(EntityPurchaseOrder purchaseOrder, Long productId, BigDecimal quantityOrdered, BigDecimal unitPrice) {
        this.purchaseOrder = purchaseOrder;
        this.productId = productId;
        this.quantityOrdered = quantityOrdered;
        this.unitPrice = unitPrice;
    }


    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public EntityPurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(EntityPurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(BigDecimal quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "EntityPurchaseOrderItem{" +
                "orderItemId=" + orderItemId +
                ", purchaseOrder=" + purchaseOrder +
                ", product_id=" + productId +
                ", quantityOrdered=" + quantityOrdered +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
