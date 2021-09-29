package com.hoangbuix.bicycle.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "promotion")
@Table(name = "promotion")
public class PromotionEntity extends BaseEntity {
    private String name;

    private String couponCode;

    private int discountType;

    private int discountValue;

    private int maximumDiscountValue;

    private boolean isActive;

    private boolean isPublic;
}
