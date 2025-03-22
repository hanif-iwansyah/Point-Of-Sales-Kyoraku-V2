package com.example.kyoraku.model.mapper;

import com.example.kyoraku.model.dtos.CategoryDTO;
import com.example.kyoraku.model.entity.EntityCategory;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static CategoryDTO toDTO(EntityCategory entityCategory) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(entityCategory.getCategoryId() != null ? entityCategory.getCategoryId() : 0L);
        categoryDTO.setCategoryName(entityCategory.getCategoryName() != null ? entityCategory.getCategoryName() : "");
        categoryDTO.setDescription(entityCategory.getDescription() != null ? entityCategory.getDescription() : "");
        return categoryDTO;
    }

    public static List<CategoryDTO> toListDTO(List<EntityCategory> entityCategories) {
        return entityCategories.stream().map(category -> {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setCategoryId(category.getCategoryId() != null ? category.getCategoryId() : 0L);
            categoryDTO.setCategoryName(category.getCategoryName() != null ? category.getCategoryName() : "");
            categoryDTO.setDescription(category.getDescription() != null ? category.getDescription() : "");
            return categoryDTO;
        }).collect(Collectors.toList());
    }

    public static List<EntityCategory> toListEntityDTO(List<CategoryDTO> categoryDTOList) {
        return categoryDTOList.stream().map(category -> {
            EntityCategory entityCategory = new EntityCategory();
            entityCategory.setCategoryId(category.getCategoryId() != null ? category.getCategoryId() : 0L);
            entityCategory.setCategoryName(category.getCategoryName() != null ? category.getCategoryName() : "");
            entityCategory.setDescription(category.getDescription() != null ? category.getDescription() : "");
            return entityCategory;
        }).collect(Collectors.toList());
    }

    public static EntityCategory toEntity(CategoryDTO categoryDTO) {
        EntityCategory entityCategory = new EntityCategory();
        entityCategory.setCategoryId(categoryDTO.getCategoryId() != null ? categoryDTO.getCategoryId() : 0L);
        entityCategory.setCategoryName(categoryDTO.getCategoryName() != null ? categoryDTO.getCategoryName() : "");
        entityCategory.setDescription(categoryDTO.getDescription() != null ? categoryDTO.getDescription() : "");
        return entityCategory;
    }

}

//Rizaldi Irvana taijutsu

//        return CategoryDTO.builder()
//                .categoryId(entityCategory.getCategoryId() != null ? entityCategory.getCategoryId() : 0L)
//                .categoryName(entityCategory.getCategoryName() != null ? entityCategory.getCategoryName() : "")
//                .description(entityCategory.getDescription() != null ? entityCategory.getDescription() : "")
//                .build();