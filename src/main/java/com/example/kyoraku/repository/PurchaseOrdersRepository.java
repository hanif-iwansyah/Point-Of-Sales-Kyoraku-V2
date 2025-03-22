package com.example.kyoraku.repository;

import com.example.kyoraku.model.entity.EntityPurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrdersRepository extends JpaRepository<EntityPurchaseOrder, Long> {
}
