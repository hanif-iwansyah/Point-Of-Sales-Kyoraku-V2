package com.example.kyoraku.controller;

import com.example.kyoraku.model.dtos.ProductDTO;
import com.example.kyoraku.model.response.BaseResponse;
import com.example.kyoraku.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create-product")
    public ResponseEntity<BaseResponse> createProduct(@RequestBody ProductDTO productDTO) {
        BaseResponse productDTOBaseResponse = productService.createProduct(productDTO);
        return new ResponseEntity<>(productDTOBaseResponse, HttpStatus.valueOf(productDTOBaseResponse.getStatus()));
    }

    @GetMapping("/get-all-product")
    public ResponseEntity<BaseResponse> getAllProduct() {
        BaseResponse productDTOBaseResponse = productService.getAllProduct();
        return new ResponseEntity<>(productDTOBaseResponse, HttpStatus.valueOf(productDTOBaseResponse.getStatus()));
    }

    @GetMapping("/get-product-by-id/{id}")
    public ResponseEntity<BaseResponse> getProductById(@PathVariable Long id) {
        BaseResponse productDTOBaseResponse = productService.getProductById(id);
        return new ResponseEntity<>(productDTOBaseResponse, HttpStatus.valueOf(productDTOBaseResponse.getStatus()));
    }

    @PostMapping("/create-batch-product")
    public ResponseEntity<BaseResponse> createBatchProduct(@RequestBody List<ProductDTO> productDTO) {
        BaseResponse productDTOBaseResponse = productService.createBatchProduct(productDTO);
        return new ResponseEntity<>(productDTOBaseResponse, HttpStatus.valueOf(productDTOBaseResponse.getStatus()));
    }

    @PostMapping("/update-product-by-id")
    public ResponseEntity<BaseResponse> updateProductById(@RequestBody ProductDTO productDTO) {
        BaseResponse productDTOBaseResponse = productService.updateProductById(productDTO);
        return new ResponseEntity<>(productDTOBaseResponse, HttpStatus.valueOf(productDTOBaseResponse.getStatus()));
    }

    @PostMapping("/delete-product-by-id/{id}")
    public ResponseEntity<BaseResponse> deleteProductById(@PathVariable Long id) {
        BaseResponse productDTOBaseResponse = productService.deleteProductById(id);
        return new ResponseEntity<>(productDTOBaseResponse, HttpStatus.valueOf(productDTOBaseResponse.getStatus()));
    }


}
