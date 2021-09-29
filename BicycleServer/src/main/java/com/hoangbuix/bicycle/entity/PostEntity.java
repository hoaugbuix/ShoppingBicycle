package com.hoangbuix.bicycle.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "post")
@Table(name = "post")
public class PostEntity extends BaseEntity {
    private String title;

    private String content;

    private String slug;

    private String description;

    private String thumbnail;

    private int createdBy;

    private int updatedBy;

}
