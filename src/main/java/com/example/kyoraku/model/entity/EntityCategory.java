package com.example.kyoraku.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name = "category")
public class EntityCategory {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //@Column(name = "category_id")
    @JsonProperty("category_id")
    private long category_id;

    @Column(name = "category_name")
    @JsonProperty("category_name")
    private String categoryName;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    public EntityCategory() {

    }


    public Long getCategoryId() {
        return category_id;
    }

    public void setCategoryId(Long categoryId) {
        this.category_id = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
