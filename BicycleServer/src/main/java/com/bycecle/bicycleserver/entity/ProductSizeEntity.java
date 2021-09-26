package com.bycecle.bicycleserver.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "product_size")
@Table(name = "product_size")
public class ProductSizeEntity extends BaseEntity {
    @Column(name = "size")
    private int size;

    @Column(name = "quantity")
    private int quantity;
}
