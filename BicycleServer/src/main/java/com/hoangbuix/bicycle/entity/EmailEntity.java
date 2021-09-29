package com.hoangbuix.bicycle.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "email")
@Table(name = "email")
public class EmailEntity extends BaseEntity {
    @Column(name = "content_email")
    private String contentEmail;

    @Column(name = "seen")
    private boolean seen;
}
