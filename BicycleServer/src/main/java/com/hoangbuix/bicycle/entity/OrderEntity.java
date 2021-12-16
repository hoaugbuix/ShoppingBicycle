package com.hoangbuix.bicycle.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "orders")
@Table(name = "orders")
public class OrderEntity extends BaseEntity {
    private String note;
    private float productPrice;
    private int promotionId;
    private int productId;
    private int productSize;
    private String receiverName;
    private String receiverAddress;
    private String receiverPhone;
    private int status;
    private int totalPrice;
    private int buyer;
    private int createdBy;
    private int modifiedBy;
}
