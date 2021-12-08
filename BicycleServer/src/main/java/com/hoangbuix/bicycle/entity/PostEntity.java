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
@Entity(name = "post")
@Table(name = "post")
public class PostEntity extends BaseEntity {
    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "slug")
    private String slug;

    @Column(name = "description")
    private String description;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "updated_by")
    private int updatedBy;

}
