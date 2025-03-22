package com.example.kyoraku.model.mapper;

import com.example.kyoraku.model.dtos.CategoryDTO;
import com.example.kyoraku.model.dtos.ProductDTO;
import com.example.kyoraku.model.dtos.SupplierDTO;
import com.example.kyoraku.model.entity.EntityCategory;
import com.example.kyoraku.model.entity.EntityProduct;
import com.example.kyoraku.model.entity.EntitySupplier;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static EntityProduct toEntity(ProductDTO productDTO) {
        EntityProduct entityProduct = new EntityProduct();
        entityProduct.setProductId(productDTO.getProductId() != null ? productDTO.getProductId() : 0L);
        entityProduct.setProductName(productDTO.getProductName() != null ? productDTO.getProductName() : "");
        entityProduct.setDescription(productDTO.getDescription() != null ? productDTO.getDescription() : "");
        entityProduct.setPrice(productDTO.getPrice() != null ? productDTO.getPrice() : BigDecimal.ZERO);
        entityProduct.setQuantityInStock(productDTO.getQuantityInStock() != null ? productDTO.getQuantityInStock() : BigDecimal.ZERO);

        EntityCategory setEntityCategory = new EntityCategory();
        setEntityCategory.setCategoryId(productDTO.getCategoryDTO().getCategoryId() != null ? productDTO.getCategoryDTO().getCategoryId() : 0L);
        setEntityCategory.setCategoryName(productDTO.getCategoryDTO().getCategoryName() != null ? productDTO.getCategoryDTO().getCategoryName() : "");
        setEntityCategory.setDescription(productDTO.getCategoryDTO().getDescription() != null ? productDTO.getCategoryDTO().getDescription() : "");
        entityProduct.setCategory(setEntityCategory);

        EntitySupplier setEntitySupplier = new EntitySupplier();
        setEntitySupplier.setSupplierId(productDTO.getSupplierDTO().getSupplierId() != null ? productDTO.getSupplierDTO().getSupplierId() : 0L);
        setEntitySupplier.setSupplierName(productDTO.getSupplierDTO().getSupplierName() != null ? productDTO.getSupplierDTO().getSupplierName() : "");
        setEntitySupplier.setAddress(productDTO.getSupplierDTO().getAddress() != null ? productDTO.getSupplierDTO().getAddress() : "");
        setEntitySupplier.setContactEmail(productDTO.getSupplierDTO().getContactEmail() != null ? productDTO.getSupplierDTO().getContactEmail() : "");
        setEntitySupplier.setContactName(productDTO.getSupplierDTO().getContactName() != null ? productDTO.getSupplierDTO().getContactName() : "");
        setEntitySupplier.setContactPhone(productDTO.getSupplierDTO().getContactPhone() != null ? productDTO.getSupplierDTO().getContactPhone() : "");
        entityProduct.setSupplier(setEntitySupplier);

        return entityProduct;
    }

    public static ProductDTO toDTO(EntityProduct entityProduct) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(entityProduct.getProductId() != null ? entityProduct.getProductId() : 0L);
        productDTO.setProductName(entityProduct.getProductName() != null ? entityProduct.getProductName() : "");
        productDTO.setDescription(entityProduct.getDescription() != null ? entityProduct.getDescription() : "");
        productDTO.setPrice(entityProduct.getPrice() != null ? entityProduct.getPrice() : BigDecimal.ZERO);
        productDTO.setQuantityInStock(entityProduct.getQuantityInStock() != null ? entityProduct.getQuantityInStock() : BigDecimal.ZERO);

        CategoryDTO setCategoryDTO = new CategoryDTO();
        setCategoryDTO.setCategoryId(entityProduct.category.getCategoryId());
        setCategoryDTO.setCategoryName(entityProduct.category.getCategoryName());
        setCategoryDTO.setDescription(entityProduct.category.getDescription());
        productDTO.setCategoryDTO(setCategoryDTO);

        SupplierDTO setSupplierDTO = new SupplierDTO();
        setSupplierDTO.setSupplierId(entityProduct.supplier.getSupplierId());
        setSupplierDTO.setSupplierName(entityProduct.supplier.getSupplierName());
        setSupplierDTO.setAddress(entityProduct.supplier.getAddress());
        setSupplierDTO.setContactEmail(entityProduct.supplier.getContactEmail());
        setSupplierDTO.setContactName(entityProduct.supplier.getContactName());
        setSupplierDTO.setContactPhone(entityProduct.supplier.getContactPhone());
        productDTO.setSupplierDTO(setSupplierDTO);

        return productDTO;
    }

    public static List<ProductDTO> toListDTO(List<EntityProduct> entityProduct) {
        return entityProduct.stream().map(products -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(products.getProductId() != null ? products.getProductId() : 0L);
            productDTO.setProductName(products.getProductName() != null ? products.getProductName() : "");
            productDTO.setDescription(products.getDescription() != null ? products.getDescription() : "");
            productDTO.setPrice(products.getPrice() != null ? products.getPrice() : BigDecimal.ZERO);
            productDTO.setQuantityInStock(products.getQuantityInStock() != null ? products.getQuantityInStock() : BigDecimal.ZERO);

            CategoryDTO setCategoryDTO = new CategoryDTO();
            setCategoryDTO.setCategoryId(products.category.getCategoryId());
            setCategoryDTO.setCategoryName(products.category.getCategoryName());
            setCategoryDTO.setDescription(products.category.getDescription());
            productDTO.setCategoryDTO(setCategoryDTO);

            SupplierDTO setSupplierDTO = new SupplierDTO();
            setSupplierDTO.setSupplierId(products.supplier.getSupplierId());
            setSupplierDTO.setSupplierName(products.supplier.getSupplierName());
            setSupplierDTO.setAddress(products.supplier.getAddress());
            setSupplierDTO.setContactEmail(products.supplier.getContactEmail());
            setSupplierDTO.setContactName(products.supplier.getContactName());
            setSupplierDTO.setContactPhone(products.supplier.getContactPhone());
            productDTO.setSupplierDTO(setSupplierDTO);

            return productDTO;
        }).collect(Collectors.toList());
    }

    public static List<EntityProduct> toListEntityDTO(List<ProductDTO> productDTOList) {
        return productDTOList.stream().map(product -> {
            EntityProduct entityProduct = new EntityProduct();
            entityProduct.setProductId(product.getProductId() != null ? product.getProductId() : 0L);
            entityProduct.setProductName(product.getProductName() != null ? product.getProductName() : "");
            entityProduct.setDescription(product.getDescription() != null ? product.getDescription() : "");
            entityProduct.setPrice(product.getPrice() != null ? product.getPrice() : BigDecimal.ZERO);
            entityProduct.setQuantityInStock(product.getQuantityInStock() != null ? product.getQuantityInStock() : BigDecimal.ZERO);

            EntityCategory setEntityCategory = new EntityCategory();
            setEntityCategory.setCategoryId(product.getCategoryDTO().getCategoryId());
            setEntityCategory.setCategoryName(product.getCategoryDTO().getCategoryName());
            setEntityCategory.setDescription(product.getCategoryDTO().getDescription());
            entityProduct.setCategory(setEntityCategory);

            EntitySupplier setEntitySupplier = new EntitySupplier();
            setEntitySupplier.setSupplierId(product.getSupplierDTO().getSupplierId());
            setEntitySupplier.setSupplierName(product.getSupplierDTO().getSupplierName());
            setEntitySupplier.setAddress(product.getSupplierDTO().getAddress());
            setEntitySupplier.setContactEmail(product.getSupplierDTO().getContactEmail());
            setEntitySupplier.setContactName(product.getSupplierDTO().getContactName());
            setEntitySupplier.setContactPhone(product.getSupplierDTO().getContactPhone());
            entityProduct.setSupplier(setEntitySupplier);

            return entityProduct;
        }).collect(Collectors.toList());
    }

}