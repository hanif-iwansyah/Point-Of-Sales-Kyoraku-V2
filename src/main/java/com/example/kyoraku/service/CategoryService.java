package com.example.kyoraku.service;

import com.example.kyoraku.model.dtos.CategoryDTO;
import com.example.kyoraku.model.mapper.CategoryMapper;
import com.example.kyoraku.model.response.BaseResponse;
import com.example.kyoraku.repository.CategoryRepository;
import com.example.kyoraku.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public BaseResponse<CategoryDTO> getCategoryById(Long id) {
        try {
            return new BaseResponse<>(HttpStatus.OK.value(), "No", "Success", CategoryMapper.toDTO(categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id))));
        } catch (ResourceNotFoundException e) {
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", e.getMessage(), null);
        }
    }

    public BaseResponse<List<CategoryDTO>> getAllCategory() {
        try {
            return new BaseResponse<>(HttpStatus.OK.value(), "No", "Success", CategoryMapper.toListDTO(categoryRepository.findAll()));
        } catch (ResourceNotFoundException e) {
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", e.getMessage(), null);
        }
    }

    public BaseResponse<CategoryDTO> createCategory(CategoryDTO categoryDTO) {
        try {
            return new BaseResponse<>(HttpStatus.CREATED.value(), "No", HttpStatus.CREATED.getReasonPhrase(), CategoryMapper.toDTO(categoryRepository.save(CategoryMapper.toEntity(categoryDTO))));
        } catch (OptimisticLockingFailureException e) {
            return new BaseResponse<>(HttpStatus.CONFLICT.value(), "Conflict", "The category was updated by another user. Please try again.", null);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", e.getMessage(), null);
        }
    }

    public BaseResponse<List<CategoryDTO>> createBatchCategory(List<CategoryDTO> listCategoryDTO) {
        try {
            return new BaseResponse<>(HttpStatus.CREATED.value(), "No", HttpStatus.CREATED.getReasonPhrase(), CategoryMapper.toListDTO(categoryRepository.saveAll(CategoryMapper.toListEntityDTO(listCategoryDTO))));
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", e.getMessage(), null);
        }
    }

    public BaseResponse<String> deleteCategoryById(Long id) {
        try {
            if (getCategoryById(id).getData().getCategoryId() != null) {
                categoryRepository.deleteById(id);
                return new BaseResponse<>(HttpStatus.GONE.value(), "No", HttpStatus.GONE.getReasonPhrase(), "Successfully deleted with id " + id);
            }
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", HttpStatus.NOT_FOUND.getReasonPhrase(), "Not found category with id " + id);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", HttpStatus.BAD_REQUEST.getReasonPhrase(), null);
        }
    }

    public BaseResponse<CategoryDTO> updateCategoryById(CategoryDTO categoryDTO) {
        try {
            if (getCategoryById(categoryDTO.getCategoryId()).getData().getCategoryId() != null) {
                return new BaseResponse<>(HttpStatus.CREATED.value(), "No", HttpStatus.CREATED.getReasonPhrase(), CategoryMapper.toDTO(categoryRepository.save(CategoryMapper.toEntity(categoryDTO))));
            }
            return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Not Found", HttpStatus.NOT_FOUND.getReasonPhrase() + categoryDTO.getCategoryId(), null);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad Request", HttpStatus.BAD_REQUEST.getReasonPhrase(), null);
        }
    }
}
