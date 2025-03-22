package com.example.kyoraku.model.dtos;

import java.math.BigDecimal;

public class PurchaseOrderItemDTO {
    private Long orderItemId;
    private Long orderId;
    private Long productId;
    private BigDecimal quantityOrdered;
    private BigDecimal unitPrice;

    public PurchaseOrderItemDTO() {
    }

    public PurchaseOrderItemDTO(Long orderItemId, Long productId, BigDecimal quantityOrdered, BigDecimal unitPrice) {
        this.orderItemId = orderItemId;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
        return "PurchaseOrderItemDTO{" +
                "orderItemId=" + orderItemId +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", quantityOrdered=" + quantityOrdered +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
