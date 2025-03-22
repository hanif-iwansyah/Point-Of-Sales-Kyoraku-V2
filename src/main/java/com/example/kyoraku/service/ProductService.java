package com.example.kyoraku.service;

import com.example.kyoraku.model.dtos.ProductDTO;
import com.example.kyoraku.model.mapper.ProductMapper;
import com.example.kyoraku.model.response.BaseResponse;
import com.example.kyoraku.repository.ProductRepository;
import com.example.kyoraku.util.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public BaseResponse<ProductDTO> createProduct(ProductDTO productDTO) {
        try {
            return new BaseResponse<>(HttpStatus.CREATED.value(), "No", HttpStatus.CREATED.getReasonPhrase(), ProductMapper.toDTO(productRepository.save(ProductMapper.toEntity(productDTO))));
        } catch (OptimisticLockingFailureException e) {
            // Handle optimistic locking failure (version conflict)
            return new BaseResponse<>(HttpStatus.CONFLICT.value(), "Conflict", "The product was updated by another user. Please try again.", null);
        } catch (Exception e) {
            // Handle other exceptions (e.g., database issues)
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", e.getMessage(), null);
        }
    }

    public BaseResponse<ProductDTO> getProductById(Long id) {
        try {
            return new BaseResponse<>(HttpStatus.OK.value(), "No", "Success", ProductMapper.toDTO(productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id))));
        } catch (ResourceNotFoundException e) {
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", e.getMessage(), null);
        }
    }

    public BaseResponse<List<ProductDTO>> getAllProduct() {
        try {
            return new BaseResponse<>(HttpStatus.OK.value(), "No", "Success", ProductMapper.toListDTO(productRepository.findAll()));
        } catch (ResourceNotFoundException e) {
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", e.getMessage(), null);
        }
    }

    public BaseResponse<List<ProductDTO>> createBatchProduct(List<ProductDTO> listProductDTO) {
        try {
            return new BaseResponse<>(HttpStatus.CREATED.value(), "No", HttpStatus.CREATED.getReasonPhrase(), ProductMapper.toListDTO(productRepository.saveAll(ProductMapper.toListEntityDTO(listProductDTO))));
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", e.getMessage(), null);
        }
    }

    public BaseResponse<String> deleteProductById(Long id) {
        try {
            if (getProductById(id).getData().getProductId() != null) {
                productRepository.deleteById(id);
                return new BaseResponse<>(HttpStatus.GONE.value(), "No", HttpStatus.GONE.getReasonPhrase(), "Successfully deleted with id " + id);
            }
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", HttpStatus.NOT_FOUND.getReasonPhrase(), "Not found product with id " + id);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", HttpStatus.BAD_REQUEST.getReasonPhrase(), null);
        }
    }

    public BaseResponse<ProductDTO> updateProductById(ProductDTO productDTO) {
        try {
            if (getProductById(productDTO.getProductId()).getData().getProductId() != null) {
                //categoryRepository.deleteById(categoryDTO.getCategoryId());
                return new BaseResponse<>(HttpStatus.CREATED.value(), "No", HttpStatus.CREATED.getReasonPhrase(), ProductMapper.toDTO(productRepository.save(ProductMapper.toEntity(productDTO))));
            }
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", HttpStatus.NOT_FOUND.getReasonPhrase() + productDTO.getProductId(), null);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", HttpStatus.BAD_REQUEST.getReasonPhrase(), null);
        }
    }

}