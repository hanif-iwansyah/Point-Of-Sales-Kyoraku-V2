package com.example.kyoraku.model.dtos;

import java.math.BigDecimal;

public class SalesOrderItemDTO {
    private String salesOrderItemId;
    private String salesOrderId;
    private String productId;
    private BigDecimal quantitySold;
    private BigDecimal unitPrice;
}
