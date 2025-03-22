package com.example.kyoraku.controller;

import com.example.kyoraku.model.dtos.SupplierDTO;
import com.example.kyoraku.model.response.BaseResponse;
import com.example.kyoraku.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/create-supplier")
    public ResponseEntity<BaseResponse> createSupplier(@RequestBody SupplierDTO supplierDTO) {
        BaseResponse supplierDTOBaseResponse = supplierService.createSupplier(supplierDTO);
        return new ResponseEntity<>(supplierDTOBaseResponse, HttpStatus.valueOf(supplierDTOBaseResponse.getStatus()));
    }

    @GetMapping("/get-all-supplier")
    public ResponseEntity<BaseResponse> getAllSupplier() {
        BaseResponse supplierDTOBaseResponse = supplierService.getAllSupplier();
        return new ResponseEntity<>(supplierDTOBaseResponse, HttpStatus.valueOf(supplierDTOBaseResponse.getStatus()));
    }

    @GetMapping("/get-supplier-by-id/{id}")
    public ResponseEntity<BaseResponse> getSupplierById(@PathVariable Long id) {
        BaseResponse supplierDTOBaseResponse = supplierService.getSupplierById(id);
        return new ResponseEntity<>(supplierDTOBaseResponse, HttpStatus.valueOf(supplierDTOBaseResponse.getStatus()));
    }

    @PostMapping("/create-batch-supplier")
    public ResponseEntity<BaseResponse> createBatchSupplier(@RequestBody List<SupplierDTO> supplierDTOList) {
        BaseResponse supplierDTOBaseResponse = supplierService.createBatchSuppier(supplierDTOList);
        return new ResponseEntity<>(supplierDTOBaseResponse, HttpStatus.valueOf(supplierDTOBaseResponse.getStatus()));
    }

    @PostMapping("/update-supplier-by-id")
    public ResponseEntity<BaseResponse> updateProductById(@RequestBody SupplierDTO supplierDTO) {
        BaseResponse supplierDTOBaseResponse = supplierService.updateSupplierById(supplierDTO);
        return new ResponseEntity<>(supplierDTOBaseResponse, HttpStatus.valueOf(supplierDTOBaseResponse.getStatus()));
    }

    @PostMapping("/delete-supplier-by-id/{id}")
    public ResponseEntity<BaseResponse> deleteProductById(@PathVariable Long id) {
        BaseResponse supplierDTOBaseResponse = supplierService.deleteSupplierById(id);
        return new ResponseEntity<>(supplierDTOBaseResponse, HttpStatus.valueOf(supplierDTOBaseResponse.getStatus()));
    }


}
