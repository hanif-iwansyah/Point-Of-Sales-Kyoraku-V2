package com.example.kyoraku.repository;

import com.example.kyoraku.model.entity.EntityCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<EntityCategory, Long> {
}
