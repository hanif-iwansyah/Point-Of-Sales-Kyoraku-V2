package com.example.kyoraku.controller;

import com.example.kyoraku.model.dtos.CategoryDTO;
import com.example.kyoraku.model.response.BaseResponse;
import com.example.kyoraku.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create-category")
    public ResponseEntity<BaseResponse> createCategory(@RequestBody CategoryDTO categoryDTO) {
        BaseResponse categoryDTOBaseResponse = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(categoryDTOBaseResponse, HttpStatus.valueOf(categoryDTOBaseResponse.getStatus()));
    }

    @PostMapping("/create-batch-category")
    public ResponseEntity<BaseResponse> createBatchCategory(@RequestBody List<CategoryDTO> entityCategory) {
        BaseResponse categoryDTOBaseResponse = categoryService.createBatchCategory(entityCategory);
        return new ResponseEntity<>(categoryDTOBaseResponse, HttpStatus.valueOf(categoryDTOBaseResponse.getStatus()));
    }

    @GetMapping("/get-all-category")
    public ResponseEntity<BaseResponse> getAllCategory() {
        BaseResponse categoryDTOBaseResponse = categoryService.getAllCategory();
        return new ResponseEntity<>(categoryDTOBaseResponse, HttpStatus.valueOf(categoryDTOBaseResponse.getStatus()));
    }

    @GetMapping("/get-category-by-id/{id}")
    public ResponseEntity<BaseResponse> getCategoryById(@PathVariable Long id) {
        BaseResponse categoryDTOBaseResponse = categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryDTOBaseResponse, HttpStatus.valueOf(categoryDTOBaseResponse.getStatus()));
    }

    @PostMapping("/update-category-by-id")
    public ResponseEntity<BaseResponse> updateCategoryById(@RequestBody CategoryDTO categoryDTO) {
        BaseResponse categoryDTOBaseResponse = categoryService.updateCategoryById(categoryDTO);
        return new ResponseEntity<>(categoryDTOBaseResponse, HttpStatus.valueOf(categoryDTOBaseResponse.getStatus()));
    }

    @PostMapping("/delete-category-by-id/{id}")
    public ResponseEntity<BaseResponse> deleteCategoryById(@PathVariable Long id) {
        BaseResponse categoryDTOBaseResponse = categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(categoryDTOBaseResponse, HttpStatus.valueOf(categoryDTOBaseResponse.getStatus()));
    }

}
