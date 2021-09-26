package com.bycecle.bicycleserver.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "category")
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "")
    private String description;
}
