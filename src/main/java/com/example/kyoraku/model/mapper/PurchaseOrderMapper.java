package com.example.kyoraku.model.mapper;

import com.example.kyoraku.model.dtos.PurchaseOrderDTO;
import com.example.kyoraku.model.dtos.PurchaseOrderItemDTO;
import com.example.kyoraku.model.entity.EntityPurchaseOrder;
import com.example.kyoraku.model.entity.EntityPurchaseOrderItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseOrderMapper {
    public static PurchaseOrderDTO toDTO(EntityPurchaseOrder entityPurchaseOrder) {
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setOrderId(entityPurchaseOrder.getOrderId() != null ? entityPurchaseOrder.getOrderId() : 0L);
        purchaseOrderDTO.setSupplierId(entityPurchaseOrder.getSupplierId() != null ? entityPurchaseOrder.getSupplierId() : 0L);
        purchaseOrderDTO.setOrderDate(entityPurchaseOrder.getOrderDate() != null ? entityPurchaseOrder.getOrderDate() : new Date());
        purchaseOrderDTO.setStatus(entityPurchaseOrder.getStatus() != null ? entityPurchaseOrder.getStatus() : "");

        if (entityPurchaseOrder.getPurchaseOrderItems() != null) {
            purchaseOrderDTO.setPurchaseOrderItems(
                    entityPurchaseOrder
                            .getPurchaseOrderItems()
                            .stream()
                            .map(PurchaseOrderMapper::toDTO)
                            .collect(java.util.stream.Collectors.toList()));
        }

        return purchaseOrderDTO;
    }


    public static PurchaseOrderItemDTO toDTO(EntityPurchaseOrderItem entityPurchaseOrderItem) {
        PurchaseOrderItemDTO purchaseOrderItemDTO = new PurchaseOrderItemDTO();
        purchaseOrderItemDTO.setOrderItemId(entityPurchaseOrderItem.getOrderItemId() != null ? entityPurchaseOrderItem.getOrderItemId() : 0L);
        purchaseOrderItemDTO.setOrderId(entityPurchaseOrderItem.getPurchaseOrder().getOrderId() != null ? entityPurchaseOrderItem.getOrderItemId() : 0L);
        purchaseOrderItemDTO.setProductId(entityPurchaseOrderItem.getProductId() != null ? entityPurchaseOrderItem.getProductId() : 0L);
        purchaseOrderItemDTO.setQuantityOrdered(entityPurchaseOrderItem.getQuantityOrdered() != null ? entityPurchaseOrderItem.getQuantityOrdered() : BigDecimal.ZERO);
        purchaseOrderItemDTO.setUnitPrice(entityPurchaseOrderItem.getUnitPrice() != null ? entityPurchaseOrderItem.getUnitPrice() : BigDecimal.ZERO);
        return purchaseOrderItemDTO;
    }

    public static List<PurchaseOrderDTO> toListDTO(List<EntityPurchaseOrder> entityPurchaseOrder) {
        return entityPurchaseOrder.stream().map(purchaseOrder -> {
            PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
            purchaseOrderDTO.setOrderId(purchaseOrder.getOrderId() != null ? purchaseOrder.getOrderId() : 0L);
            purchaseOrderDTO.setSupplierId(purchaseOrder.getSupplierId() != null ? purchaseOrder.getSupplierId() : 0L);
            purchaseOrderDTO.setOrderDate(purchaseOrder.getOrderDate() != null ? purchaseOrder.getOrderDate() : new Date());
            purchaseOrderDTO.setStatus(purchaseOrder.getStatus() != null ? purchaseOrder.getStatus() : "");
            return purchaseOrderDTO;
        }).collect(Collectors.toList());
    }

/*
    public static List<EntityCategory> toListEntityDTO(List<CategoryDTO> categoryDTOList) {
        return categoryDTOList.stream().map(category -> {
            EntityCategory entityCategory = new EntityCategory();
            entityCategory.setCategoryId(category.getCategoryId() != null ? category.getCategoryId() : 0L);
            entityCategory.setCategoryName(category.getCategoryName() != null ? category.getCategoryName() : "");
            entityCategory.setDescription(category.getDescription() != null ? category.getDescription() : "");
            return entityCategory;
        }).collect(Collectors.toList());
    }
*/

    public static EntityPurchaseOrder toEntity(PurchaseOrderDTO purchaseOrderDTO) {
        EntityPurchaseOrder entityPurchaseOrder = new EntityPurchaseOrder();
        entityPurchaseOrder.setOrderId(purchaseOrderDTO.getOrderId() != null ? purchaseOrderDTO.getOrderId() : 0L);
        entityPurchaseOrder.setSupplierId(purchaseOrderDTO.getSupplierId() != null ? purchaseOrderDTO.getSupplierId() : 0L);
        entityPurchaseOrder.setOrderDate(purchaseOrderDTO.getOrderDate() != null ? purchaseOrderDTO.getOrderDate() : new Date());
        entityPurchaseOrder.setStatus(purchaseOrderDTO.getStatus() != null ? purchaseOrderDTO.getStatus() : "");
        //entityPurchaseOrder.setPurchaseOrderItems(null);
        /*if (purchaseOrderDTO.getPurchaseOrderItems() != null) {
            entityPurchaseOrder.setPurchaseOrderItems(
                    purchaseOrderDTO
                            .getPurchaseOrderItems()
                            .stream()
                            .map(PurchaseOrderMapper::toEntity)
                            .collect(java.util.stream.Collectors.toList()));
        }*/

        return entityPurchaseOrder;
    }


    public static EntityPurchaseOrderItem toEntity(PurchaseOrderItemDTO purchaseOrderItemDTO) {
        EntityPurchaseOrderItem entityPurchaseOrderItem = new EntityPurchaseOrderItem();
        entityPurchaseOrderItem.setOrderItemId(purchaseOrderItemDTO.getOrderItemId() != null ? entityPurchaseOrderItem.getOrderItemId() : 0L);
        entityPurchaseOrderItem.setProductId(entityPurchaseOrderItem.getProductId() != null ? entityPurchaseOrderItem.getProductId() : 0L);
        entityPurchaseOrderItem.setQuantityOrdered(entityPurchaseOrderItem.getQuantityOrdered() != null ? entityPurchaseOrderItem.getQuantityOrdered() : BigDecimal.ZERO);
        entityPurchaseOrderItem.setUnitPrice(entityPurchaseOrderItem.getUnitPrice() != null ? entityPurchaseOrderItem.getUnitPrice() : BigDecimal.ZERO);
        return entityPurchaseOrderItem;
    }
}
