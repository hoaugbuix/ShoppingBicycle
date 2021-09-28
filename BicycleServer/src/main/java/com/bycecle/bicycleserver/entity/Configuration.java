package com.bycecle.bicycleserver.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "configuration")
public class Configuration extends BaseEntity {
    private String bicycleChoice;
}
