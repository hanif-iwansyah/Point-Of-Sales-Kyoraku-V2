package com.example.kyoraku.controller;

import com.example.kyoraku.model.dtos.PurchaseOrderDTO;
import com.example.kyoraku.model.response.BaseResponse;
import com.example.kyoraku.service.PurchaseOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/purchase/order/item")
@RestController
public class PurchaseOrderItemController {

    @Autowired
    private PurchaseOrdersService purchaseOrderService;

    @GetMapping("/get-all-purchase-orders-item")
    public ResponseEntity<BaseResponse> getAllPurchaseOrdersItem() {
        BaseResponse pordersDTOBaseResponse = purchaseOrderService.getAllPurchaseOrders();
        return new ResponseEntity<>(pordersDTOBaseResponse, HttpStatus.valueOf(pordersDTOBaseResponse.getStatus()));
    }

    @GetMapping("/get-purchase-orders-item/{id}")
    public ResponseEntity<BaseResponse> getPurchaseOrdersItemById(@PathVariable Long id) {
        BaseResponse pordersDTOBaseResponse = purchaseOrderService.getPurchaseOrdersById(id);
        return new ResponseEntity<>(pordersDTOBaseResponse, HttpStatus.valueOf(pordersDTOBaseResponse.getStatus()));
    }

    @PostMapping("/create-purchase-orders-item")
    public ResponseEntity<BaseResponse> createPurchaseOrdersItem(@RequestBody PurchaseOrderDTO purchaseOrderDTO) {
        BaseResponse pordersDTOBaseResponse = purchaseOrderService.createPurchaseOrder(purchaseOrderDTO);
        return new ResponseEntity<>(pordersDTOBaseResponse, HttpStatus.valueOf(pordersDTOBaseResponse.getStatus()));
    }

    @PostMapping("/update-purchase-orders-item")
    public ResponseEntity<BaseResponse> updatePurchaseOrdersItemById(@RequestBody PurchaseOrderDTO purchaseOrderDTO) {
        BaseResponse pordersDTOBaseResponse = purchaseOrderService.updatePurchaseOrderById(purchaseOrderDTO);
        return new ResponseEntity<>(pordersDTOBaseResponse, HttpStatus.valueOf(pordersDTOBaseResponse.getStatus()));
    }

    @PostMapping("/delete-purchase-orders-item/{id}")
    public ResponseEntity<BaseResponse> deletePurchaseOrdersItemById(@PathVariable Long id) {
        BaseResponse pordersDTOBaseResponse = purchaseOrderService.deletePurchaseOrderById(id);
        return new ResponseEntity<>(pordersDTOBaseResponse, HttpStatus.valueOf(pordersDTOBaseResponse.getStatus()));
    }

}
