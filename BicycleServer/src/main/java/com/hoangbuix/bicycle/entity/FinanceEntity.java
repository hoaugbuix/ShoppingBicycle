package com.hoangbuix.bicycle.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "finance")
@Table(name = "finance")
public class FinanceEntity extends BaseEntity {
    private int amount;

    private int orderId;
}
