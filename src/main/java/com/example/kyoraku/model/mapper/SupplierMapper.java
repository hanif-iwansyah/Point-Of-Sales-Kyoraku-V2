package com.example.kyoraku.model.mapper;

import com.example.kyoraku.model.dtos.SupplierDTO;
import com.example.kyoraku.model.entity.EntitySupplier;

import java.util.List;
import java.util.stream.Collectors;

public class SupplierMapper {

    public static EntitySupplier toEntity(SupplierDTO supplierDTO) {
        EntitySupplier entitySupplier = new EntitySupplier();
        entitySupplier.setSupplierId(supplierDTO.getSupplierId() != null ? supplierDTO.getSupplierId() : 0L);
        entitySupplier.setSupplierName(supplierDTO.getSupplierName() != null ? supplierDTO.getSupplierName() : "");
        entitySupplier.setAddress(supplierDTO.getAddress() != null ? supplierDTO.getAddress() : "");
        entitySupplier.setContactEmail(supplierDTO.getContactEmail() != null ? supplierDTO.getContactEmail() : "");
        entitySupplier.setContactName(supplierDTO.getContactName() != null ? supplierDTO.getContactName() : "");
        entitySupplier.setContactPhone(supplierDTO.getContactPhone() != null ? supplierDTO.getContactPhone() : "");

        return entitySupplier;
    }

    public static SupplierDTO toDTO(EntitySupplier entitySupplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setSupplierId(entitySupplier.getSupplierId() != null ? entitySupplier.getSupplierId() : 0L);
        supplierDTO.setSupplierName(entitySupplier.getSupplierName() != null ? entitySupplier.getSupplierName() : "");
        supplierDTO.setAddress(entitySupplier.getAddress() != null ? entitySupplier.getAddress() : "");
        supplierDTO.setContactEmail(entitySupplier.getContactEmail() != null ? entitySupplier.getContactEmail() : "");
        supplierDTO.setContactName(entitySupplier.getContactName() != null ? entitySupplier.getContactName() : "");
        supplierDTO.setContactPhone(entitySupplier.getContactPhone() != null ? entitySupplier.getContactPhone() : "");
        return supplierDTO;
    }

    public static List<SupplierDTO> toListDTO(List<EntitySupplier> entitySupplier) {
        return entitySupplier.stream().map(suppliers -> {
            SupplierDTO supplierDTO = new SupplierDTO();
            supplierDTO.setSupplierId(suppliers.getSupplierId() != null ? suppliers.getSupplierId() : 0L);
            supplierDTO.setSupplierName(suppliers.getSupplierName() != null ? suppliers.getSupplierName() : "");
            supplierDTO.setAddress(suppliers.getAddress() != null ? suppliers.getAddress() : "");
            supplierDTO.setContactEmail(suppliers.getContactEmail() != null ? suppliers.getContactEmail() : "");
            supplierDTO.setContactName(suppliers.getContactName() != null ? suppliers.getContactName() : "");
            supplierDTO.setContactPhone(suppliers.getContactPhone() != null ? suppliers.getContactPhone() : "");

            return supplierDTO;
        }).collect(Collectors.toList());
    }

    public static List<EntitySupplier> toListEntityDTO(List<SupplierDTO> supplierDTOList) {
        return supplierDTOList.stream().map(supplier -> {
            EntitySupplier setEntitySupplier = new EntitySupplier();
            setEntitySupplier.setSupplierId(supplier.getSupplierId() != null ? supplier.getSupplierId() : 0L);
            setEntitySupplier.setSupplierName(supplier.getSupplierName());
            setEntitySupplier.setAddress(supplier.getAddress());
            setEntitySupplier.setContactEmail(supplier.getContactEmail());
            setEntitySupplier.setContactName(supplier.getContactName());
            setEntitySupplier.setContactPhone(supplier.getContactPhone());

            return setEntitySupplier;
        }).collect(Collectors.toList());
    }


}