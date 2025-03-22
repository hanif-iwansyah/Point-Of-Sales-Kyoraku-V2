package com.example.kyoraku.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    private String productId;
    private String productName;
    private String description;
    private BigDecimal price;
    private BigDecimal quantityInStock;
    private String categoryId;
    private String supplierId;
}
