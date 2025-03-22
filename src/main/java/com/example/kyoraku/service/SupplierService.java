package com.example.kyoraku.service;

import com.example.kyoraku.model.dtos.SupplierDTO;
import com.example.kyoraku.model.mapper.SupplierMapper;
import com.example.kyoraku.model.response.BaseResponse;
import com.example.kyoraku.repository.SupplierRepository;
import com.example.kyoraku.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    //@Transactional
    public BaseResponse<SupplierDTO> createSupplier(SupplierDTO supplierDTO) {
        try {
            return new BaseResponse<>(HttpStatus.CREATED.value(), "No", HttpStatus.CREATED.getReasonPhrase(), SupplierMapper.toDTO(supplierRepository.save(SupplierMapper.toEntity(supplierDTO))));
        } catch (OptimisticLockingFailureException e) {
            return new BaseResponse<>(HttpStatus.CONFLICT.value(), "Conflict", "The supplier was updated by another user. Please try again.", null);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", e.getMessage(), null);
        }
    }

    public BaseResponse<SupplierDTO> getSupplierById(Long id) {
        try {
            return new BaseResponse<>(HttpStatus.OK.value(), "No", "Success", SupplierMapper.toDTO(supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier", "id", id))));
        } catch (ResourceNotFoundException e) {
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", e.getMessage(), null);
        }
    }

    public BaseResponse<List<SupplierDTO>> getAllSupplier() {
        try {
            return new BaseResponse<>(HttpStatus.OK.value(), "No", "Success", SupplierMapper.toListDTO(supplierRepository.findAll()));
        } catch (ResourceNotFoundException e) {
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", e.getMessage(), null);
        }
    }

    public BaseResponse<List<SupplierDTO>> createBatchSuppier(List<SupplierDTO> supplierDTOList) {
        try {
            return new BaseResponse<>(HttpStatus.CREATED.value(), "No", HttpStatus.CREATED.getReasonPhrase(), SupplierMapper.toListDTO(supplierRepository.saveAll(SupplierMapper.toListEntityDTO(supplierDTOList))));
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", e.getMessage(), null);
        }
    }

    public BaseResponse<String> deleteSupplierById(Long id) {
        try {
            if (getSupplierById(id).getData().getSupplierId() != null) {
                supplierRepository.deleteById(id);
                return new BaseResponse<>(HttpStatus.GONE.value(), "No", HttpStatus.GONE.getReasonPhrase(), "Successfully deleted with id " + id);
            }
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", HttpStatus.NOT_FOUND.getReasonPhrase(), "Not found supplier with id " + id);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", HttpStatus.BAD_REQUEST.getReasonPhrase(), null);
        }
    }

    public BaseResponse<SupplierDTO> updateSupplierById(SupplierDTO supplierDTO) {
        try {
            if (getSupplierById(supplierDTO.getSupplierId()).getData().getSupplierId() != null) {
                return new BaseResponse<>(HttpStatus.CREATED.value(), "No", HttpStatus.CREATED.getReasonPhrase(), SupplierMapper.toDTO(supplierRepository.save(SupplierMapper.toEntity(supplierDTO))));
            }
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", HttpStatus.NOT_FOUND.getReasonPhrase() + supplierDTO.getSupplierId(), null);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", HttpStatus.BAD_REQUEST.getReasonPhrase(), null);
        }
    }


}
