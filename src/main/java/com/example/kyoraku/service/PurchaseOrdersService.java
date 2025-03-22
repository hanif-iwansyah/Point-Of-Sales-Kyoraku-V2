package com.example.kyoraku.service;

import com.example.kyoraku.model.dtos.PurchaseOrderDTO;
import com.example.kyoraku.model.mapper.PurchaseOrderMapper;
import com.example.kyoraku.model.response.BaseResponse;
import com.example.kyoraku.repository.PurchaseOrdersRepository;
import com.example.kyoraku.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrdersService {

    @Autowired
    PurchaseOrdersRepository purchaseOrdersRepo;

    public BaseResponse<List<PurchaseOrderDTO>> getAllPurchaseOrders() {
        try {
            return new BaseResponse<>(HttpStatus.OK.value(), "No", "Success", PurchaseOrderMapper.toListDTO(purchaseOrdersRepo.findAll()));
        } catch (ResourceNotFoundException e) {
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", e.getMessage(), null);
        }
    }

    public BaseResponse<PurchaseOrderDTO> getPurchaseOrdersById(Long id) {
        try {
            return new BaseResponse<>(HttpStatus.OK.value(), "No", "Success", PurchaseOrderMapper.toDTO(purchaseOrdersRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("purchase order", "id", id))));
        } catch (ResourceNotFoundException e) {
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", e.getMessage(), null);
        }
    }

    public BaseResponse<PurchaseOrderDTO> createPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
        try {
            return new BaseResponse<>(HttpStatus.CREATED.value(), "No", HttpStatus.CREATED.getReasonPhrase(), PurchaseOrderMapper.toDTO(purchaseOrdersRepo.save(PurchaseOrderMapper.toEntity(purchaseOrderDTO))));
        } catch (OptimisticLockingFailureException e) {
            return new BaseResponse<>(HttpStatus.CONFLICT.value(), "Conflict", "The purchase order was updated by another user. Please try again.", null);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", e.getMessage(), null);
        }
    }

    public BaseResponse<String> deletePurchaseOrderById(Long id) {
        try {
            if (getPurchaseOrdersById(id).getData().getOrderId() != null) {
                purchaseOrdersRepo.deleteById(id);
                return new BaseResponse<>(HttpStatus.GONE.value(), "No", HttpStatus.GONE.getReasonPhrase(), "Successfully deleted with id " + id);
            }
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", HttpStatus.NOT_FOUND.getReasonPhrase(), "Not found purchase order with id " + id);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", HttpStatus.BAD_REQUEST.getReasonPhrase(), null);
        }
    }

    public BaseResponse<PurchaseOrderDTO> updatePurchaseOrderById(PurchaseOrderDTO purchaseOrderDTO) {
        try {
            if (getPurchaseOrdersById(purchaseOrderDTO.getOrderId()).getData().getOrderId() != null) {
                //categoryRepository.deleteById(categoryDTO.getCategoryId());
                return new BaseResponse<>(HttpStatus.CREATED.value(), "No", HttpStatus.CREATED.getReasonPhrase(), PurchaseOrderMapper.toDTO(purchaseOrdersRepo.save(PurchaseOrderMapper.toEntity(purchaseOrderDTO))));
            }
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", HttpStatus.NOT_FOUND.getReasonPhrase() + purchaseOrderDTO.getOrderId(), null);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", HttpStatus.BAD_REQUEST.getReasonPhrase(), null);
        }
    }

}

