package com.example.kyoraku.repository;

import com.example.kyoraku.model.entity.EntityProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<EntityProduct, Long> {
}
