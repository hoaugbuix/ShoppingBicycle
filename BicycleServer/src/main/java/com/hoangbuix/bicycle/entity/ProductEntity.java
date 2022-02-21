package com.hoangbuix.bicycle.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
@Table(name = "product")
public class ProductEntity extends BaseEntity {
    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "description")
    private String description;

    @Column(name = "slug")
    private String slug;

    @Column(name = "brand_id")
    private int brandId;

    @Column(name = "price")
    private Double price;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "quantity_product")
    private int quantityProduct;

    @Column(name = "total_product")
    private int totalProduct;

    @Column(name = "total_sold")
    private int totalSold;

    @Column(name = "category_id")
    private int categoryId;
}
