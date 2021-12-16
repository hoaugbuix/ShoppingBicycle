package com.hoangbuix.bicycle.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "promotion")
@Table(name = "promotion")
public class PromotionEntity extends BaseEntity {
    private String name;

    private String couponCode;

    private String discountType;

    private int discountValue;

    private int maximumDiscountValue;

    private boolean isActive;

    private boolean isPublic;

}
