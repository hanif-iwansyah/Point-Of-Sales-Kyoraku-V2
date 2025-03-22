package com.example.kyoraku.repository;

import com.example.kyoraku.model.entity.EntitySupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<EntitySupplier, Long> {
}
