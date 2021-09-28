package com.bycecle.bicycleserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "product_category")
@Table(name = "product_category")
public class ProductCategoryEntity extends BaseEntity {

//    @ManyToMany(cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "post_tag",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id")
//    )
//    private List<CategoryEntity> tags = new ArrayList<>();
}
