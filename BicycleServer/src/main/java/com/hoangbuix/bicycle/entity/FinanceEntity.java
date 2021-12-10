package com.hoangbuix.bicycle.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "finance")
@Table(name = "finance")
public class FinanceEntity extends BaseEntity {
    private int amount;

    private int orderId;
}
